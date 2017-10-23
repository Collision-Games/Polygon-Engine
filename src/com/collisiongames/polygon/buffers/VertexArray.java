package com.collisiongames.polygon.buffers;

import org.lwjgl.opengl.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL33.*;

/**
 * A class for storing a Vertex Array buffer.
 * Vertex Arrays as mostly used for storing vertex data
 * and element data on it for later rendering.
 *
 * @since v0.1
 * @author Daan Meijer
 */
public class VertexArray extends Buffer {

    //TODO check if data can be put into one buffer
    protected BufferObject elementBuffer, vertexBuffer;

    /**
     * Constructor for a instance of {@link VertexArray}
     *
     * @param vertices the vertex data of a model
     * @param indices the element(index data) of a model
     */
    public VertexArray(float[] vertices, int[] indices) {
        super(glGenVertexArrays(), GL_VERTEX_ARRAY);
        bind();

        elementBuffer = new BufferObject(GL_ELEMENT_ARRAY_BUFFER, GL_STATIC_DRAW, indices);
        vertexBuffer = new BufferObject(GL_ARRAY_BUFFER, GL_STATIC_DRAW, vertices);
    }

    /**
     * Store an array of generic vertex attribute data
     *
     * @param index specifies the index of the buffer to modified, max range is 16
     * @param size the numbers of components per generic vertex attribute, must be 1, 2, 3 or 4
     * @param dataType the data type of each component in the array, can be GL_BYTE, GL_SHORT, GL_INT, GL_LONG etc.
     * @param stride the byte offset between consecutive generic vertex attributes, If stride is 0, the generic vertex attributs are understood
     *               to be tightly packed in the array
     * @param offset specifies the byte offset of the first component of the first generic vertex attribute in the array in the data store
     * @param bufferObject specifies the buffer to retrieve the data from
     * @param normalized specifies if the fixed-point data should be normalized(true) when they are accessed
     */
    public void assignAttribPointer(int index, int size, int dataType, int stride, int offset, BufferObject bufferObject, boolean normalized) {
        bind();
        assert bufferObject != null;
        bufferObject.bind();
        glEnableVertexAttribArray(index);
        glVertexAttribPointer(index, size, dataType, normalized, stride, offset);
    }

    /**
     * Store an array of generic vertex attribute data
     *
     * @param index specifies the index of the buffer to modified, max range is 16
     * @param size the numbers of components per generic vertex attribute, must be 1, 2, 3 or 4
     * @param dataType the data type of each component in the array, can be GL_BYTE, GL_SHORT, GL_INT, GL_LONG etc.
     * @param stride the byte offset between consecutive generic vertex attributes, If stride is 0, the generic vertex attributs are understood
     *               to be tightly packed in the array
     * @param offset specifies the byte offset of the first component of the first generic vertex attribute in the array in the data store
     *               of the buffer currently bound to GL_ARRAY_BUFFER target
     * @param normalized specifies if the fixed-point data should be normalized(true) when they are accessed
     */
    public void assignAttribPointer(int index, int size, int dataType, int stride, int offset, boolean normalized) {
        bind();

        assert isBound(GL_ARRAY_BUFFER);

        glEnableVertexAttribArray(index);
        glVertexAttribPointer(index, size, dataType, normalized, stride, offset);
    }

    /**
     * Modify the rate at which generic vertex attributes advance during instanced rendering
     *
     * @param index specifies the index of the vertex attribute
     * @param divisor specifies the number of instances the will pass between updates of the generic attribute at slot index
     */
    public void setAttribDivisor(int index, int divisor) {
        bind();
        glVertexAttribDivisor(index, divisor);
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
