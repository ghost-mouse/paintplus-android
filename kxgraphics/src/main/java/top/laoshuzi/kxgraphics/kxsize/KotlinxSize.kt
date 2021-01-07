package top.laoshuzi.kxgraphics.kxsize

import android.content.res.Resources

/**
 * Created by laoshuzi on 2021/1/5.
 */

class Sp(val value: Float) {
    constructor(value: Int) : this(value.toFloat())
}

class Dp(val value: Float) {
    constructor(value: Int) : this(value.toFloat())
}

class Px(val value: Float) {
    constructor(value: Int) : this(value.toFloat())
}

val Float.sp: Sp
    get() = Sp(this)
val Int.sp: Sp
    get() = Sp(this)

val Float.dp: Dp
    get() = Dp(this)
val Int.dp: Dp
    get() = Dp(this)

val Float.px: Px
    get() = Px(this)
val Int.px: Px
    get() = Px(this)

fun Sp.toPx(): Float = this.value * Resources.getSystem().displayMetrics.scaledDensity
fun Dp.toPx(): Float = this.value * Resources.getSystem().displayMetrics.density
fun Px.toSp(): Float = this.value / Resources.getSystem().displayMetrics.scaledDensity
fun Px.toDp(): Float = this.value / Resources.getSystem().displayMetrics.density
