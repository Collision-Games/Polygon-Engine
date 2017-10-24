package com.collisiongames.polygon.buffers;

import java.util.*;

/**
 * Base class for all OpenGL buffers including but not limited to Vertex Arrays, Buffer Objects, RenderBuffers, Textures and RenderBuffers
 *
 * @author Daan Meijer
 * @since v0.1
 */
public abstract class Buffer {

    private static Map<Integer, Integer> boundBuffers = new HashMap<>();
    protected int bufferID, bufferType;

    /**
     * Constructor for a instance of a {@link Buffer} class
     *
     * @param bufferID   the generated buffer id by OpenGL(glGenBuffers etc.)
     * @param bufferType the type of buffer like: GL_VERTEX_ARRAY, GL_ELEMENT_ARRAY_BUFFER and GL_ARRAY_BUFFER
     */
    protected Buffer(int bufferID, int bufferType) {
        this.bufferID = bufferID;
        this.bufferType = bufferType;
    }

    /**
     * Function for deleting the {@link Buffer} instance from memory
     */
    public final void delete() {
        onDelete();
    }

    /**
     * Binding the current buffer for OpenGL calls
     */
    public final void bind() {
        onBind();
        boundBuffers.put(bufferType, bufferID);
    }

    /**
     * Clearing the currently bound buffer
     */
    public final void unBind() {
        onUnBind();
        boundBuffers.put(bufferType, 0);
    }

    /**
     * Checks if the specified buffer is currently bound for OpenGL calls
     *
     * @param bufferType the type of buffer to check, like: GL_VERTEX_ARRAY, GL_ELEMENT_ARRAY_BUFFER and GL_ARRAY_BUFFER
     * @return true if the buffer is currently bound
     * @see Buffer#bind()
     */
    public final boolean isBound(int bufferType) {
        if (!boundBuffers.containsKey(bufferType)) return false;
        return boundBuffers.get(bufferType) != null;
    }

    protected abstract void onDelete();

    protected abstract void onBind();

    protected abstract void onUnBind();
}
