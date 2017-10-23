package com.collisiongames.polygon.graphics;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.*;

/**
 * 
 * @author Alex Ringhoffer
 *
 */
public class Window {
	
	private static final int
		WIDTH = 1280,
		HEIGHT = 720;
	
	// ID of the window
	private long ID;
	
	/**
	 * Default constructor
	 */
	public Window() {
		
		GLFW.glfwDefaultWindowHints();
		
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 2);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT, 1);
		
		ID = GLFW.glfwCreateWindow(WIDTH, HEIGHT, "Game", 0, 0);
		
		GLFW.glfwMakeContextCurrent(ID);
		GLFW.glfwShowWindow(ID);
		
		GL.createCapabilities();
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
	}
	
	/**
	 * Swap buffers and run events;
	 */
	public void update() {
		
		GLFW.glfwPollEvents();
		GLFW.glfwSwapBuffers(ID);
	}
	
	/**
	 * 
	 * @return Should this window close now?
	 */
	public boolean shouldClose() { return GLFW.glfwWindowShouldClose(ID); }
	
	/**
	 * Destroy the window
	 */
	public void dispose() { GLFW.glfwDestroyWindow(ID); }
}
