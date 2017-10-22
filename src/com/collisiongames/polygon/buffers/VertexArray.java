package com.collisiongames.polygon.buffers;

import static org.lwjgl.opengl.GL11.GL_VERTEX_ARRAY;
import static org.lwjgl.opengl.GL30.*;

public class VertexArray extends Buffer {

    public VertexArray() {
        super(glGenVertexArrays(), GL_VERTEX_ARRAY);
    }

    @Override
    protected void onDelete() {
        glDeleteVertexArrays(bufferID);
    }

    @Override
    protected void onBind() {
        glBindVertexArray(bufferID);
    }

    @Override
    protected void onUnBind() {
        glBindVertexArray(0);
    }
}
