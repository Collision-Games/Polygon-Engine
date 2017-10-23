package com.collisiongames.polygon.buffers;

import org.lwjgl.*;
import static org.lwjgl.opengl.GL15.*;

import java.nio.*;

/**
 * Base class for buffers like Element Buffers and Array Buffers
 *
 * @since v0.1
 * @author Daan Meijer
 */
public class BufferObject extends Buffer {

    protected int usage;

    /**
     * A constructor for a {@link BufferObject} instance with a float list as data
     *
     * @param type the type of buffer to create like: GL_ELEMENT_ARRAY_BUFFER AND GL_ARRAY_BUFFER
     * @param usage the way this buffer is to be used for optimal storage, GL_STATIC_DRAW, GL_DYNAMIC_DRAW, etc.
     * @param data the data to store into the buffer
     * @see Buffer#Buffer(int, int)
     */
    public BufferObject(int type, int usage, float[] data) {
        super(glGenBuffers(), type);
        this.usage = usage;

        bind();
        glBufferData(type, (FloatBuffer) BufferUtils.createFloatBuffer(data.length).put(data).flip(), usage);
    }

    /**
     * A constructor for a {@link BufferObject} instance with an int list as data
     *
     * @param type the type of buffer to create like: GL_ELEMENT_ARRAY_BUFFER AND GL_ARRAY_BUFFER
     * @param usage the way this buffer is to be used for optimal storage, GL_STATIC_DRAW, GL_DYNAMIC_DRAW, etc.
     * @param data the data to store into the buffer
     * @see Buffer#Buffer(int, int)
     */
    public BufferObject(int type, int usage, int[] data) {
        super(glGenBuffers(), type);
        this.usage = usage;

        bind();
        glBufferData(type, (IntBuffer) BufferUtils.createIntBuffer(data.length).put(data).flip(), usage);
    }

    /**
     * Write data over existing data as a float list onto the buffer
     * @param data the data to store into the buffer
     */
    public void writeData(float[] data) {
        if(usage == GL_STATIC_DRAW)
            throw new RuntimeException("Writing to static buffers is highly discouraged use GL_DYNAMIC_DRAW instead");
        bind();
        glBufferData(bufferType, (FloatBuffer) BufferUtils.createFloatBuffer(data.length).put(data).flip(), usage);
    }

    /**
     * Write data over existing data as a int list onto the buffer
     * @param data the data to store into the buffer
     */
    public void writeData(int[] data) {
        if(usage == GL_STATIC_DRAW)
            throw new RuntimeException("Writing to static buffers is highly discouraged use GL_DYNAMIC_DRAW instead");
        bind();
        glBufferData(bufferType, (IntBuffer) BufferUtils.createIntBuffer(data.length).put(data).flip(), usage);
    }

    /**
     * Map the buffer to a {@link ByteBuffer} object for manual manipulation
     *
     * @param action the way you're planning to interact with the buffer, choose from GL_READ_ONLY, GL_WRITE_ONLY or GL_READ_WRITE
     * @return A {@link ByteBuffer} object with the current data on it
     * @see BufferObject#unMapBuffer()
     */
    public ByteBuffer mapBuffer(int action) {
        bind();
        return glMapBuffer(bufferType, action);
    }

    /**
     * Unmaps the buffer and storing the the data back in memory.
     * Make sure to call this after being done with a mapped buffer!
     *
     * @see BufferObject#mapBuffer(int)
     */
    public void unMapBuffer() {
        bind();
        glUnmapBuffer(bufferType);
    }

    @Override
    protected void onDelete() {
        glDeleteBuffers(bufferID);
    }

    @Override
    protected void onBind() {
        glBindBuffer(bufferType, bufferID);
    }

    @Override
    protected void onUnBind() {
        glBindBuffer(bufferType, 0);
    }
}