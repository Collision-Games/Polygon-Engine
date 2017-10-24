package com.collisiongames.polygon.maths;

/**
 * 
 * @author Alex Ringhoffer
 *
 */
public class Vector4 {

	public float x, y, z, w;
	
	/**
	 * Default constructor
	 */
	public Vector4() { this(identity()); }
	
	/**
	 * 
	 * @param vector The vector this vector should be set to
	 */
	public Vector4(Vector4 vector) { this(vector.x, vector.y, vector.z, vector.w); }
	
	/**
	 * 
	 * @param x The x
	 * @param y The y
	 * @param z The z
	 * @param w The w
	 */
	public Vector4(float x, float y, float z, float w) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	/**
	 * 
	 * @param vector The vector this vector should be set to
	 * @return This vector
	 */
	public Vector4 set(Vector4 vector) { return identity().add(vector); }
	
	/**
	 * 
	 * @param vector The vector that should be added
	 * @return This vector
	 */
	public Vector4 add(Vector4 vector) {
		
		this.x += vector.x;
		this.y += vector.y;
		this.z += vector.z;
		this.w += vector.w;
		
		return this;
	}
	
	/**
	 * 
	 * @param vector The vector that should be subtracted
	 * @return This vector
	 */
	public Vector4 sub(Vector4 vector) {
		
		this.x -= vector.x;
		this.y -= vector.y;
		this.z -= vector.z;
		this.w -= vector.w;
		
		return this;
	}
	
	/**
	 * 
	 * @param vector The vector that should be multiplied
	 * @return This vector
	 */
	public Vector4 mul(Vector4 vector) {
		
		this.x *= vector.x;
		this.y *= vector.y;
		this.z *= vector.z;
		this.w *= vector.w;
		
		return this;
	}
	
	/**
	 * 
	 * @param vector The vector that should be divided
	 * @return This vector
	 */
	public Vector4 div(Vector4 vector) {
		
		this.x /= vector.x;
		this.y /= vector.y;
		this.z /= vector.z;
		this.w /= vector.w;
		
		return this;
	}
	
	/**
	 * 
	 * @return The identity vector
	 */
	public static Vector4 identity() { return new Vector4(0, 0, 0, 0); }
	
	public Vector4 clone() { return new Vector4(x, y, z, w); }
	public String toString() { return "[" + x + " " + y + " " + z + " " + w + "]"; }

}
