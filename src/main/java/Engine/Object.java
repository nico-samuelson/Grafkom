package Engine;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL30.*;

public class Object extends ShaderProgram {

    public List<Vector3f> vertices, verticesColor;
    int vao, vbo, vboColor;
    UniformsMap uniformsMap;
    Vector4f color;
    Matrix4f model;

    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        uniformsMap.createUniform("model");
        this.color = color;
        model = new Matrix4f().identity();
    }

    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOWithVerticesColor();
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

    public void setupVAOVBOWithVerticesColor() {
        // set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        // set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);

        // set vbo color
        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(verticesColor), GL_STATIC_DRAW);
    }

    public void drawSetup() {
        bind();
        uniformsMap.setUniform("uni_color", color);
        uniformsMap.setUniform("model", model);

        // bind VBO
       glEnableVertexAttribArray(0);
       glBindBuffer(GL_ARRAY_BUFFER, vbo);
       glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
    }

    public void drawSetupWithVerticesColor() {
        bind();

        // bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);

        // bind VBOColor
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glVertexAttribPointer(1, 3, GL_FLOAT, false, 0, 0);
    }

    public void draw() {
        drawSetup();

        // optional
        glLineWidth(1); // ketebalan garis
        glPointSize(0); // besar kecil vertex
        // wajib
        // GL_LINE, GL_LINE_STRIP, GL_lINE_LOOP, GL_TRIANGLES, GL_TRIANGLE_FAN, GL_POINT -> YG SERING DIPAKAI
        glDrawArrays(GL_TRIANGLE_FAN, 0, vertices.size());
    }

    public void drawLine() {
        drawSetup();
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
    }

    public void addVertices(Vector3f newVertices) {
        vertices.add(newVertices);
        setupVAOVBO();
    }

    public void drawWithVerticesColor() {
        drawSetupWithVerticesColor();

        // optional
        glLineWidth(1); // ketebalan garis
        glPointSize(0); // besar kecil vertex
        // wajib
        // GL_LINE, GL_LINE_STRIP, GL_lINE_LOOP, GL_TRIANGLES, GL_TRIANGLE_FAN, GL_POINT -> YG SERING DIPAKAI
        glDrawArrays(GL_TRIANGLES, 0, vertices.size());
    }

    public void translateObject(float offsetX, float offsetY, float offsetZ) {
        model = new Matrix4f().translate(offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
    }

    public void rotateObject(float deg, float x, float y, float z) {
        model = new Matrix4f().rotate(deg, x, y, z).mul(new Matrix4f(model));
    }

    public void scaleObject(float scaleX, float scaleY, float scaleZ) {
        model = new Matrix4f().scale(scaleX, scaleY, scaleZ).mul(new Matrix4f(model));
    }
}