package com.collisiongames.polygon.graphics;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.*;

/**
 * 
 * @author Alex Ringhoffer
 *
 */
public class Window {
	
	// ID of the window
	private long ID;
	private int width, height;
	private String title;
	
	/**
	 * Default constructor
	 */
	public Window(String title, int width, int height) {
		
		this.title = title;
		this.width = width;
		this.height = height;
		
		GLFW.glfwDefaultWindowHints();
		
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 2);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT, 1);
		
		ID = GLFW.glfwCreateWindow(width, height, "Game", 0, 0);
		
		GLFW.glfwMakeContextCurrent(ID);
		GLFW.glfwShowWindow(ID);
		
		GL.createCapabilities();
		GL11.glViewport(0, 0, width, height);
	}
	
	/**
	 * Swap buffers and run events;
	 */
	public void update() {
		
		GLFW.glfwPollEvents();
		GLFW.glfwSwapBuffers(ID);
	}
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; GLFW.glfwSetWindowTitle(ID, title); }
	
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
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
