import Engine.Object2d;
import Engine.Rectangle;
import Engine.ShaderProgram;
import Engine.Window;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {

    private Window window = new Window(600, 600, "Hello World");

    private ArrayList<Object2d> objects = new ArrayList<>();
    private  ArrayList<Object2d> objectsRectangle = new ArrayList<>();

    public void init() {
        window.init();
        GL.createCapabilities();

//        objects.add(new Object2d(
//                Arrays.asList(
//                    // shaderFile lokasi menyesuaikan objectnya
//                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f, 0.5f, 0.0f),
//                                new Vector3f(-0.5f, -0.5f, 0.0f),
//                                new Vector3f(0.5f, -0.5f, 0.0f)
//                        )
//                ),
//                new Vector4f(0.0f, 1.0f, 0.0f, 0.0f)
//        ));

        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                    // shaderFile lokasi menyesuaikan objectnya
                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-1.0f, -1.0f, 0.0f),
                                new Vector3f(1.0f, -1.0f, 0.0f),
                                new Vector3f(-1.0f, -0.5f, 0.0f),
                                new Vector3f(1.0f, -0.5f, 0.0f)
                        )
                ),
                new Vector4f(0.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0, 1, 2, 1, 2, 3)
        ));

        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.55f, -0.65f, 0.0f),
                                new Vector3f(0.55f, -0.65f, 0.0f),
                                new Vector3f(-0.55f, -0.15f, 0.0f),
                                new Vector3f(0.55f, -0.15f, 0.0f)
                        )
                ),
                new Vector4f(1.0f, 0.65f, 0.0f, 0.0f),
                Arrays.asList(0, 1, 2, 1, 2, 3)
        ));

        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.65f, -0.15f, 0.0f),
                                new Vector3f(-0.45f, 0.2f, 0.0f),
                                new Vector3f(0.45f, 0.2f, 0.0f),
                                new Vector3f(0.65f, -0.15f, 0.0f)
                        )
                ),
                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0, 1, 2, 0, 2, 3)
        ));

        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.55f, -0.15f, 0.0f),
                                new Vector3f(-0.55f, -0.1f, 0.0f),
                                new Vector3f(-0.415f, 0.15f, 0.0f),
                                new Vector3f(-0.215f, -0.15f, 0.0f)
                        )
                ),
                new Vector4f(1.0f, 0.65f, 0.0f, 0.0f),
                Arrays.asList(0, 1, 2, 0, 2, 3)
        ));

        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.275f, 0.1f, 0.0f),
                                new Vector3f(0.275f, 0.275f, 0.0f),
                                new Vector3f(0.2f, 0.275f, 0.0f),
                                new Vector3f(0.2f, 0.1f, 0.0f)
                        )
                ),
                new Vector4f(1.0f, 0.65f, 0.0f, 0.0f),
                Arrays.asList(0, 1, 2, 0, 2, 3)
        ));

        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.275f, 0.1f, 0.0f),
                                new Vector3f(0.275f, 0.275f, 0.0f),
                                new Vector3f(0.2f, 0.275f, 0.0f),
                                new Vector3f(0.2f, 0.1f, 0.0f)
                        )
                ),
                new Vector4f(1.0f, 0.65f, 0.0f, 0.0f),
                Arrays.asList(0, 1, 2, 0, 2, 3)
        ));

//        objects.add(new Object2d(
//                Arrays.asList(
//                    // shaderFile lokasi menyesuaikan objectnya
//                    new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticeColor.vert", GL_VERTEX_SHADER),
//                    new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticeColor.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f, 0.5f, 0.0f),
//                                new Vector3f(-0.5f, -0.5f, 0.0f),
//                                new Vector3f(0.5f, -0.5f, 0.0f)
//                        )
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(1.0f, 0.0f, 0.0f),
//                                new Vector3f(0.0f, 1.0f, 0.0f),
//                                new Vector3f(0.0f, 0.0f, 1.0f)
//                        )
//                )
//        ));

    }

    public void loop() {
        while(window.isOpen()) {
            window.update();
            glClearColor(0.0f, 0.0f, 1.0f, 0.0f);
            GL.createCapabilities();

            // code
            for (Object2d object : objectsRectangle) {
                object.draw();
            }

//            for (Object2d object : objectsRectangle) {
//                object.draw();
//            }

            // Restore state
            glDisableVertexAttribArray(0);

            // Poll for window events
            // The key callback above will only be invoked during this call
            glfwPollEvents();
        }
    }

    public void run() {
        init();
        loop();

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
    public static void main(String[] args) {
        new Main().run();
    }
}