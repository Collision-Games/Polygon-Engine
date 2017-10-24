package com.collisiongames.polygon.input;

import java.util.*;

import org.lwjgl.glfw.*;

/**
 * 
 * @author Alex Ringhoffer
 *
 */
public class Mouse {
	
	private GLFWCursorPosCallbackI posCallback;
	private GLFWMouseButtonCallbackI buttonCallback;
	
	private long windowID;
	
	private int x, y;
	private Map<Integer, Integer> pressedButtons;
	
	/**
	 * Default constructor
	 */
	public Mouse() {
		
		pressedButtons = new HashMap<>();
		
		posCallback = new GLFWCursorPosCallbackI() {
			
			public void invoke(long window, double xpos, double ypos) {
	
				if (window != windowID)
					return;
				
				x = (int) xpos;
				y = (int) ypos;
			}
		};
		
		buttonCallback = new GLFWMouseButtonCallbackI() {
			
			public void invoke(long window, int button, int action, int mods) {
				
				if (window != windowID)
					return;
				
				if (action == GLFW.GLFW_PRESS)
					pressedButtons.put(button, 0);
				else if (action == GLFW.GLFW_RELEASE)
					pressedButtons.remove(button);
			}
		};
	}
	
	public void update() {
		
		for (int key : pressedButtons.keySet())
			pressedButtons.put(key, pressedButtons.get(key) + 1);
	}
	
	/**
	 * 
	 * @param button The button's ID
	 * @return If the button was just pressed
	 */
	public boolean buttonJustPressed(int button) { return pressedButtons.get(button) != null && pressedButtons.get(button) == 0; }
	
	/**
	 * 
	 * @param button The button's ID
	 * @return If the button is being pressed
	 */
	public boolean buttonPressed(int button) { return pressedButtons.containsKey(button); }
	
	/**
	 * 
	 * @return The x position of the mouse
	 */
	public int getX() { return x; }
	
	/**
	 * 
	 * @return The y position of the mouse
	 */
	public int getY() { return 720 - y; }
	
	/**
	 * 
	 * @param ID The window's ID this event should be help for
	 */
	public void setWindow(long ID) {
		
		this.windowID = ID;
		GLFW.glfwSetCursorPosCallback(ID, posCallback);
		GLFW.glfwSetMouseButtonCallback(ID, buttonCallback);
	}
}
