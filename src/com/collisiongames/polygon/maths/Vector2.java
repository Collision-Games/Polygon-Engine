package com.collisiongames.polygon.maths;

/**
 * 
 * @author Alex Ringhoffer
 *
 */
public class Vector2 {
	
	public float x, y;
	
	/**
	 * Default constructor
	 */
	public Vector2() { this(identity()); }
	
	/**
	 * 
	 * @param vec The vector this vector should be set to
	 */
	public Vector2(Vector2 vec) { this(vec.x, vec.y); }
	
	/**
	 * 
	 * @param x The x
	 * @param y The y
	 */
	public Vector2(float x, float y) {
		
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 * @param vector The vector this vector should be set to
	 * @return This vector
	 */
	public Vector2 set(Vector2 vector) { return identity().add(vector); }
	
	/**
	 * 
	 * @param vector The vector that should be added
	 * @return This vector
	 */
	public Vector2 add(Vector2 vector) {
		
		this.x += vector.x;
		this.y += vector.y;
		
		return this;
	}
	
	/**
	 * 
	 * @param vector The vector that should be subtracted
	 * @return This vector
	 */
	public Vector2 sub(Vector2 vector) {
		
		this.x -= vector.x;
		this.y -= vector.y;
		
		return this;
	}
	
	/**
	 * 
	 * @param vector The vector that should be multiplied
	 * @return This vector
	 */
	public Vector2 mul(Vector2 vector) {
		
		this.x *= vector.x;
		this.y *= vector.y;
		
		return this;
	}
	
	/**
	 * 
	 * @param vector The vector that should be divided
	 * @return This vector
	 */
	public Vector2 div(Vector2 vector) {
		
		this.x /= vector.x;
		this.y /= vector.y;
		
		return this;
	}
	
	/**
	 * 
	 * @return The identity vector
	 */
	public static Vector2 identity() { return new Vector2(0, 0); }
	
	public Vector2 clone() { return new Vector2(x, y); }
	public String toString() { return "[" + x + " " + y + "]"; }
}
