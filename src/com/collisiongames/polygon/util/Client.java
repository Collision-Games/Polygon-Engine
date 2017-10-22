package com.collisiongames.polygon.util;

public class Client {

	public static boolean isMac() { return System.getProperty("os.name").toLowerCase().contains("mac"); }
	public static boolean isWindows() { return System.getProperty("os.name").toLowerCase().contains("win"); }
}
