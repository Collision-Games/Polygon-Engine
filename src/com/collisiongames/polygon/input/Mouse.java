package com.collisiongames.polygon.input;

import java.util.*;

import org.lwjgl.glfw.*;

public class Mouse {
	
	private GLFWCursorPosCallbackI posCallback;
	private GLFWMouseButtonCallbackI buttonCallback;
	
	private long windowID;
	
	private int x, y;
	private List<Integer> pressedButtons;
	
	public Mouse() {
		
		pressedButtons = new ArrayList<>();
		
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
					pressedButtons.add(button);
				else if (action == GLFW.GLFW_RELEASE)
					pressedButtons.remove(button);
			}
		};
	}
	
	public boolean keyPressed(int button) { return pressedButtons.contains(button); }
	public int getX() { return x; }
	public int getY() { return 720 - y; }
	
	public void setWindow(long ID) {
		
		this.windowID = ID;
		GLFW.glfwSetCursorPosCallback(ID, posCallback);
		GLFW.glfwSetMouseButtonCallback(ID, buttonCallback);
	}
}
