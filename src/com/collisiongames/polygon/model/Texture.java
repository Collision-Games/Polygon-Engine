package com.collisiongames.polygon.model;

import org.lwjgl.opengl.GL11;

import com.collisiongames.polygon.loader.ImgLoader;

public class Texture {

	private String path;
	private int width, height;
	private int textureID;
	
	public Texture(String path) { this(ImgLoader.load(path)); }
	public Texture(Texture texture) { this(texture.getPath(), texture.getWidth(), texture.getHeight(), texture.getTextureID()); }
	public Texture(String path, int width, int height, int textureID) {
		
		this.path = path;
		this.width = width;
		this.height = height;
		this.textureID = textureID;
	}
	
	public String getPath() { return path; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public int getTextureID() { return textureID; }
	
	public void bind() { GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureID); }
	public void unbind() { GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0); }
}
