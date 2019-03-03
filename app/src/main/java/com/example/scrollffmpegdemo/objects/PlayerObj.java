package com.example.scrollffmpegdemo.objects;

import com.example.scrollffmpegdemo.data.VertexArray;
import com.example.scrollffmpegdemo.programs.PlayerProgram;

import static android.opengl.GLES20.GL_POINTS;
import static android.opengl.GLES20.glDrawArrays;

/**
 * @author yetote QQ:503779938
 * @name ScrollFFmpegDemo
 * @class name：com.example.scrollffmpegdemo.objects
 * @class describe
 * @time 2019/3/1 10:18
 * @change
 * @chang time
 * @class describe
 */
public class PlayerObj {
    float[] vertexData = new float[]{
            //    @formatter:off
             1f, 1f,1f,0f,
            -1f, 1f,0f,0f,
            -1f,-1f,0f,1f,

            -1f,-1f,0f,1f,
             1f,-1f,1f,1f,
             1f, 1f,1f,0f
            //    @formatter:on
    };
    VertexArray vertexArray;
    public static final int POSITION_COMPONENT_COUNT = 2;
    public static final int TEXTURE_COMPONENT_COUNT = 2;
    public static final int STRIDE = (POSITION_COMPONENT_COUNT + TEXTURE_COMPONENT_COUNT) * 4;

    public PlayerObj() {
        vertexArray = new VertexArray(vertexData);
     }

     public void bindData(PlayerProgram program){
         vertexArray.setVertexAttributePointer(0, program.getaPosition(), POSITION_COMPONENT_COUNT, STRIDE);
         vertexArray.setVertexAttributePointer(POSITION_COMPONENT_COUNT, program.getaTextureCoordinates(), TEXTURE_COMPONENT_COUNT, STRIDE);

     }

    public void draw() {
        glDrawArrays(GL_POINTS, 0, 1);
    }
}
