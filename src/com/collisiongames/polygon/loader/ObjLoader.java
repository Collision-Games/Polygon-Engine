package com.collisiongames.polygon.loader;

import java.io.*;
import java.util.*;

import org.lwjgl.opengl.*;

import com.collisiongames.polygon.buffers.*;
import com.collisiongames.polygon.maths.*;
import com.collisiongames.polygon.model.RawModel;

public class ObjLoader {

	public static RawModel load(String path) {
		
		try {
		
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			
			List<Vector3> vertices = new ArrayList<>();
			List<Vector2> textures = new ArrayList<>();
			List<Vector3> normals = new ArrayList<>();
			List<Integer> indices = new ArrayList<>();
		
			float[] vertexArray, textureArray, normalArray;
			int[] indicesArray;
				
				while (true) {
					
					line = reader.readLine();
					
					String[] current = line.split(" ");
					
					if (line.startsWith("v "))
						vertices.add(new Vector3(Float.parseFloat(current[1]), Float.parseFloat(current[2]), Float.parseFloat(current[3])));
					
					if (line.startsWith("vt "))
						textures.add(new Vector2(Float.parseFloat(current[1]), Float.parseFloat(current[2])));
					
					if (line.startsWith("vn "))
						normals.add(new Vector3(Float.parseFloat(current[1]), Float.parseFloat(current[2]), Float.parseFloat(current[3])));
					
					if (line.startsWith("f "))
						break;
				}
				
				vertexArray = new float[vertices.size() * 3];
				textureArray = new float[vertices.size() * 2];
				normalArray = new float[vertices.size() * 3];
				
				while (line != null) {
					
					if (!line.startsWith("f ")) {
						
						line = reader.readLine();
						continue;
					}
					
					String[] data = line.split(" ");
					
					String[] v1 = data[1].split("/");
					String[] v2 = data[2].split("/");
					String[] v3 = data[3].split("/");
					
					processVertex(v1, vertices, vertexArray, textures, textureArray, normals, normalArray, indices);
					processVertex(v2, vertices, vertexArray, textures, textureArray, normals, normalArray, indices);
					processVertex(v3, vertices, vertexArray, textures, textureArray, normals, normalArray, indices);
					
					line = reader.readLine();
				}
				reader.close();
				
			indicesArray = new int[indices.size()];
			
			for (int i = 0; i < indices.size(); i++)
				indicesArray[i] = indices.get(i);
			
			VertexArray array = new VertexArray(vertexArray, indicesArray);
			array.assignAttribPointer(0, 3, GL11.GL_FLOAT, 0, 0, new BufferObject(GL15.GL_ARRAY_BUFFER, GL15.GL_STATIC_DRAW, vertexArray), false);
			array.assignAttribPointer(1, 3, GL11.GL_FLOAT, 0, 0, new BufferObject(GL15.GL_ARRAY_BUFFER, GL15.GL_STATIC_DRAW, textureArray), false);
			array.assignAttribPointer(2, 3, GL11.GL_FLOAT, 0, 0, new BufferObject(GL15.GL_ARRAY_BUFFER, GL15.GL_STATIC_DRAW, vertexArray), false);
			
			return new RawModel(array, indicesArray.length);
			
		} catch (IOException e) { e.printStackTrace(); }
		
		return null;
	}
	
	private static void processVertex(String[] data, List<Vector3> vertices, float[] vertexArray, List<Vector2> textures, float[] textureArray, List<Vector3> normals, float[] normalArray, List<Integer> indices) {
		
		int pointer = Integer.parseInt(data[0]) - 1;
		indices.add(pointer);
		
		Vector3 vertex = vertices.get(pointer);
		vertexArray[pointer * 3] = vertex.x;
		vertexArray[pointer * 3 + 1] = vertex.y;
		vertexArray[pointer * 3 + 2] = vertex.z;
	
		Vector2 texture = textures.get(Integer.parseInt(data[1]) - 1);
		textureArray[pointer * 3] = texture.x;
		textureArray[pointer * 3 + 1] = texture.y;
		
		Vector3 normal = normals.get(Integer.parseInt(data[2]) - 1);
		normalArray[pointer * 3] = normal.x;
		normalArray[pointer * 3 + 1] = normal.y;
		normalArray[pointer * 3 + 2] = normal.z;
	}
}
