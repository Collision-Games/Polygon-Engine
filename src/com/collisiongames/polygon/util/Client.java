package com.collisiongames.polygon.util;

public class Client {

	/**
	 * 
	 * @return Is this client a Mac?
	 */
	public static boolean isMac() { return System.getProperty("os.name").toLowerCase().contains("mac"); }
	
	/**
	 * 
	 * @return Is this client Windows?
	 */
	public static boolean isWindows() { return System.getProperty("os.name").toLowerCase().contains("win"); }
}
