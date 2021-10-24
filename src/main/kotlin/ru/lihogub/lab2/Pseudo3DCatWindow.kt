package ru.lihogub.lab2

import org.lwjgl.glfw.GLFW
import org.lwjgl.opengl.GL46
import ru.lihogub.common.FigureUtils
import ru.lihogub.common.Window

class Pseudo3DCatWindow : Window(width = 1000, height = 600, xPos = 500, yPos = 500, title = "Pseudo 3D Cat Window") {
    private var rY = 0.0
    private var rX = 0.0

    override fun onRender() {
        super.onRender()
        GL46.glRotated(rY, 0.0, 1.0, 0.0)
        GL46.glRotated(rX, 1.0, 0.0, 0.0)
        rY = 0.0
        rX = 0.0

        val orangeR = 217.0 / 255.0
        val orangeG = 177.0 / 255.0
        val orangeB = 37.0 / 255.0

        // Head
        FigureUtils.drawBox(orangeR, orangeG, orangeB, 0.0, 0.0, 0.0, 250.0, -250.0, 250.0)
        // Body
        FigureUtils.drawBox(orangeR, orangeG, orangeB, 150.0, -250.0, 0.0, 500.0, -150.0, 250.0)

        // Tail
        FigureUtils.drawBox(orangeR, orangeG * 0.9, orangeB, 650.0, -250.0, 75.0, 250.0, -100.0, 100.0)

        // Legs
        FigureUtils.drawBox(orangeR, orangeG * 0.9, orangeB, 150.0, -400.0, 0.0, 100.0, -150.0, 100.0)
        FigureUtils.drawBox(orangeR, orangeG * 0.9, orangeB, 150.0, -400.0, 150.0, 100.0, -150.0, 100.0)

        FigureUtils.drawBox(orangeR, orangeG * 0.9, orangeB, 550.0, -400.0, 0.0, 100.0, -150.0, 100.0)
        FigureUtils.drawBox(orangeR, orangeG * 0.9, orangeB, 550.0, -400.0, 150.0, 100.0, -150.0, 100.0)

        // Ears
        FigureUtils.drawBox(orangeR, orangeG, orangeB, 150.0, 0.0, 0.0, 100.0, 100.0, 100.0)
        FigureUtils.drawBox(orangeR, orangeG, orangeB, 150.0, 0.0, 150.0, 100.0, 100.0, 100.0)

        FigureUtils.drawBox(0.1, 0.1, 0.1, 150.0, 10.0, 10.0, 0.0, 80.0, 80.0)
        FigureUtils.drawBox(0.1, 0.1, 0.1, 150.0, 10.0, 160.0, 0.0, 80.0, 80.0)

        // Eyes
        FigureUtils.drawBox(0.1, 0.1, 0.1, 0.0, -150.0, 0.0, 100.0, 100.0, 100.0)
        FigureUtils.drawBox(0.1, 0.1, 0.1, 0.0, -150.0, 150.0, 100.0, 100.0, 100.0)

        // Mouth
        FigureUtils.drawBox(0.0, 0.0, 0.0, 0.0, -175.0, 75.0, 100.0, -25.0, 100.0)

        // Moustache
        GL46.glBegin(GL46.GL_LINES)
        GL46.glColor3d(1.0, 1.0, 1.0)
        GL46.glVertex3d(0.0, -155.0, 100.0)
        GL46.glVertex3d(0.0 - 50, -155.0 + 50, 100.0 - 100.0)
        GL46.glEnd()
        GL46.glBegin(GL46.GL_LINES)
        GL46.glColor3d(1.0, 1.0, 1.0)
        GL46.glVertex3d(0.0, -155.0, 100.0)
        GL46.glVertex3d(0.0 - 50, -155.0, 100.0 - 100.0)
        GL46.glEnd()
        GL46.glBegin(GL46.GL_LINES)
        GL46.glColor3d(1.0, 1.0, 1.0)
        GL46.glVertex3d(0.0, -155.0, 100.0)
        GL46.glVertex3d(0.0 - 50, -155.0 - 50, 100.0 - 100.0)
        GL46.glEnd()

        GL46.glBegin(GL46.GL_LINES)
        GL46.glColor3d(1.0, 1.0, 1.0)
        GL46.glVertex3d(0.0, -155.0, 150.0)
        GL46.glVertex3d(0.0 - 50, -155.0 - 50, 150.0 + 100.0)
        GL46.glEnd()
        GL46.glBegin(GL46.GL_LINES)
        GL46.glColor3d(1.0, 1.0, 1.0)
        GL46.glVertex3d(0.0, -155.0, 150.0)
        GL46.glVertex3d(0.0 - 50, -155.0, 150.0 + 100.0)
        GL46.glEnd()
        GL46.glBegin(GL46.GL_LINES)
        GL46.glColor3d(1.0, 1.0, 1.0)
        GL46.glVertex3d(0.0, -155.0, 150.0)
        GL46.glVertex3d(0.0 - 50, -155.0 + 50, 150.0 + 100.0)
        GL46.glEnd()
    }



    override fun onStart() {
        super.onStart()
        GL46.glScaled(1.0 / width, 1.0 / height, 0.002)
    }

    override fun onKeyPressed(key: Int) {
        val ROTATION_SPEED = 2.0
        when(key) {
            GLFW.GLFW_KEY_UP -> rX = ROTATION_SPEED
            GLFW.GLFW_KEY_DOWN -> rX = -ROTATION_SPEED
            GLFW.GLFW_KEY_LEFT -> rY = ROTATION_SPEED
            GLFW.GLFW_KEY_RIGHT -> rY = -ROTATION_SPEED
        }
    }
}