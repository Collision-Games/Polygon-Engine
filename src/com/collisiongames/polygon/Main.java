package com.collisiongames.polygon;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

import com.collisiongames.polygon.graphics.Window;

public class Main {

	public static void main(String[] args) {
		
		GLFW.glfwInit();
		
		Window window = new Window();
		
		GL11.glClearColor(1, 1, 1, 1);
		while (!window.shouldClose()) {
			
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			
			window.update();
		}
		
		window.dispose();
		GLFW.glfwTerminate();
	}
}
