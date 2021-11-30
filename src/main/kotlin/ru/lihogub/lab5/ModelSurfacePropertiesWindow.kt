package ru.lihogub.lab5

import org.lwjgl.glfw.GLFW
import org.lwjgl.opengl.GL46.*
import org.lwjgl.util.glu.Sphere
import ru.lihogub.common.Window
import java.nio.ByteBuffer
import java.nio.ByteOrder


class ModelSurfacePropertiesWindow : Window(width = 1000, height = 600, xPos = 500, yPos = 500, title = "Parabolic LightLight Window") {
    private var rY = 0.0
    private var rX = 0.0
    private var rE = 100.0f

    private val zero_position = floatArrayOf(0.0f, 0.0f, 0.0f, 1.0f)
    private val no_mat = floatArrayOf(0.0f, 0.0f, 0.0f, 1.0f)
    private val mat_dif = floatArrayOf(0.2f, 0.1f, 0.8f, 1.0f)
    private val mat_spec = floatArrayOf(1f, 1f, 1f, 1f)
    private val mat_emis = floatArrayOf(1f, 1f, 0f, 1f)
    private val no_shine = 0f
    private val low_shine = 5f
    private val hi_shine = 128f


    override fun onStart() {
        super.onStart()
        glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT )
        glClearColor(0.5f, 0.5f, 0.5f, 0.0f)
        glEnable(GL_NORMALIZE)
        glEnable(GL_COLOR_MATERIAL)
        glEnable(GL_DEPTH_TEST)
        glShadeModel(GL_SMOOTH)
        glEnable(GL_LIGHTING)
        glEnable(GL_LIGHT0)
    }

    override fun onRender() {
        glLoadIdentity()

        glScaled(1.0 / width, 1.0 / height, 1.0 / (width + height))

        glRotated(rY, 0.0, 1.0, 0.0)
        glRotated(rX, 1.0, 0.0, 0.0)

        glMaterialfv(GL_FRONT_AND_BACK, GL_AMBIENT, no_mat)
        glMaterialfv(GL_FRONT_AND_BACK, GL_DIFFUSE, mat_dif)
        glMaterialfv(GL_FRONT_AND_BACK, GL_SPECULAR, mat_spec)
        glMaterialf(GL_FRONT_AND_BACK, GL_SHININESS, no_shine)
        glMaterialfv(GL_FRONT_AND_BACK, GL_EMISSION, no_mat)
        Sphere().draw(50f, 32, 32)

        glTranslated(0.0, 100.0, 0.0)
        glMaterialfv(GL_FRONT_AND_BACK, GL_AMBIENT, no_mat)
        glMaterialfv(GL_FRONT_AND_BACK, GL_DIFFUSE, mat_dif)
        glMaterialfv(GL_FRONT_AND_BACK, GL_SPECULAR, mat_spec)
        glMaterialf(GL_FRONT_AND_BACK, GL_SHININESS, low_shine)
        glMaterialfv(GL_FRONT_AND_BACK, GL_EMISSION, no_mat)
        Sphere().draw(50f, 32, 32)
        glTranslated(0.0, -100.0, 0.0)

        glTranslated(0.0, 200.0, 0.0)
        glMaterialfv(GL_FRONT_AND_BACK, GL_AMBIENT, no_mat)
        glMaterialfv(GL_FRONT_AND_BACK, GL_DIFFUSE, mat_dif)
        glMaterialfv(GL_FRONT_AND_BACK, GL_SPECULAR, mat_spec)
        glMaterialf(GL_FRONT_AND_BACK, GL_SHININESS, hi_shine)
        glMaterialfv(GL_FRONT_AND_BACK, GL_EMISSION, no_mat)
        Sphere().draw(50f, 32, 32)
        glTranslated(0.0, -200.0, 0.0)

        glTranslated(0.0, 300.0, 0.0)
        glMaterialfv(GL_FRONT_AND_BACK, GL_AMBIENT, no_mat)
        glMaterialfv(GL_FRONT_AND_BACK, GL_DIFFUSE, no_mat)
        glMaterialfv(GL_FRONT_AND_BACK, GL_SPECULAR, mat_spec)
        glMaterialf(GL_FRONT_AND_BACK, GL_SHININESS, hi_shine)
        glMaterialfv(GL_FRONT_AND_BACK, GL_EMISSION, no_mat)
        Sphere().draw(50f, 32, 32)
        glTranslated(0.0, -300.0, 0.0)

        glTranslated(0.0, 400.0, 0.0)
        glMaterialfv(GL_FRONT_AND_BACK, GL_AMBIENT, no_mat)
        glMaterialfv(GL_FRONT_AND_BACK, GL_DIFFUSE, mat_dif)
        glMaterialfv(GL_FRONT_AND_BACK, GL_SPECULAR, no_mat)
        glMaterialf(GL_FRONT_AND_BACK, GL_SHININESS, no_shine)
        glMaterialfv(GL_FRONT_AND_BACK, GL_EMISSION, mat_emis)
        Sphere().draw(50f, 32, 32)
        glTranslated(0.0, -400.0, 0.0)

        glTranslated(rE.toDouble(), 0.0, 0.0)

        glLightfv(GL_LIGHT0, GL_POSITION, zero_position)

        glPopMatrix()
    }

    override fun onKeyPressed(key: Int) {
        val ROTATION_SPEED = 2.0
        when(key) {
            GLFW.GLFW_KEY_UP -> rX += ROTATION_SPEED
            GLFW.GLFW_KEY_DOWN -> rX += -ROTATION_SPEED
            GLFW.GLFW_KEY_LEFT -> rY += ROTATION_SPEED
            GLFW.GLFW_KEY_RIGHT -> rY += -ROTATION_SPEED
            GLFW.GLFW_KEY_KP_DIVIDE -> rE -= 10f
            GLFW.GLFW_KEY_KP_MULTIPLY -> rE += 10f
        }
        println(rE)
    }
}