package com.collisiongames.polygon;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

import com.collisiongames.polygon.graphics.Window;

public class Main {

	public static void main(String[] args) {
		
		GLFW.glfwInit();
		
		Window window = new Window("Game", 1280, 720);
		Window window2 = new Window("Game", 500, 200);
		
		System.out.println("Width: " + window.getWidth() + " Height: " + window.getHeight() + " Title: " + window.getTitle());
		
		GL11.glClearColor(1, 1, 1, 1);
		while (!window.shouldClose()) {
			
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			window.update();
			window2.update();
			
			window2.setTitle(Math.random() + "");
		}
		
		window2.dispose();
		window.dispose();
		GLFW.glfwTerminate();
	}
}
