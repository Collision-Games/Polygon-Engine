package com.collisiongames.polygon.maths;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

/**
 * 
 * @author Alex Ringhoffer
 *
 */
public class Matrix4 {
	
	public float[] elements = new float[4 * 4];
	
	/**
	 * Default constructor
	 */
	public Matrix4() {}

	/**
	 * 
	 * @param matrix The matrix this matrix should be set to
	 */
	public Matrix4(Matrix4 matrix) { set(matrix); }
	
	
	/**
	 * 
	 * @param matrix The matrix this matrix should be set to
	 * @return This matrix
	 */
	public Matrix4 set(Matrix4 matrix) {
		
		for (int i = 0; i < 16; i++)
			elements[i] = matrix.elements[i];
		
		return this;
	}
	
	/**
	 * 
	 * @param matrix The matrix that should be added
	 * @return This matrix
	 */
	public Matrix4 add(Matrix4 matrix) {
		
		for (int i = 0; i < 16; i++)
			elements[i] += matrix.elements[i];
		
		return this;
	}
	
	/**
	 * 
	 * @param matrix The matrix that should be subtracted
	 * @return This matrix
	 */
	public Matrix4 sub(Matrix4 matrix) {
		
		for (int i = 0; i < 16; i++)
			elements[i] -= matrix.elements[i];
		
		return this;
	}
	
	/**
	 * 
	 * @param matrix The matrix that should be multiplied
	 * @return This matrix
	 */
	public Matrix4 mul(Matrix4 matrix) {
		
		elements[0] = elements[0] * matrix.elements[0] + elements[4] * matrix.elements[1] + elements[8] * matrix.elements[2] + elements[12] * matrix.elements[3];
		elements[1] = elements[1] * matrix.elements[0] + elements[5] * matrix.elements[1] + elements[9] * matrix.elements[2] + elements[13] * matrix.elements[3];
		elements[2] = elements[2] * matrix.elements[0] + elements[6] * matrix.elements[1] + elements[10] * matrix.elements[2] + elements[14] * matrix.elements[3];
		elements[3] = elements[3] * matrix.elements[0] + elements[7] * matrix.elements[1] + elements[11] * matrix.elements[2] + elements[15] * matrix.elements[3];
		elements[4] = elements[0] * matrix.elements[4] + elements[4] * matrix.elements[5] + elements[8] * matrix.elements[6] + elements[12] * matrix.elements[7];
		elements[5] = elements[1] * matrix.elements[4] + elements[5] * matrix.elements[5] + elements[9] * matrix.elements[6] + elements[13] * matrix.elements[7];
		elements[6] = elements[2] * matrix.elements[4] + elements[6] * matrix.elements[5] + elements[10] * matrix.elements[6] + elements[14] * matrix.elements[7];
		elements[7] = elements[3] * matrix.elements[4] + elements[7] * matrix.elements[5] + elements[11] * matrix.elements[6] + elements[15] * matrix.elements[7];
		elements[8] = elements[0] * matrix.elements[8] + elements[4] * matrix.elements[9] + elements[8] * matrix.elements[10] + elements[12] * matrix.elements[11];
		elements[9] = elements[1] * matrix.elements[8] + elements[5] * matrix.elements[9] + elements[9] * matrix.elements[10] + elements[13] * matrix.elements[11];
		elements[10] = elements[2] * matrix.elements[8] + elements[6] * matrix.elements[9] + elements[10] * matrix.elements[10] + elements[14] * matrix.elements[11];
		elements[11] = elements[3] * matrix.elements[8] + elements[7] * matrix.elements[9] + elements[11] * matrix.elements[10] + elements[15] * matrix.elements[11];
		elements[12] = elements[0] * matrix.elements[12] + elements[4] * matrix.elements[13] + elements[8] * matrix.elements[14] + elements[12] * matrix.elements[15];
		elements[13] = elements[1] * matrix.elements[12] + elements[5] * matrix.elements[13] + elements[9] * matrix.elements[14] + elements[13] * matrix.elements[15];
		elements[14] = elements[2] * matrix.elements[12] + elements[6] * matrix.elements[13] + elements[10] * matrix.elements[14] + elements[14] * matrix.elements[15];
		elements[15] = elements[3] * matrix.elements[12] + elements[7] * matrix.elements[13] + elements[11] * matrix.elements[14] + elements[15] * matrix.elements[15];
		
		return this;
	}
	
	/**
	 * 
	 * @return This matrix but inversed
	 */
	public Matrix4 inverse() {

		float[] tmp = new float[16];

		tmp[0] = elements[5] * elements[10] * elements[15] -
			elements[5] * elements[11] * elements[14] -
			elements[9] * elements[6] * elements[15] +
			elements[9] * elements[7] * elements[14] +
			elements[13] * elements[6] * elements[11] -
			elements[13] * elements[7] * elements[10];

		tmp[4] = -elements[4] * elements[10] * elements[15] +
			elements[4] * elements[11] * elements[14] +
			elements[8] * elements[6] * elements[15] -
			elements[8] * elements[7] * elements[14] -
			elements[12] * elements[6] * elements[11] +
			elements[12] * elements[7] * elements[10];

		tmp[8] = elements[4] * elements[9] * elements[15] -
			elements[4] * elements[11] * elements[13] -
			elements[8] * elements[5] * elements[15] +
			elements[8] * elements[7] * elements[13] +
			elements[12] * elements[5] * elements[11] -
			elements[12] * elements[7] * elements[9];

		tmp[12] = -elements[4] * elements[9] * elements[14] +
			elements[4] * elements[10] * elements[13] +
			elements[8] * elements[5] * elements[14] -
			elements[8] * elements[6] * elements[13] -
			elements[12] * elements[5] * elements[10] +
			elements[12] * elements[6] * elements[9];

		tmp[1] = -elements[1] * elements[10] * elements[15] +
			elements[1] * elements[11] * elements[14] +
			elements[9] * elements[2] * elements[15] -
			elements[9] * elements[3] * elements[14] -
			elements[13] * elements[2] * elements[11] +
			elements[13] * elements[3] * elements[10];

		tmp[5] = elements[0] * elements[10] * elements[15] -
			elements[0] * elements[11] * elements[14] -
			elements[8] * elements[2] * elements[15] +
			elements[8] * elements[3] * elements[14] +
			elements[12] * elements[2] * elements[11] -
			elements[12] * elements[3] * elements[10];

		tmp[9] = -elements[0] * elements[9] * elements[15] +
			elements[0] * elements[11] * elements[13] +
			elements[8] * elements[1] * elements[15] -
			elements[8] * elements[3] * elements[13] -
			elements[12] * elements[1] * elements[11] +
			elements[12] * elements[3] * elements[9];

		tmp[13] = elements[0] * elements[9] * elements[14] -
			elements[0] * elements[10] * elements[13] -
			elements[8] * elements[1] * elements[14] +
			elements[8] * elements[2] * elements[13] +
			elements[12] * elements[1] * elements[10] -
			elements[12] * elements[2] * elements[9];

		tmp[2] = elements[1] * elements[6] * elements[15] -
			elements[1] * elements[7] * elements[14] -
			elements[5] * elements[2] * elements[15] +
			elements[5] * elements[3] * elements[14] +
			elements[13] * elements[2] * elements[7] -
			elements[13] * elements[3] * elements[6];

		tmp[6] = -elements[0] * elements[6] * elements[15] +
			elements[0] * elements[7] * elements[14] +
			elements[4] * elements[2] * elements[15] -
			elements[4] * elements[3] * elements[14] -
			elements[12] * elements[2] * elements[7] +
			elements[12] * elements[3] * elements[6];

		tmp[10] = elements[0] * elements[5] * elements[15] -
			elements[0] * elements[7] * elements[13] -
			elements[4] * elements[1] * elements[15] +
			elements[4] * elements[3] * elements[13] +
			elements[12] * elements[1] * elements[7] -
			elements[12] * elements[3] * elements[5];

		tmp[14] = -elements[0] * elements[5] * elements[14] +
			elements[0] * elements[6] * elements[13] +
			elements[4] * elements[1] * elements[14] -
			elements[4] * elements[2] * elements[13] -
			elements[12] * elements[1] * elements[6] +
			elements[12] * elements[2] * elements[5];

		tmp[3] = -elements[1] * elements[6] * elements[11] +
			elements[1] * elements[7] * elements[10] +
			elements[5] * elements[2] * elements[11] -
			elements[5] * elements[3] * elements[10] -
			elements[9] * elements[2] * elements[7] +
			elements[9] * elements[3] * elements[6];

		tmp[7] = elements[0] * elements[6] * elements[11] -
			elements[0] * elements[7] * elements[10] -
			elements[4] * elements[2] * elements[11] +
			elements[4] * elements[3] * elements[10] +
			elements[8] * elements[2] * elements[7] -
			elements[8] * elements[3] * elements[6];

		tmp[11] = -elements[0] * elements[5] * elements[11] +
			elements[0] * elements[7] * elements[9] +
			elements[4] * elements[1] * elements[11] -
			elements[4] * elements[3] * elements[9] -
			elements[8] * elements[1] * elements[7] +
			elements[8] * elements[3] * elements[5];

		tmp[15] = elements[0] * elements[5] * elements[10] -
			elements[0] * elements[6] * elements[9] -
			elements[4] * elements[1] * elements[10] +
			elements[4] * elements[2] * elements[9] +
			elements[8] * elements[1] * elements[6] -
			elements[8] * elements[2] * elements[5];
		
		float determinant = elements[0] * tmp[0] + elements[1] * tmp[4] + elements[2] * tmp[8] + elements[3] * tmp[12];

		for (int i = 0; i < 16; i++)
			elements[i] = tmp[i] * determinant;
		
		return this;
	}
	
	/**
	 * 
	 * @return An identity matrix
	 */
	public static Matrix4 identity() {
		
		Matrix4 matrix = new Matrix4();
		
		for (int i = 0; i < 16; i++)
			matrix.elements[i] = 0;
		
		matrix.elements[0] = 1;
		matrix.elements[5] = 1;
		matrix.elements[10] = 1;
		matrix.elements[15] = 1;
		
		return matrix;
	}
	
	/**
	 * 
	 * @return This matrix but in a buffer
	 */
	public FloatBuffer toBuffer() { return (FloatBuffer) BufferUtils.createFloatBuffer(16).put(elements).flip();}
	
	/**
	 * 
	 * @param vector The vector3 that should be turned into a transformation matrix
	 * @return The transformation matrix
	 */
	public static Matrix4 transformation(Vector3 vector) {
		
		Matrix4 matrix = identity();
		
		matrix.elements[12] = vector.x;
		matrix.elements[13] = vector.y;
		matrix.elements[14] = vector.z;
		
		return matrix;
	}
	
	/**
	 * 
	 * @param angle The z angle for the rotation
	 * @return The rotation matrix
	 */
	public static Matrix4 rotation(Vector3 axis, float angle) {
		
		Matrix4 matrix = identity();
		
		float radians = (float) Math.toRadians(angle);
		float cos = (float) Math.cos(radians);
		float sin = (float) Math.sin(radians);
		float omc = 1 - cos;
		
		float x = axis.x, y = axis.y, z = axis.z;

		matrix.elements[0] = cos + x * omc;
		matrix.elements[1] = y * x * omc - z * sin;
		matrix.elements[2] = x * z * omc - y * sin;
		
		matrix.elements[4] = y * x * omc + z * sin;
		matrix.elements[5] = cos + y * omc;
		matrix.elements[6] = y + z * omc + x * sin;
		
		matrix.elements[8] = z * x * omc + y * sin;
		matrix.elements[9] = z * y * omc - x * sin;
		matrix.elements[10] = cos + z * omc;
		
		return matrix;
	}
	
	public Matrix4 clone() { return new Matrix4().add(this); }
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
