package com.collisiongames.polygon.maths;

/**
 * 
 * @author Alex Ringhoffer
 *
 */
public class Vector3 {

	public float x, y, z;
	
	/**
	 * Default constructor
	 */
	public Vector3() { this(identity()); }
	
	/**
	 * 
	 * @param vec The vector this vector should be set to
	 */
	public Vector3(Vector3 vec) { this(vec.x, vec.y, vec.z); }
	
	/**
	 * 
	 * @param x The x
	 * @param y The y
	 */
	public Vector3(float x, float y, float z) {
		
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * 
	 * @param vec The vector this vector should be set to
	 * @return This vector
	 */
	public Vector3 set(Vector3 vector) { return identity().add(vector); }
	
	/**
	 * 
	 * @param vector The vector that should be added
	 * @return This vector
	 */
	public Vector3 add(Vector3 vector) {
		
		this.x += vector.x;
		this.y += vector.y;
		this.z += vector.z;
		
		return this;
	}
	
	/**
	 * 
	 * @param vector The vector that should be subtracted
	 * @return This vector
	 */
	public Vector3 sub(Vector3 vector) {
		
		this.x -= vector.x;
		this.y -= vector.y;
		this.z -= vector.z;
		
		return this;
	}
	
	/**
	 * 
	 * @param vector The vector that should be multiplied
	 * @return This vector
	 */
	public Vector3 mul(Vector3 vector) {
		
		this.x *= vector.x;
		this.y *= vector.y;
		this.z *= vector.z;
		
		return this;
	}
	
	/**
	 * 
	 * @param vector The vector that should be divided
	 * @return This vector
	 */
	public Vector3 div(Vector3 vector) {
		
		this.x /= vector.x;
		this.y /= vector.y;
		this.z /= vector.z;
		
		return this;
	}
	
	/**
	 * 
	 * @return The identity vector
	 */
	public static Vector3 identity() { return new Vector3(0, 0, 0); }
	
	public Vector3 clone() { return new Vector3(x, y, z); }
	public String toString() { return "[" + x + " " + y + " " + z + "]"; }
}
