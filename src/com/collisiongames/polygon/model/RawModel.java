package com.collisiongames.polygon.model;

import com.collisiongames.polygon.buffers.VertexArray;

public class RawModel {

	private VertexArray vertexArray;
	private int vertexCount;
	
	public RawModel(VertexArray vertexArray, int vertexCount) {
		
		this.vertexArray = vertexArray;
		this.vertexCount = vertexCount;
	}
	
	public VertexArray getVertexArray() { return vertexArray; }
	public int getVertexCount() { return vertexCount; }
}
