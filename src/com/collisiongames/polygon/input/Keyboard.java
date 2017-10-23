package com.collisiongames.polygon.input;

import java.util.*;

import org.lwjgl.glfw.*;

/**
 * 
 * @author Alex Ringhoffer
 *
 */
public class Keyboard {

	private GLFWKeyCallbackI keyCallback;
	
	private long windowID;
	private Map<Integer, Boolean> keys;
	
	/**
	 * Default constructor
	 */
	public Keyboard() {
		
		keys = new HashMap<>();
		
		keyCallback = new GLFWKeyCallbackI() {
			
			public void invoke(long window, int key, int scancode, int action, int mods) {
				
				if (window != windowID)
					return;
				
				if (action == GLFW.GLFW_PRESS)
					keys.put(key, true);
				else if (action == GLFW.GLFW_RELEASE)
					keys.remove(key);
			}
		};
	}
	
	/**
	 * 
	 * @param key The keys ID
	 * @return If the key is being pressed
	 */
	public boolean keyPressed(int key) { return keys.containsKey(key); }
	
	/**
	 * 
	 * @param ID The window's ID this event should be help for
	 */
	public void setWindow(long ID) {
		
		this.windowID = ID;
		GLFW.glfwSetKeyCallback(ID, keyCallback);
	}
}
