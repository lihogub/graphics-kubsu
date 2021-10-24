package ru.lihogub

import org.lwjgl.opengl.GL46

class BosniaAndHerzegovinaFlagWindow :
    Window(width = 800, height = 400, xPos = 500, yPos = 500, title = "Bosnia and Herzegovina flag") {

    override fun onRender() {
        super.onRender()

        GL46.glBegin(GL46.GL_QUADS)
        GL46.glColor3d(0.0, 47.0 / 255, 108.0 / 255)
        GL46.glVertex2d(-1.0, 1.0)
        GL46.glVertex2d(-1.0, -1.0)
        GL46.glVertex2d(1.0, -1.0)
        GL46.glVertex2d(1.0, 1.0)
        GL46.glEnd()

        GL46.glBegin(GL46.GL_TRIANGLES)
        GL46.glColor3d(1.0, 205.0 / 255, 0.0)
        GL46.glVertex2d(-0.5, 1.0)
        GL46.glVertex2d(0.5, 1.0)
        GL46.glVertex2d(0.5, -1.0)
        GL46.glEnd()

        for (i in 0..9) {
            drawStar(-0.65 + i * 0.12, 1.0 - 2 * i * 0.12)
        }
    }

    private fun drawStar(x: Double, y: Double) {
        val size = 0.002
        GL46.glColor3d(1.0, 1.0, 1.0);
        GL46.glBegin(GL46.GL_POLYGON);
        GL46.glVertex2d(x - 40 * size, y + 26 * size)
        GL46.glVertex2d(x + 40 * size, y + 26 * size)
        GL46.glVertex2d(x + 0 * size, y - 32 * size)
        GL46.glEnd();

        GL46.glBegin(GL46.GL_POLYGON);
        GL46.glVertex2d(x - 25 * size, y - 68 * size)
        GL46.glVertex2d(x + 0 * size, y + 80 * size)
        GL46.glVertex2d(x + 15 * size, y - 10 * size)
        GL46.glEnd();

        GL46.glBegin(GL46.GL_POLYGON);
        GL46.glVertex2d(x + 25 * size, y - 68 * size)
        GL46.glVertex2d(x + 0 * size, y + 80 * size)
        GL46.glVertex2d(x - 15 * size, y - 10 * size)
        GL46.glEnd();
    }
}