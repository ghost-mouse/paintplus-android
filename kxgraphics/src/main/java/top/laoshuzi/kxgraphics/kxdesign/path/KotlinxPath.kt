package top.laoshuzi.kxgraphics.kxdesign.path

import android.graphics.*
import top.laoshuzi.kxgraphics.kxdesign.canvas.*

open class PathClipDesign(var path: Path, canvas: Canvas) : Design(canvas)

open class PathPaintDesign(var path: Path, canvas: Canvas, paint: Paint) :
    PaintDesign(canvas, paint)

/**
 *  绘制路径
 */
fun PathPaintDesign.draw(path: Path) {
    drawPath(path)
}