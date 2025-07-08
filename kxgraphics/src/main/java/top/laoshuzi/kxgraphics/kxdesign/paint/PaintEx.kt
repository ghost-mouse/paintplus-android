package top.laoshuzi.kxgraphics.kxdesign.paint

import android.graphics.Paint

/**
 * Created by laoshuzi on 2021/1/5.
 */

fun getPaint(paint: Paint? = null, flags: Int = 0, block: (Paint.() -> Unit)? = null): Paint {
    val p = paint?.let { Paint(paint) } ?: Paint(flags)
    block?.let { p.it() }
    return p
}

fun Paint.toFillPaint(
    color: Int = this.color
): Paint {
    this.style = Paint.Style.FILL
    return this
}

fun Paint.toStrokePaint(
    strokeWidth: Float = this.strokeWidth,
): Paint {
    this.style = Paint.Style.STROKE
    this.strokeWidth = strokeWidth
    return this
}

fun Paint.toTextPaint(
    textSize: Float = this.textSize,
    textAlign: Paint.Align = this.textAlign,
): Paint {
    this.toStrokePaint()
    this.textSize = textSize
    this.textAlign = textAlign
    return this
}






