package com.aurionpro.payments.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.aurionpro.payments.account.model.Account;
import com.aurionpro.payments.account.model.AccountType;
import com.aurionpro.payments.account.model.CurrentAccount;
import com.aurionpro.payments.account.model.SavingAccount;
import com.aurionpro.payments.account.model.Transaction;
import com.aurionpro.payments.account.model.TransactionMethods;
import com.aurionpro.payments.account.model.TransactionType;
import com.aurionpro.payments.exceptions.MinAccountBalanceException;
import com.aurionpro.payments.exceptions.NegativeInputException;
import com.aurionpro.payments.model.Credit;
import com.aurionpro.payments.model.CreditCardDetails;
import com.aurionpro.payments.model.Debit;
import com.aurionpro.payments.model.DebitCardDetails;
import com.aurionpro.payments.model.Paypal;
import com.aurionpro.payments.model.PaypalDetails;
import com.aurionpro.payments.model.ProcessPayment;
import com.aurionpro.payments.model.UPI;
import com.aurionpro.payments.model.UPIDetails;

public class PaymetTest {
	static AccountType accoutType;
	static TransactionType transactionType;
	static Account sender;
	static Account receiver;
	static Account tempAcc;
	public static List <Account> accountList = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Dheeren Paymet getway");

		System.out.println("Createing intial 2 account ");
		System.out.println();
		System.out.println("1st account");
		sender = createAccount(scanner);
		accountList.add(sender);

		System.out.println();
		System.out.println("2nd account");
		receiver = createAccount(scanner);
		accountList.add(receiver);
		SwitchAccount(scanner);

		showMenu(scanner);

	}

	private static void showMenu(Scanner scanner) {
		while (true) {
			System.out.println();

			System.out.println(" 1> Switch Account");
			System.out.println(" 2> View Details ");
			System.out.println(" 3> Transaction History ");
			System.out.println(" 4> Deposit ");
			System.out.println(" 5> Withdraw ");
			System.out.println(" 6> Transfer ");
			System.out.println(" 7> Sorting by Balnce ");
			System.out.println(" 8> Add Account");
			
			System.out.println(" 9> Exit ");
			
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			try {
				if (choice < 0) {
					throw new NegativeInputException(choice);
				}
				switch (choice) {
				case 1:
					SwitchAccount(scanner);
					break;
				case 2:
					System.out.println();
					System.out.println("Viewing account details...");
					System.out.println(sender);
					break;
				case 3:
					System.out.println();
					System.out.println("Showing transaction history...");
					sender.history();
					break;
				case 4:

					System.out.println();
					System.out.println("Depositing money...");
					System.out.println("Enter Deopist Amount ");
					int amount = scanner.nextInt();
					String transactionID = createTransactionId();
					sender.deposit(amount);
					Transaction transaction = new Transaction(TransactionType.DEPOSIT, LocalDate.now(), transactionID,
							amount);
					transaction.markAsDone();
					sender.addTransaction(transaction);
					break;

				case 5:

					System.out.println();
					System.out.println("Withdrawing money...");
					System.out.println("Enter Withdraw Amount");
					int amount2 = scanner.nextInt();
					String transactionID2 = createTransactionId();
					Transaction transaction2 = new Transaction(TransactionType.WITHDRAW, LocalDate.now(),
							transactionID2, amount2);
					try {
						if (sender.withdrawValidation(amount2)) {
							sender.withdraw(amount2);
							transaction2.markAsDone();
						} else {
							transaction2.markAsFailed();
						}
					} catch (MinAccountBalanceException e) {
						transaction2.markAsFailed();
						System.out.println(e.getMessage());
					}
					sender.addTransaction(transaction2);

					break;
				case 6:
					System.out.println("Transferring money... ");
					transferringMoney(scanner);
					break;
				case 7:
					System.out.println("Sorting by Balnce... ");
					Collections.sort(accountList);
					for(Account a : accountList) {
						System.out.println(a);
					}
					break;
				case 8:
					System.out.println("Create new Account...");
					accountList.add(createAccount(scanner));
					break;
				case 9:
					System.out.println("Exiting...");
					scanner.close();
					return;
				default:
					System.out.println("Invalid choice. Please try again.");
				}

			} catch (NegativeInputException e) {
				System.out.println(e.getMessage());
				return;
			}

		}

	}

	private static void transferringMoney(Scanner scanner) {
		ProcessPayment process = new ProcessPayment();
		System.out.println("Enter Transferring  Amount ");
		int amount = scanner.nextInt();
		System.out.println();
		System.out.println("Select Mode of Transfer ");
		System.out.println(" 1> By Debit Card");
		System.out.println(" 2> By Credit Card");
		System.out.println(" 3> By UPI");
		System.out.println(" n> By Paypal");
		int selectedMode = scanner.nextInt();

		switch (selectedMode) {
		case 1:
			System.out.println("Transferring Money to : " + receiver.getName() + "by Debit Card");
			payByDebitCard(scanner, process, amount);
			break;
		case 2:
			System.out.println("Transferring Money to : " + receiver.getName() + "by Credit Card");
			payByCreditCard(scanner, process, amount);
			break;
		case 3:
			System.out.println("Transferring Money to : " + receiver.getName() + "by UPI");
			payByUPICard(scanner, process, amount);
			break;
		default:
			System.out.println("Transferring Money to : " + receiver.getName() + "by Paypal");
			payByPaypalCard(scanner, process, amount);
			break;
		}

	}

	private static void payByPaypalCard(Scanner scanner, ProcessPayment process, int amount) {
		Paypal paypal = new Paypal();
		PaypalDetails detail = new PaypalDetails();

		// Get email from user
		System.out.print("Enter PayPal Email: ");
		String email = scanner.next();
		detail.setEmail(email);

		String token = "567vdhf93798039$#%^*";
		detail.setToken(token);

		String transactionID = createTransactionId();

		Transaction transaction = new Transaction(TransactionType.TRANSFER, TransactionMethods.PAYPAL, LocalDate.now(),
				transactionID, sender.getName(), receiver.getName(), amount);
		try {
			if (process.paymentProcess(detail, paypal, amount, sender, receiver)) {
				transaction.markAsDone();
				System.out.println("PayPal Payment Successful!");
			} else {
				transaction.markAsFailed();
				System.out.println("PayPal Payment Failed!");
			}

		} catch (MinAccountBalanceException e) {
			transaction.markAsFailed();
			System.err.println(e.getMessage());
		} catch (RuntimeException e) {
			transaction.markAsFailed();
			System.out.println("❌ Unexpected Payment Error: " + e.getMessage());
		}

		sender.addTransaction(transaction);
	}

	private static void payByUPICard(Scanner scanner, ProcessPayment process, int amount) {
		UPI upi = new UPI();
		UPIDetails detail = new UPIDetails();

		System.out.print("Enter UPI ID: ");
		String upiId = scanner.next();
		detail.setUpiId(upiId);

		System.out.print("Enter PIN: ");
		String pin = scanner.next();
		detail.setPin(pin);

		int generatedOtp = (int) (Math.random() * 9000) + 1000; // random 4-digit OTP
		System.out.println("Otp :" + generatedOtp);
		detail.setBackedOTP(generatedOtp);

		System.out.println("OTP sent to registered device: " + generatedOtp);
		System.out.print("Enter OTP: ");
		int enteredOtp = scanner.nextInt();
		detail.setOtp(enteredOtp);

		String transactionID = createTransactionId();
		Transaction transaction = new Transaction(TransactionType.TRANSFER, TransactionMethods.UPI, LocalDate.now(),
				transactionID, sender.getName(), receiver.getName(), amount);
		try {
			if (process.paymentProcess(detail, upi, amount, sender, receiver)) {
				transaction.markAsDone();
			} else {
				transaction.markAsFailed();
				System.out.println("Payment Failed!");
			}
		} catch (MinAccountBalanceException e) {
			transaction.markAsFailed();
			System.err.println(e.getMessage());
		} catch (RuntimeException e) {
			transaction.markAsFailed();
			System.out.println("❌ Unexpected Payment Error: " + e.getMessage());
		}

		sender.addTransaction(transaction);
	}

	private static void payByCreditCard(Scanner scanner, ProcessPayment process, int amount) {

		Credit credit = new Credit();
		CreditCardDetails detail = new CreditCardDetails();

		System.out.print("Enter Debit Card Number (16 digits): ");
		String cardNumber = scanner.next();
		detail.setCardnNumber(cardNumber);

		System.out.print("Enter Expiry Date (MM/YY): ");
		String expiry = scanner.next();
		detail.setExpiry(expiry);

		System.out.print("Enter CVV (3 digits): ");
		String cvv = scanner.next();
		detail.setCvv(cvv);

		System.out.println("Payment via Debit Card initialized.");
		String transactionID = createTransactionId();

		Transaction transaction = new Transaction(TransactionType.TRANSFER, TransactionMethods.CREDIT, LocalDate.now(),
				transactionID, sender.getName(), receiver.getName(), amount);
		try {
			if (process.paymentProcess(detail, credit, amount, sender, receiver)) {
				transaction.markAsDone();
				sender.addTransaction(transaction);
				return;
			}
		} catch (MinAccountBalanceException e) {

			System.err.println(e.getMessage());
		} catch (RuntimeException e) {

			System.out.println("❌ Unexpected Payment Error: " + e.getMessage());
		}

		transaction.markAsFailed();
		sender.addTransaction(transaction);
	}

	private static void payByDebitCard(Scanner scanner, ProcessPayment process, int amount) {
		Debit debit = new Debit();
		DebitCardDetails detail = new DebitCardDetails();

		System.out.print("Enter Debit Card Number (16 digits): ");
		String cardNumber = scanner.next();
		detail.setCardnNumber(cardNumber);

		System.out.print("Enter Expiry Date (MM/YY): ");
		String expiry = scanner.next();
		detail.setExpiry(expiry);

		System.out.print("Enter CVV (3 digits): ");
		String cvv = scanner.next();
		detail.setCvv(cvv);

		System.out.println("Payment via Debit Card initialized.");
		String transactionID = createTransactionId();

		Transaction transaction = new Transaction(TransactionType.TRANSFER, TransactionMethods.DEBIT, LocalDate.now(),
				transactionID, sender.getName(), receiver.getName(), amount);
		try {
			if (process.paymentProcess(detail, debit, amount, sender, receiver)) {
				transaction.markAsDone();
				sender.addTransaction(transaction);
				return;
			}
		} catch (MinAccountBalanceException e) {

			System.err.println(e.getMessage());
		} catch (RuntimeException e) {

			System.out.println("❌ Unexpected Payment Error: " + e.getMessage());
		}

		transaction.markAsFailed();
		sender.addTransaction(transaction);
	}

	private static String createTransactionId() {

		Random random = new Random();
		int min = 100000;
		int max = 999999;
		int randomNumber = random.nextInt(max - min + 1) + min;
		return "TXP-P1-00-" + sender.getName() + "-" + LocalDate.now() + "-" + randomNumber;

	}

	private static void SwitchAccount(Scanner scanner) {
		while (true) {
			System.out.println();
			System.out.println("Select one account");
			System.out.println("  1> " + sender.getName() + " " + sender.getAccountType());
			System.out.println("  n> " + receiver.getName() + " " + receiver.getAccountType());
			int input = scanner.nextInt();
			System.out.println();
			try {
				if (input == 1) {
					return;
				}
				tempAcc = sender;
				sender = receiver;
				receiver = tempAcc;

				return;
			} catch (Exception e) {
				System.out.println("Inavid input :: so DEFULT account 1 Selected ");
				System.out.println();
				return;
			}

		}
	}

	private static Account createAccount(Scanner scanner) {
		selectAccoutType(scanner);
		System.out.println("Enter Name ");
		String name = scanner.next();
		String accountNumber = "IDBI1000" + customAccNo();
		int intialAmount = takeIntialAmount(scanner);

		if (AccountType.saving == accoutType) {
			return new SavingAccount(accountNumber, name, intialAmount);

		}
		return new CurrentAccount(accountNumber, name, intialAmount);
	}

	private static int takeIntialAmount(Scanner scanner) {
		int intialAmount;
		while (true) {
			System.out.println("Enter Intial Amount");
			intialAmount = scanner.nextInt();

			if (intialAmount < 500) {
				try {
					throw new MinAccountBalanceException(intialAmount);

				} catch (Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
			}
			return intialAmount;
		}
	}

	private static int customAccNo() {
		Random random = new Random();
		int min = 100000;
		int max = 999999;
		int randomNumber = random.nextInt(max - min + 1) + min;
		return randomNumber;
	}

	private static void selectAccoutType(Scanner scanner) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("Select Account Type \n 1 -> Saving \n 2 -> current");
			int accountTypeNumber = scanner.nextInt();
			switch (accountTypeNumber) {
			case 1: {
				accoutType = AccountType.saving;
				return;
			}
			case 2: {
				accoutType = AccountType.current;
				return;
			}
			default:
				System.out.println("INVALID INPUT");
				break;
			}
		}

	}
}