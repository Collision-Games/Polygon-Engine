package com.collisiongames.polygon;

import org.lwjgl.opengl.GL11;

import com.collisiongames.polygon.graphics.Window;
import com.collisiongames.polygon.model.Model;

public class Main {

	public static void main(String[] args) {
		
		Window window = new Window("Game", 1280, 720);
		Model model = new Model("res/stall.obj", "res/stallTexture.png");
	
		GL11.glClearColor(1, 1, 1, 1);
		while (!window.shouldClose()) {
			
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			
			model.draw();
		}
	}
}
