package com.collisiongames.polygon.input;

/**
 * 
 * @author Alex Ringhoffer
 *
 */
public class Input {

	public static final Keyboard KEYBOARD;
	public static final Mouse MOUSE;
	
	/**
	 * Set the window the events should be held for
	 * @param ID The window's ID
	 */
	public static void setWindow(long ID) {
		
		KEYBOARD.setWindow(ID);
		MOUSE.setWindow(ID);
	}
	
	/**
	 * Set up keyboard and mouse
	 */
	static {
		
		KEYBOARD = new Keyboard();
		MOUSE = new Mouse();
	}
}
