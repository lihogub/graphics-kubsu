package ru.lihogub.lab4

import org.lwjgl.glfw.GLFW
import org.lwjgl.opengl.GL11
import org.lwjgl.opengl.GL46
import org.lwjgl.util.glu.Sphere
import ru.lihogub.common.Window
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer

class LightMovingWindow : Window(width = 1000, height = 600, xPos = 500, yPos = 500, title = "Parabolic LightLight Window") {
    private var rY = 0.0
    private var rX = 0.0

    private var lightX = 0.0

    private val lightZ
        get() = lightX * lightX / 500

    var temp: ByteBuffer = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder())
    private val light_ambient = floatArrayOf(1.0f, 1.0f, 1.0f, 1.0f)


    override fun onStart() {
        super.onStart()

        GL11.glMatrixMode(GL11.GL_PROJECTION)
        GL11.glLoadIdentity()
        GL11.glMatrixMode(GL11.GL_MODELVIEW)
        GL11.glLoadIdentity()
        GL11.glShadeModel(GL11.GL_SMOOTH)
        GL11.glClearDepth(1.0)
        GL11.glEnable(GL11.GL_DEPTH_TEST)
        GL11.glDepthFunc(GL11.GL_LEQUAL)
        GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST)
        // включение нормализации
        GL11.glEnable(GL11.GL_NORMALIZE)
        // включение цвета материала
        GL11.glEnable(GL11.GL_COLOR_MATERIAL)
        // включение первого источника света, можно включить и больше GL11.glEnable(GL_LIGHT1);
        GL11.glEnable(GL11.GL_LIGHT0)
        // включение освещения
        GL11.glEnable(GL11.GL_LIGHTING)
        GL11.glEnable(GL11.GL_DEPTH_TEST)
    }

    override fun onRender() {
        GL11.glLoadIdentity()


        GL46.glScaled(1.0 / width, 1.0 / height, 1.0 / (width + height))
        GL46.glRotated(rY, 0.0, 1.0, 0.0)
        GL46.glRotated(rX, 1.0, 0.0, 0.0)

        Sphere().draw(50.0f, 32, 32)

        GL46.glLineWidth(5.0f)
        // X axis
        GL46.glBegin(GL46.GL_LINES)
        GL46.glColor3d(1.0, 0.0, 0.0)
        GL46.glVertex3d(0.0, 0.0, 0.0)
        GL46.glVertex3d(100.0, 0.0, 0.0)
        GL46.glEnd()

        // Y axis
        GL46.glBegin(GL46.GL_LINES)
        GL46.glColor3d(0.0, 1.0, 0.0)
        GL46.glVertex3d(0.0, 0.0, 0.0)
        GL46.glVertex3d(0.0, 100.0, 0.0)
        GL46.glEnd()

        // Z axis
        GL46.glBegin(GL46.GL_LINES)
        GL46.glColor3d(0.0, 0.0, 1.0)
        GL46.glVertex3d(0.0, 0.0, 0.0)
        GL46.glVertex3d(0.0, 0.0, 100.0)
        GL46.glEnd()

        GL46.glTranslated(lightX, 0.0, lightZ)
        GL46.glColor3d(1.0, 1.0, 1.0)
        GL46.glLightfv(GL11.GL_LIGHT0, GL11.GL_POSITION, temp.asFloatBuffer().put(light_ambient).flip() as FloatBuffer)
        GL46.glLightfv(GL11.GL_LIGHT1, GL11.GL_AMBIENT, temp.asFloatBuffer().put(light_ambient).flip() as FloatBuffer)
        Sphere().draw(10.0f, 32, 32)
        GL46.glTranslated(-lightX, 0.0, -lightZ)

//        Sphere().draw(50.0f, 32, 32)


    }

    override fun onKeyPressed(key: Int) {
        val ROTATION_SPEED = 2.0
        val LIGHT_DELTA_X = 5.0
        when(key) {
            GLFW.GLFW_KEY_UP -> rX += ROTATION_SPEED
            GLFW.GLFW_KEY_DOWN -> rX += -ROTATION_SPEED
            GLFW.GLFW_KEY_LEFT -> rY += ROTATION_SPEED
            GLFW.GLFW_KEY_RIGHT -> rY += -ROTATION_SPEED
            GLFW.GLFW_KEY_KP_ADD -> lightX += LIGHT_DELTA_X
            GLFW.GLFW_KEY_KP_SUBTRACT -> lightX -= LIGHT_DELTA_X
        }
        println(lightX)
    }
}