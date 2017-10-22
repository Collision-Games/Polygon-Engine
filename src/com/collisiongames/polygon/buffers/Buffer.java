package com.collisiongames.polygon.buffers;

import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.Map;

public abstract class Buffer {

    private static Map<Integer, Integer> boundBuffers = new HashMap<>();
    protected int bufferID, bufferType;

    public Buffer(int bufferID, int bufferType) {
        this.bufferID = bufferID;
        this.bufferType = bufferType;
    }

    public final void delete() {
        onDelete();
    }

    public final void bind() {
        onBind();
        boundBuffers.put(bufferType, bufferID);
    }

    public final void unBind() {
        onUnBind();
        boundBuffers.put(bufferType, 0);
    }

    protected abstract void onDelete();

    protected abstract void onBind();

    protected abstract void onUnBind();
}
