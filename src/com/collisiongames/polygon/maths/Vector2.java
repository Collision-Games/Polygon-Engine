package com.collisiongames.polygon.maths;

public class Vector2 {
	
	public float x, y;
	
	public Vector2() { this(identity()); }
	public Vector2(Vector2 vec) { this(vec.x, vec.y); }
	public Vector2(float x, float y) {
		
		this.x = x;
		this.y = y;
	}
	
	public Vector2 set(Vector2 vector) { return identity().add(vector); }
	
	public Vector2 add(Vector2 vector) {
		
		this.x += vector.x;
		this.y += vector.y;
		
		return this;
	}
	
	public Vector2 sub(Vector2 vector) { return add(vector.clone().inverse()); }
	
	public Vector2 mul(Vector2 vector) {
		
		this.x *= vector.x;
		this.y *= vector.y;
		
		return this;
	}
	
	public Vector2 div(Vector2 vector) {
		
		this.x /= vector.x;
		this.y /= vector.y;
		
		return this;
	}
	
	public Vector2 inverse() { return mul(new Vector2(-1, -1)); }
	
	public static Vector2 identity() { return new Vector2(0, 0); }
	public Vector2 clone() { return new Vector2(x, y); }
	
	public String toString() { return "[" + x + " " + y + "]"; }
}
