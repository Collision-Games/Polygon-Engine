package com.collisiongames.polygon.maths;

public class Vector3 {

	public float x, y, z;
	
	public Vector3() { this(identity()); }
	public Vector3(Vector2 vec) { this(vec.x, vec.y, 0); }
	public Vector3(Vector3 vec) { this(vec.x, vec.y, vec.z); }
	public Vector3(float x, float y, float z) {
		
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3 set(Vector3 vector) { return identity().add(vector); }
	
	public Vector3 add(Vector3 vector) {
		
		this.x += vector.x;
		this.y += vector.y;
		this.z += vector.z;
		
		return this;
	}
	
	public Vector3 sub(Vector3 vector) { return add(vector.clone().inverse()); }
	
	public Vector3 mul(Vector3 vector) {
		
		this.x *= vector.x;
		this.y *= vector.y;
		this.z *= vector.z;
		
		return this;
	}
	
	public Vector3 div(Vector3 vector) {
		
		this.x /= vector.x;
		this.y /= vector.y;
		this.z /= vector.z;
		
		return this;
	}
	
	public Vector3 inverse() { return mul(new Vector3(-1, -1, -1)); }
	
	public static Vector3 identity() { return new Vector3(0, 0, 0); }
	public Vector3 clone() { return new Vector3(x, y, z); }
	public String toString() { return "[" + x + " " + y + " " + z + "]"; }
}
