package Engine;
import org.joml.Vector3f;
import org.joml.Vector4f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.lwjgl.opengl.GL30.*;

public class Sphere extends Circle {
    float radiusZ;
    int sectorCount, stackCount;

    public int currAngle;

    public Sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f centerPoint, float radiusX, float radiusY, float radiusZ, int sectorCount, int stackCount) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.sectorCount = sectorCount;
        this.stackCount = stackCount;
        this.currAngle = 0;
        createSphere();
    }

    public void createBox() {
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();

        // Titik 1
        temp.x = centerPoint.x - radiusX / 2.0f;
        temp.y = centerPoint.y + radiusY / 2.0f;
        temp.z = centerPoint.z - radiusZ / 2.0f;
        tempVertices.add(temp);

        // Titik 2
        temp = new Vector3f();
        temp.x = centerPoint.x + radiusX / 2.0f;
        temp.y = centerPoint.y + radiusY / 2.0f;
        temp.z = centerPoint.z - radiusZ / 2.0f;
        tempVertices.add(temp);
        System.out.println(tempVertices.get(1));

        // Titik 3
        temp = new Vector3f();
        temp.x = centerPoint.x + radiusX / 2.0f;
        temp.y = centerPoint.y - radiusY / 2.0f;
        temp.z = centerPoint.z - radiusZ / 2.0f;
        tempVertices.add(temp);

        // Titik 4
        temp = new Vector3f();
        temp.x = centerPoint.x - radiusX / 2.0f;
        temp.y = centerPoint.y - radiusY / 2.0f;
        temp.z = centerPoint.z - radiusZ / 2.0f;
        tempVertices.add(temp);

        // Titik 5
        temp = new Vector3f();
        temp.x = centerPoint.x - radiusX / 2.0f;
        temp.y = centerPoint.y + radiusY / 2.0f;
        temp.z = centerPoint.z + radiusZ / 2.0f;
        tempVertices.add(temp);

        // Titik 6
        temp = new Vector3f();
        temp.x = centerPoint.x + radiusX / 2.0f;
        temp.y = centerPoint.y + radiusY / 2.0f;
        temp.z = centerPoint.z + radiusZ / 2.0f;
        tempVertices.add(temp);

        // Titik 7
        temp = new Vector3f();
        temp.x = centerPoint.x + radiusX / 2.0f;
        temp.y = centerPoint.y - radiusY / 2.0f;
        temp.z = centerPoint.z + radiusZ / 2.0f;
        tempVertices.add(temp);

        // Titik 8
        temp = new Vector3f();
        temp.x = centerPoint.x - radiusX / 2.0f;
        temp.y = centerPoint.y - radiusY / 2.0f;
        temp.z = centerPoint.z + radiusZ / 2.0f;
        tempVertices.add(temp);

        System.out.println(tempVertices);
        vertices.clear();

        // blkg
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));

        // depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));

        // kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));

        // kanan
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));

        // atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));

        // bawah
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));

        System.out.println(vertices);
        setupVAOVBO();
    }

    public void createSphere() {
        float pi = (float)Math.PI;
        float sectorStep = 2 * pi / sectorCount;
        float stackStep = 2 * pi / stackCount;
        float sectorAngle, stackAngle, x, y, z;

        for (int i = 0; i <= stackCount; ++i) {
            stackAngle = pi / 2 - i * stackStep;
            x = radiusX * (float)Math.cos(stackAngle);
            y = radiusY * (float)Math.cos(stackAngle);
            z = radiusZ * (float)Math.sin(stackAngle);

            for (int j = 0; j <= sectorCount; ++j) {
                sectorAngle = j * sectorStep;
                Vector3f temp_vector = new Vector3f();
                temp_vector.x = centerPoint.x + x * (float)Math.cos(sectorAngle);
                temp_vector.y = centerPoint.y + y * (float)Math.sin(sectorAngle);
                temp_vector.z = centerPoint.z + z;

                vertices.add(temp_vector);
                setupVAOVBO();
            }
        }
    }

    public void createEllipsoid() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI/2; v <= Math.PI/2; v+= Math.PI/36) {
            for (double u = -Math.PI; u<= Math.PI; u+= Math.PI/36) {
                float x = radiusX * (float) (Math.cos(v) * Math.cos(u));
                float y = radiusY * (float) (Math.cos(v) * Math.sin(u));
                float z = radiusZ * (float) (Math.sin(v));
                temp.add(new Vector3f(x, y, z));
            }
        }

        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void createHyperboloidOne() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI/2; v <= Math.PI/2; v+= Math.PI/60) {
            for (double u = -Math.PI; u <= Math.PI; u+= Math.PI/60) {
                float x = radiusX * (float) ((1 / Math.cos(v)) * Math.cos(u));
                float y = radiusY * (float) ((1 / Math.cos(v)) * Math.sin(u));
                float z = radiusZ * (float) (Math.tan(v));
                temp.add(new Vector3f(x, z, y));
            }
        }

        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void createHyperBoloidTwo() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI/2; v <= Math.PI/2; v+= Math.PI/60) {
            for (double u1 = -Math.PI/2; u1 <= Math.PI/2; u1 += Math.PI/60) {
                float x = radiusX * (float) (Math.tan(v) * Math.cos(u1));
                float y = radiusY * (float) (Math.tan(v) * Math.sin(u1));
                float z = radiusZ * (float) (1/ Math.cos(v));
                temp.add(new Vector3f(x, z, y));
            }
            for (double u2 = Math.PI/2; u2 <= 3 * Math.PI/2; u2 += Math.PI/60) {
                float x = radiusX * (float) (Math.tan(v) * Math.cos(u2));
                float y = radiusY * (float) (Math.tan(v) * Math.sin(u2));
                float z = radiusZ * (float) (1/ Math.cos(v));
                temp.add(new Vector3f(x, z, y));
            }
        }

        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void createEllipticCone() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI/2; v <= Math.PI/2; v+= Math.PI/100) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI/60) {
                float x = radiusX * (float) (v * Math.cos(u));
                float y = radiusY * (float) (v * Math.sin(u));
                float z = radiusZ * (float) v;
                temp.add(new Vector3f(x, z, y));
            }
        }

        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void createEllipticParaboloid() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = Math.PI; v >= 0; v-= Math.PI/60) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI/60) {
                float x = radiusX * (float) (v * Math.cos(u));
                float y = radiusY * (float) (v * Math.sin(u));
                float z = (float) (v * v);
                temp.add(new Vector3f(x, z, y));
            }
        }

        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void createHyperboloidParaboloid() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = Math.PI; v >= 0; v-= Math.PI/60) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI/60) {
                float x = radiusX * (float) (v * Math.tan(u));
                float y = radiusY * (float) (v * (1 / Math.cos(u)));
                float z = (float) (v * v);
                temp.add(new Vector3f(x, y, z));
            }
        }

        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void draw() {
//        System.out.println("tes");
        drawSetup();

        // optional
        glLineWidth(10); // ketebalan garis
        glPointSize(10); // besar kecil vertex
        // wajib
        // GL_LINE, GL_LINE_STRIP, GL_lINE_LOOP, GL_TRIANGLES, GL_TRIANGLE_FAN, GL_POINT -> YG SERING DIPAKAI
        glDrawArrays(GL_POLYGON, 0, vertices.size());
        for (Object child : childObject) {
            child.draw();
        }
    }
}