package com.collisiongames.polygon.maths;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

public class Matrix4 {
	
	public float[] elements = new float[4 * 4];
	
	public Matrix4() {}
	public Matrix4(Matrix4 matrix) { set(matrix); }
	
	public Matrix4 set(Matrix4 matrix) {
		
		for (int i = 0; i < 16; i++)
			elements[i] = matrix.elements[i];
		
		return this;
	}
	
	public Matrix4 add(Matrix4 matrix) {
		
		for (int i = 0; i < 16; i++)
			elements[i] += matrix.elements[i];
		
		return this;
	}
	
	public Matrix4 sub(Matrix4 matrix) { return add(matrix.clone().inverse()); }
	
	public Matrix4 inverse() {
		
		for (int i = 0; i < 16; i++)
			elements[i] *= -1;
		
		return this;
	}
	
	public Matrix4 clone() { return new Matrix4().add(this); }
	
	public static Matrix4 identity() {
		
		Matrix4 matrix = new Matrix4();
		
		for (int i = 0; i < 16; i++)
			matrix.elements[i] = 0;
		
		matrix.elements[0 + 0 * 4] = 1;
		matrix.elements[1 + 1 * 4] = 1;
		matrix.elements[2 + 2 * 4] = 1;
		matrix.elements[3 + 3 * 4] = 1;
		
		return matrix;
	}
	
	public FloatBuffer toBuffer() {
		
		FloatBuffer buffer = BufferUtils.createFloatBuffer(16);
		buffer.put(elements);
		buffer.flip();
		
		return buffer;
	}
	
	public String toString() {
		
		StringBuilder string = new StringBuilder();
		
		string.append("[");
		
		for (int i = 1; i < 17; i++) {
			string.append(" " + elements[i - 1]);
			if (i % 4 == 0)
				string.append("\n");
		}
		string.deleteCharAt(1);
		string.setLength(string.length() - 1);
		string.append("]");
		
		return string.toString();
	}
}
