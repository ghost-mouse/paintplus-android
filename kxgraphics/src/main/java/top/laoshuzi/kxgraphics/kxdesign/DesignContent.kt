package top.laoshuzi.kxgraphics.kxdesign


/**
 * Created by laoshuzi on 2021/1/6.
 */
open class RGB(
    var r: Int = 0,
    var g: Int = 0,
    var b: Int = 0
)

open class ARGB(
    var a: Int = 255,
    r: Int = 0,
    g: Int = 0,
    b: Int = 0
) : RGB(r, g, b)


open class LineF(
    var startX: Float = 0f,
    var startY: Float = 0f,
    var stopX: Float = 0f,
    var stopY: Float = 0f
)

open class Circle(
    var cx: Float = 0f,
    var cy: Float = 0f,
    var radius: Float = 0f
)

open class Oval(
    var left: Float = 0f,
    var top: Float = 0f,
    var right: Float = 0f,
    var bottom: Float = 0f
)
