package com.example.scrollffmpegdemo.programs;

import android.content.Context;
import android.opengl.GLES20;
import android.util.Log;

import com.example.scrollffmpegdemo.R;

import static android.opengl.GLES20.GL_TEXTURE0;
import static android.opengl.GLES20.glActiveTexture;
import static android.opengl.GLES20.glBindTexture;
import static android.opengl.GLES20.glGetAttribLocation;
import static android.opengl.GLES20.glGetUniformLocation;
import static android.opengl.GLES20.glUniform1i;

/**
 * @author yetote QQ:503779938
 * @name ScrollFFmpegDemo
 * @class name：com.example.scrollffmpegdemo.programs
 * @class describe
 * @time 2019/3/1 10:18
 * @change
 * @chang time
 * @class describe
 */
public class PlayerProgram extends ShaderProgram {
    public static int aPosition;
    public static int aTextureCoordinates;
    public static int uTextureY;
    public static int uTextureU;
    public static int uTextureV;
    private static final String TAG = "PlayerProgram";
    private int[] uTextureArr = new int[]{
            uTextureY, uTextureU, uTextureV
    };

    public PlayerProgram(Context context) {
        super(context, R.raw.yuv_vertex_shader, R.raw.yuv_frag_shader);
        aPosition = glGetAttribLocation(program, A_POSITION);
        aTextureCoordinates = glGetAttribLocation(program, A_TEXTURE_COORDINATES);
        uTextureY = glGetUniformLocation(program, U_TEXTURE_Y);
        uTextureU = glGetUniformLocation(program, U_TEXTURE_U);
        uTextureV = glGetUniformLocation(program, U_TEXTURE_V);
    }

    public int getaPosition() {
        return aPosition;
    }

    public int getaTextureCoordinates() {
        return aTextureCoordinates;
    }

    public void setUniform(int[] textureArr) {
        if (textureArr.length != 3) {
            Log.e(TAG, "setUniform: " + "纹理数量错误");
            return;
        }
        for (int i = 0; i < 3; i++) {
            glActiveTexture(GL_TEXTURE0 + i);
            glBindTexture(GL_TEXTURE0 + i, textureArr[i]);
            glUniform1i(uTextureArr[i], i);
        }
    }
}
