package top.laoshuzi.kxgraphics.kxdesign.canvas

import android.graphics.*

/**
 * Created by laoshuzi on 2021/1/5.
 */
class CanvasDesign(var block: Canvas.() -> Unit)

fun CanvasDesign.design(canvas: Canvas) {
    canvas.block()
}

fun Canvas.design(block: Canvas.() -> Unit) {
    block()
}

fun Canvas.design(canvasDesign: CanvasDesign) {
    canvasDesign.design(this)
}

fun Canvas.use(): Design {
    return Design(this)
}

fun Canvas.use(block: Design.() -> Unit) {
    use().apply(block)
}

fun Canvas.use(paint: Paint): PaintDesign {
    return PaintDesign(this, paint)
}

fun Canvas.use(paint: Paint, block: PaintDesign.() -> Unit) {
    use(paint).apply(block)
}


//fun Canvas.designs(block: CommonDesign.() -> Unit) {
//    val commonDesign = CommonDesign()
//    commonDesign.block()
//}



