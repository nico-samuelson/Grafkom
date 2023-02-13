package Engine;

import org.joml.Vector3f;

import java.util.List;

import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL15.*;

public class Object2d extends ShaderProgram {

    List<Vector3f> vertices;
    int vao;
    int vbo;

    public Object2d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
    }

    public void setupVAOVBO() {
        // set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        // set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);
    }

    public void drawSetup() {
        bind();

        // bind VBO
       glEnableVertexAttribArray(0);
       glBindBuffer(GL_ARRAY_BUFFER, vbo);
       glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
    }

    public void draw() {
        drawSetup();

        // optional
        glLineWidth(1); // ketebalan garis
        glPointSize(0); // besar kecil vertex
        // wajib
        // GL_LINE, GL_LINE_STRIP, GL_lINE_LOOP, GL_TRIANGLES, GL_TRIANGLE_FAN, GL_POINT -> YG SERING DIPAKAI
        glDrawArrays(GL_LINE_LOOP, 0, vertices.size());
    }
}
