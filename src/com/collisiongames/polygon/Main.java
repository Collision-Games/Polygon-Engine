package com.collisiongames.polygon;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.*;

import com.collisiongames.polygon.input.Input;

public class Main {

	public static void main(String[] args) {
		
		GLFW.glfwInit();
		
		GLFW.glfwDefaultWindowHints();
		
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 2);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT, 1);
		
		long ID = GLFW.glfwCreateWindow(1280, 720, "Game", 0, 0);
		
		GLFW.glfwMakeContextCurrent(ID);
		GLFW.glfwShowWindow(ID);
		
		GL.createCapabilities();
		GL11.glViewport(0, 0, 1280, 720);
		
		Input.setWindow(ID);
		while (!GLFW.glfwWindowShouldClose(ID)) {
			
			if (Input.KEYBOARD.keyPressed(GLFW.GLFW_KEY_SPACE))
				System.out.println("Jump!");
			
			if (Input.MOUSE.buttonPressed(GLFW.GLFW_MOUSE_BUTTON_1))
				System.out.println("Button 1");
			
			if (Input.KEYBOARD.keyJustPressed(GLFW.GLFW_KEY_T))
				System.out.println("Key T just pressed");
			
			if (Input.MOUSE.buttonJustPressed(GLFW.GLFW_MOUSE_BUTTON_2))
				System.out.println("Button 2 just pressed");
			
//			System.out.println(Input.MOUSE.getX()); These work
//			System.out.println(Input.MOUSE.getY());
			
			Input.update();
			
			GLFW.glfwPollEvents();
			GLFW.glfwSwapBuffers(ID);
		}
		
		GLFW.glfwDestroyWindow(ID);
		GLFW.glfwTerminate();
	}
}
