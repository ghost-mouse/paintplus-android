package top.laoshuzi.kxgraphics.kxdesign

import android.graphics.*

/**
 * Created by laoshuzi on 2021/1/5.
 */
open class Design(var canvas: Canvas)

open class PaintDesign(canvas: Canvas, var paint: Paint) : Design(canvas)

/**
 *  填充RGB
 */
fun Design.fill(rgb: RGB) {
    drawRGB(rgb.r, rgb.g, rgb.b)
}

fun Design.drawRGB(r: Int, g: Int, b: Int) {
    canvas.drawRGB(r, g, b)
}

/**
 *  填充ARGB
 */
fun Design.fill(argb: ARGB) {
    drawARGB(argb.a, argb.r, argb.g, argb.b)
}

fun Design.drawARGB(a: Int, r: Int, g: Int, b: Int) {
    canvas.drawARGB(a, r, g, b)
}

/**
 *  填充color
 */
fun Design.fill(color: Int) {
    drawColor(color)
}

fun Design.drawColor(color: Int, mode: PorterDuff.Mode = PorterDuff.Mode.SRC_OVER) {
    canvas.drawColor(color, mode)
}

/**
 *  绘制任意
 */
infix fun PaintDesign.draw(block: PaintDesign.() -> Unit) {
    block()
}

/**
 *  绘制一个点
 */
fun PaintDesign.draw(point: PointF) {
    drawPoint(point.x, point.y)
}

fun PaintDesign.drawPoint(x: Float, y: Float) {
    canvas.drawPoint(x, y, paint)
}

/**
 *  绘制多个点
 */
fun PaintDesign.draw(points: Array<PointF>) {
    val pts = FloatArray(points.size * 2)
    points.forEachIndexed { index, pointF ->
        pts[index * 2] = pointF.x
        pts[index * 2 + 1] = pointF.y
    }
    drawPoints(pts)
}

fun PaintDesign.drawPoints(pts: FloatArray, offset: Int = 0, count: Int = pts.size) {
    canvas.drawPoints(pts, offset, count, paint)
}

/**
 *  绘制一条线
 */
fun PaintDesign.draw(line: LineF) {
    drawLine(line.startX, line.startY, line.stopX, line.stopY)
}

fun PaintDesign.drawLine(startX: Float, startY: Float, stopX: Float, stopY: Float) {
    canvas.drawLine(startX, startY, stopX, stopY, paint)
}

/**
 *  绘制多条线
 */
fun PaintDesign.draw(lines: Array<LineF>) {
    val pts = FloatArray(lines.size * 4)
    lines.forEachIndexed { index, lineF ->
        pts[index * 4] = lineF.startX
        pts[index * 4 + 1] = lineF.startY
        pts[index * 4 + 2] = lineF.stopX
        pts[index * 4 + 3] = lineF.stopY
    }
    drawLines(pts)
}

fun PaintDesign.drawLines(pts: FloatArray, offset: Int = 0, count: Int = pts.size) {
    canvas.drawLines(pts, offset, count, paint)
}

/**
 *  绘制一个矩形
 */
fun PaintDesign.draw(rect: Rect) {
    drawRect(rect.left.toFloat(), rect.top.toFloat(), rect.right.toFloat(), rect.bottom.toFloat())
}

fun PaintDesign.draw(rect: RectF) {
    drawRect(rect.left, rect.top, rect.right, rect.bottom)
}

fun PaintDesign.drawRect(left: Float, top: Float, right: Float, bottom: Float) {
    canvas.drawRect(left, top, right, bottom, paint)
}

/**
 *  绘制一个圆角矩形
 */
fun PaintDesign.draw(rect: Rect, rx: Float, ry: Float) {
    drawRoundRect(
        rect.left.toFloat(),
        rect.top.toFloat(),
        rect.right.toFloat(),
        rect.bottom.toFloat(),
        rx,
        ry
    )
}

fun PaintDesign.draw(rect: RectF, rx: Float, ry: Float) {
    drawRoundRect(
        rect.left,
        rect.top,
        rect.right,
        rect.bottom,
        rx, ry
    )
}

fun PaintDesign.drawRoundRect(
    left: Float,
    top: Float,
    right: Float,
    bottom: Float,
    rx: Float,
    ry: Float
) {
    canvas.drawRoundRect(left, top, right, bottom, rx, ry, paint)
}

/**
 *  绘制一个圆
 */
fun PaintDesign.draw(circle: Circle) {
    drawCircle(circle.cx, circle.cy, circle.radius)
}

fun PaintDesign.drawCircle(cx: Float, cy: Float, radius: Float) {
    canvas.drawCircle(cx, cy, radius, paint)
}

/**
 *  绘制一个椭圆
 */
fun PaintDesign.draw(oval: Oval) {
    drawOval(oval.left, oval.top, oval.right, oval.bottom)
}

fun PaintDesign.drawOval(left: Float, top: Float, right: Float, bottom: Float) {
    canvas.drawOval(left, top, right, bottom, paint)
}

/**
 *  绘制一个圆弧
 */
fun PaintDesign.draw(oval: Oval, startAngle: Float, sweepAngle: Float, useCenter: Boolean) {
    drawArc(oval.left, oval.top, oval.right, oval.bottom, startAngle, sweepAngle, useCenter)
}

fun PaintDesign.drawArc(
    left: Float,
    top: Float,
    right: Float,
    bottom: Float,
    startAngle: Float,
    sweepAngle: Float,
    useCenter: Boolean
) {
    canvas.drawArc(left, top, right, bottom, startAngle, sweepAngle, useCenter, paint)
}

/**
 *  绘制路径
 */
fun PaintDesign.draw(path: Path) {
    drawPath(path)
}

fun PaintDesign.drawPath(path: Path) {
    canvas.drawPath(path, paint)
}

/**
 *  绘制文字
 */

fun PaintDesign.draw(text: CharSequence, x: Float, y: Float) {
    drawText(text, x, y)
}

fun PaintDesign.draw(text: String, x: Float, y: Float) {
    drawText(text, x, y)
}

fun PaintDesign.draw(text: CharArray, x: Float, y: Float) {
    drawText(text, x, y)
}

fun PaintDesign.drawText(
    text: CharSequence,
    x: Float,
    y: Float,
    start: Int = 0,
    end: Int = text.length
) {
    canvas.drawText(text, start, end, x, y, paint)
}

fun PaintDesign.drawText(
    text: String,
    x: Float,
    y: Float,
    start: Int = 0,
    end: Int = text.length
) {
    canvas.drawText(text, start, end, x, y, paint)
}

fun PaintDesign.drawText(
    text: CharArray,
    x: Float,
    y: Float,
    index: Int = 0,
    count: Int = text.size
) {
    canvas.drawText(text, index, count, x, y, paint)
}

fun PaintDesign.drawTextOnPath(
    text: String,
    path: Path,
    hOffset: Float,
    vOffset: Float
) {
    canvas.drawTextOnPath(text, path, hOffset, vOffset, paint)
}

fun PaintDesign.drawTextOnPath(
    text: CharArray,
    path: Path,
    hOffset: Float,
    vOffset: Float,
    index: Int = 0,
    count: Int = text.size
) {
    canvas.drawTextOnPath(text, index, count, path, hOffset, vOffset, paint)
}

/**
 *  绘制位图
 */
fun PaintDesign.drawBitmap(bitmap: Bitmap, matrix: Matrix) {
    canvas.drawBitmap(bitmap, matrix, paint)
}

fun PaintDesign.drawBitmap(bitmap: Bitmap, src: Rect, dst: Rect) {
    canvas.drawBitmap(bitmap, src, dst, paint)
}

fun PaintDesign.drawBitmap(bitmap: Bitmap, src: Rect, dst: RectF) {
    canvas.drawBitmap(bitmap, src, dst, paint)
}

fun PaintDesign.drawBitmap(bitmap: Bitmap, left: Float, top: Float) {
    canvas.drawBitmap(bitmap, left, top, paint)
}

/**
 *  绘制顶点操作位图
 */
fun PaintDesign.drawBitmapMesh(
    bitmap: Bitmap,
    meshWidth: Int,
    meshHeight: Int,
    verts: FloatArray,
    vertOffset: Int = 0,
    colors: IntArray? = null,
    colorOffset: Int = 0
) {
    canvas.drawBitmapMesh(
        bitmap,
        meshWidth,
        meshHeight,
        verts,
        vertOffset,
        colors,
        colorOffset,
        paint
    )
}

fun PaintDesign.drawVertices(
    vertexMode: Canvas.VertexMode,
    vertexCount: Int,
    verts: FloatArray,
    vertOffset: Int = 0,
    texs: FloatArray,
    texOffset: Int = 0,
    colors: IntArray,
    colorOffset: Int = 0,
    indices: ShortArray,
    indexOffset: Int = 0,
    indexCount: Int = 0
) {
    canvas.drawVertices(
        vertexMode,
        vertexCount,
        verts,
        vertOffset,
        texs,
        texOffset,
        colors,
        colorOffset,
        indices,
        indexOffset,
        indexCount,
        paint
    )
}

/**
 *  裁剪路径
 */
fun Design.clip(path: Path) {
    clipPath(path)
}

fun Design.clipPath(path: Path) {
    canvas.clipPath(path)
}

/**
 *  裁剪矩形
 */
fun Design.clip(rect: Rect) {
    clipRect(rect)
}

fun Design.clip(rect: RectF) {
    clipRect(rect)
}

fun Design.clipRect(rect: Rect) {
    canvas.clipRect(rect)
}

fun Design.clipRect(left: Int, top: Int, right: Int, bottom: Int) {
    canvas.clipRect(left, top, right, bottom)
}

fun Design.clipRect(left: Float, top: Float, right: Float, bottom: Float) {
    canvas.clipRect(left, top, right, bottom)
}

fun Design.clipRect(rect: RectF) {
    canvas.clipRect(rect)
}

/**
 *  变形
 */
fun Design.matrix(matrix: Matrix) {
    canvas.setMatrix(matrix)
}

fun Design.concat(matrix: Matrix) {
    canvas.concat(matrix)
}

fun Design.translate(dx: Float, dy: Float) {
    canvas.translate(dx, dy)
}

fun Design.scale(sx: Float, sy: Float, point: PointF = PointF(0f, 0f)) {
    scale(sx, sy, point.x, point.y)
}

fun Design.scale(sx: Float, sy: Float) {
    canvas.scale(sx, sy)
}

fun Design.scale(sx: Float, sy: Float, px: Float, py: Float) {
    canvas.scale(sx, sy, px, py)
}

fun Design.rotate(degrees: Float, point: PointF = PointF(0f, 0f)) {
    rotate(degrees, point.x, point.y)
}

fun Design.rotate(degrees: Float) {
    canvas.rotate(degrees)
}

fun Design.rotate(degrees: Float, px: Float, py: Float) {
    canvas.rotate(degrees, px, py)
}

fun Design.skew(sx: Float, sy: Float) {
    canvas.skew(sx, sy)
}


//open class CommonDesign : Design() {
//
//    var designs = mutableListOf<Design>()
//
//    fun addDesign(design: Design) {
//        designs.add(design)
//    }
//}
//
//fun CommonDesign.design(block: Design.() -> Unit): Design {
//    val design = crateDesign(block)
//    addDesign(design)
//    return design
//}










