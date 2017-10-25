package com.collisiongames.polygon.loader;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.IntBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import com.collisiongames.polygon.model.Texture;

public class ImgLoader {

	public static Texture load(String path) {
		
		BufferedImage image;
		int width, height;
		int textureID;
		int[] data;
		int[] pixels;
		
		try {
			
			image = ImageIO.read(new File(path));
			width = image.getWidth();
			height = image.getHeight();
			data = image.getRGB(0, 0, width, height, null, 0, width);
			pixels = new int[data.length];
			
			for (int i = 0; i < data.length; i++) {
				
				int a = (pixels[i] & 0xFF000000) >> 24;
				int r = (pixels[i] & 0xFF0000) >> 16;
				int g = (pixels[i] & 0xFF00) >> 8;
				int b = (pixels[i] & 0xFF);
				
				pixels[i] = a << 24 | b << 16 | g << 8 | r;
			}
			
			textureID = GL11.glGenTextures();
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureID);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
			GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, width, height, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, (IntBuffer) BufferUtils.createIntBuffer(pixels.length).put(pixels).flip());
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
			
			return new Texture(path, width, height, textureID);
		} catch (IOException e) { e.printStackTrace(); }
		return null;
	}
}
