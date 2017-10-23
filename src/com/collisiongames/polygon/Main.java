package com.collisiongames.polygon;

import com.collisiongames.polygon.maths.*;

public class Main {

	public static void main(String[] args) {
		
		Vector3 vec3 = Vector3.identity();
		Vector2 vec2 = Vector2.identity();
		Matrix4 mat4 = Matrix4.identity();
		
		System.out.println("Identity:");
		System.out.println(vec3.toString());
		System.out.println(vec2.toString());
		System.out.println(mat4.toString() + "\n");
		
		vec3.add(new Vector3(12, 12, 12));
		vec2.add(new Vector2(12, 12));
		mat4.add(Matrix4.identity());
		
		System.out.println("Addition:");
		System.out.println(vec3.toString());
		System.out.println(vec2.toString());
		System.out.println(mat4.toString() + "\n");
		
		vec3.sub(new Vector3(10, 10, 10));
		vec2.sub(new Vector2(10, 10));
		mat4.sub(Matrix4.identity());
		
		System.out.println("Subtraction:");
		System.out.println(vec3.toString());
		System.out.println(vec2.toString());
		System.out.println(mat4.toString() + "\n");
		
		vec3.mul(new Vector3(2, 2, 2));
		vec2.mul(new Vector2(2, 2));
		
		System.out.println("Multiplication:");
		System.out.println(vec3.toString());
		System.out.println(vec2.toString() + "\n");
		
		vec3.div(new Vector3(2, 2, 2));
		vec2.div(new Vector2(2, 2));
		
		System.out.println("Division:");
		System.out.println(vec3.toString());
		System.out.println(vec2.toString() + "\n");
	}
}
