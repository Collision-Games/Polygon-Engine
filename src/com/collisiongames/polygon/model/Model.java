package com.collisiongames.polygon.model;

import org.lwjgl.opengl.GL20;

import com.collisiongames.polygon.loader.*;

public class Model extends RawModel {

	private Texture texture;
	
	public Model(String model, String texture) { this(ObjLoader.load(model), ImgLoader.load(texture)); }
	public Model(RawModel model, Texture texture) {
		
		super(model.getVertexArray(), model.getVertexCount());
		this.texture = texture;
	}
	
	public Texture getTexture() { return texture; }
	
	// TODO: Finish this function
	public void draw() {
		
		getVertexArray().bind();
		GL20.glEnableVertexAttribArray(0);
		GL20.glEnableVertexAttribArray(1);
		GL20.glEnableVertexAttribArray(2);
		
		GL20.glEnableVertexAttribArray(2);
		GL20.glEnableVertexAttribArray(1);
		GL20.glEnableVertexAttribArray(0);
		getVertexArray().unBind();
	}
}
