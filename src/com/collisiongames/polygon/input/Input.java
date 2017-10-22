package com.collisiongames.polygon.input;

public class Input {

	public static final Keyboard KEYBOARD;
	public static final Mouse MOUSE;
	
	public static void setWindow(long ID) {
		
		KEYBOARD.setWindow(ID);
		MOUSE.setWindow(ID);
	}
	
	static {
		
		KEYBOARD = new Keyboard();
		MOUSE = new Mouse();
	}
}
