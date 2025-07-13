package com.aurionpro.helper;

public class Utils {
  public static String  randomString(String prefix) {
	  int randomNumber = (int) (Math.random()*1000)+1;
	  return prefix+"-"+randomNumber;
  }
}
