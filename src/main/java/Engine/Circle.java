package Engine;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Circle extends Object {

    Vector3f centerPoint;
    float radiusX;
    float radiusY;

    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f centerPoint, float radiusX, float radiusY) {
        super(shaderModuleDataList, vertices, color);
        this.centerPoint = centerPoint;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    public void createCircle(double inc) {
        for (double i = 0; i <= 360; i += inc) {
            float x1 = (float) (centerPoint.x + radiusX * Math.sin(Math.toRadians(i)));
            float y1 = (float) (centerPoint.y + radiusY * Math.cos(Math.toRadians(i)));
            float z = 0;
            vertices.add(new Vector3f(x1, y1, z));
        }
    }
}
