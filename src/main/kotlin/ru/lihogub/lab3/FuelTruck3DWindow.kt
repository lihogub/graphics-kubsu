package ru.lihogub.lab3

import org.lwjgl.glfw.GLFW
import org.lwjgl.opengl.GL11.*
import org.lwjgl.opengl.GL46
import org.lwjgl.util.glu.Cylinder
import ru.lihogub.common.FigureUtils
import ru.lihogub.common.Window
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import kotlin.math.cos
import kotlin.math.sin


class FuelTruck3DWindow : Window(width = 1000, height = 600, xPos = 500, yPos = 500, title = "Fuel Truck Window") {
    private var rY = 0.0
    private var rX = 0.0

    var temp: ByteBuffer = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder())
    private val light_ambient = floatArrayOf(0.1f, 0.0f, 0.0f, 1.0f)

    override fun onStart() {
        super.onStart()

        glMatrixMode(GL_PROJECTION)
        glLoadIdentity()
        glMatrixMode(GL_MODELVIEW)
        glLoadIdentity()
        glShadeModel(GL_SMOOTH)
        glClearDepth(1.0)
        glEnable(GL_DEPTH_TEST)
        glDepthFunc(GL_LEQUAL)
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST)
        // включение нормализации
        glEnable(GL_NORMALIZE)
        // включение цвета материала
        glEnable(GL_COLOR_MATERIAL)
        // включение первого источника света, можно включить и больше GL11.glEnable(GL_LIGHT1);
        glEnable(GL_LIGHT0)
        // включение освещения
        glEnable(GL_LIGHTING)
        glEnable(GL_DEPTH_TEST)

    }

    override fun onRender() {
        super.onRender()
        glLoadIdentity()

        GL46.glLightfv(GL_LIGHT0, GL_POSITION, temp.asFloatBuffer().put(light_ambient).flip() as FloatBuffer)
        GL46.glLightfv(GL_LIGHT1, GL_AMBIENT, temp.asFloatBuffer().put(light_ambient).flip() as FloatBuffer)

        GL46.glScaled(1.0 / width, 1.0 / height, 0.002)
        GL46.glRotated(rY, 0.0, 1.0, 0.0)
        GL46.glRotated(rX, 1.0, 0.0, 0.0)
        FigureUtils.drawBox(230 / 255.0, 126 / 255.0, 34 / 255.0, 0.0, 0.0, 0.0, 80.0, -160.0, 160.0)
        FigureUtils.drawBox(230 / 255.0, 126 / 255.0, 34 / 255.0, 80.0, -80.0, 0.0, 360.0, -80.0, 160.0)

        FigureUtils.drawBox(0.1, 0.1, 0.1, -1.0, -1.0, -1.0, 75.0, -82.0, 162.0)



        val r0 = 0.0
        val r1 = 80.0
        var k = 0.0
        glBegin(GL_POLYGON)
        GL46.glColor3d(192 / 255.0, 57 / 255.0, 43 / 255.0)
        while (k <= 360.0) {
            glVertex3d(
                80.0,
                (r0 - 80 * sin(Math.toRadians(k))),
                (r1 + 80 * cos(Math.toRadians(k)))
            )
            k += 0.1
        }
        glEnd()

        k = 0.0
        glBegin(GL_POLYGON)
        while (k <= 360.0) {
            glVertex3d(
                440.0,
                (r0 - 80 * sin(Math.toRadians(k))),
                (r1 + 80 * cos(Math.toRadians(k)))
            )
            k += 0.1
        }
        glEnd()

        glLoadIdentity()
        glPushMatrix()
        GL46.glScaled(1.0 / width, 1.0 / height, 0.002)

        GL46.glRotated(90.0, 1.0, 0.0, 0.0)
        GL46.glRotated(90.0, 0.0, 1.0, 0.0)

        GL46.glRotated(rY, 1.0, 0.0, 0.0)
        GL46.glRotated(rX, 0.0, 0.0, 1.0)

        GL46.glTranslated(0.0, 80.0, 80.0)
        Cylinder().draw(80f, 80f, 360.0f, 16, 16)
        glPopMatrix()


        GL46.glColor3d(0.5, 0.5, 0.5)

        drawWheel(40.0, -160.0, 140.0)
        drawWheel(40.0, -160.0, -10.0)

        drawWheel(400.0, -160.0, 140.0)
        drawWheel(400.0, -160.0, -10.0)

        drawWheel(340.0, -160.0, 140.0)
        drawWheel(340.0, -160.0, -10.0)

        drawWheel(280.0, -160.0, 140.0)
        drawWheel(280.0, -160.0, -10.0)
    }

    private fun drawWheel(x: Double, y: Double, z: Double) {
        glLoadIdentity()
        glPushMatrix()
        GL46.glScaled(1.0 / width, 1.0 / height, 0.002)

        GL46.glRotated(rY, 0.0, 1.0, 0.0)
        GL46.glRotated(rX, 1.0, 0.0, 0.0)

        GL46.glTranslated(x, y, z)
        Cylinder().draw(30f, 30f, 30.0f, 16, 16)
        glPopMatrix()

        GL46.glScaled(1.0 / width, 1.0 / height, 0.002)
        GL46.glRotated(rY, 0.0, 1.0, 0.0)
        GL46.glRotated(rX, 1.0, 0.0, 0.0)


        var k = 0.0
        glBegin(GL_POLYGON)
        while (k <= 360.0) {
            glVertex3d(
                (x + 30 * cos(Math.toRadians(k))),
                (y - 30 * sin(Math.toRadians(k))),
                z
            )
            k += 0.1
        }
        glEnd()

        k = 0.0
        glBegin(GL_POLYGON)
        while (k <= 360.0) {
            glVertex3d(
                (x + 30 * cos(Math.toRadians(k))),
                (y - 30 * sin(Math.toRadians(k))),
                z + 30
            )
            k += 0.1
        }
        glEnd()
    }

    override fun onKeyPressed(key: Int) {
        val ROTATION_SPEED = 2.0
        when(key) {
            GLFW.GLFW_KEY_UP -> rX += ROTATION_SPEED
            GLFW.GLFW_KEY_DOWN -> rX += -ROTATION_SPEED
            GLFW.GLFW_KEY_LEFT -> rY += ROTATION_SPEED
            GLFW.GLFW_KEY_RIGHT -> rY += -ROTATION_SPEED
        }
    }
}