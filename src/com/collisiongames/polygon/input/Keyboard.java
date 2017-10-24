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
	private Map<Integer, Integer> keys;
	
	/**
	 * Default constructor
	 */
	public Keyboard() {
		
		keys = new HashMap<>();
		
		keyCallback = new GLFWKeyCallbackI() {
			
			public void invoke(long window, int key, int scancode, int action, int mods) {
				
				if (window != windowID)
					return;
//				System.out.println("press");
				if (action == GLFW.GLFW_PRESS)
					keys.put(key, 0);
				else if (action == GLFW.GLFW_RELEASE)
					keys.remove(key);
			}
		};
	}
	
	public void update() {
		
		for (int key : keys.keySet())
			keys.put(key, keys.get(key) + 1);
	}
	
	/**
	 * 
	 * @param key The key's ID
	 * @return If the key is being pressed
	 */
	public boolean keyPressed(int key) { return keys.containsKey(key); }
	
	/**
	 * 
	 * @param key The key's ID
	 * @return If the key was just pressed
	 */
	public boolean keyJustPressed(int key) { return keys.get(key) != null && keys.get(key) == 0; }
	
	/**
	 * 
	 * @param ID The window's ID this event should be help for
	 */
	public void setWindow(long ID) {
		
		this.windowID = ID;
		GLFW.glfwSetKeyCallback(ID, keyCallback);
	}
}
