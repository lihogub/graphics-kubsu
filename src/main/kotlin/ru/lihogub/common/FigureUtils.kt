package ru.lihogub.common

import org.lwjgl.opengl.GL46

object FigureUtils {
    fun drawBox(
        red: Double, green: Double, blue: Double,
        x: Double, y: Double, z: Double,
        dX: Double, dY: Double, dZ: Double
    ) {
        GL46.glBegin(GL46.GL_QUADS)
        GL46.glColor3d(red, green, blue)
        GL46.glVertex3d(x, y, z)
        GL46.glVertex3d(x + dX, y, z)
        GL46.glVertex3d(x + dX, y +dY, z)
        GL46.glVertex3d(x, y + dY, z)
        GL46.glEnd()

        GL46.glBegin(GL46.GL_QUADS)
        GL46.glColor3d(red, green, blue)
        GL46.glVertex3d(x, y, z + dZ)
        GL46.glVertex3d(x + dX, y, z + dZ)
        GL46.glVertex3d(x + dX, y +dY, z + dZ)
        GL46.glVertex3d(x, y + dY, z + dZ)
        GL46.glEnd()


        GL46.glBegin(GL46.GL_QUADS)
        GL46.glColor3d(red, green, blue)
        GL46.glVertex3d(x, y, z)
        GL46.glVertex3d(x, y + dY, z)
        GL46.glVertex3d(x, y + dY, z + dZ)
        GL46.glVertex3d(x, y, z + dZ)
        GL46.glEnd()

        GL46.glBegin(GL46.GL_QUADS)
        GL46.glColor3d(red, green, blue)
        GL46.glVertex3d(x + dX, y, z)
        GL46.glVertex3d(x + dX, y + dY, z)
        GL46.glVertex3d(x + dX, y + dY, z + dZ)
        GL46.glVertex3d(x + dX, y, z + dZ)
        GL46.glEnd()

        GL46.glBegin(GL46.GL_QUADS)
        GL46.glColor3d(red, green, blue)
        GL46.glVertex3d(x, y, z)
        GL46.glVertex3d(x + dX, y, z)
        GL46.glVertex3d(x + dX, y, z + dZ)
        GL46.glVertex3d(x, y, z + dZ)
        GL46.glEnd()

        GL46.glBegin(GL46.GL_QUADS)
        GL46.glColor3d(red, green, blue)
        GL46.glVertex3d(x, y + dY, z)
        GL46.glVertex3d(x + dX, y + dY, z)
        GL46.glVertex3d(x + dX, y + dY, z + dZ)
        GL46.glVertex3d(x, y + dY, z + dZ)
        GL46.glEnd()
    }
}