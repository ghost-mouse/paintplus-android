package top.laoshuzi.kxgraphics.bean

/**
 * Created by laoshuzi on 2020/12/31.
 */
abstract class Mesh {

    companion object {
        fun setXY(array: FloatArray, index: Int, x: Float, y: Float) {
            array[index * 2 + 0] = x
            array[index * 2 + 1] = y
        }
    }

    var widthPart = 40
        private set
    var heightPart = 40
        private set

    val verts: FloatArray


    constructor(w: Int, h: Int) {
        this.widthPart = w
        this.heightPart = h
        verts = FloatArray((w + 1) * (h + 1) * 2)
    }

    open fun buildMeshes(w: Float, h: Float) {
        var index = 0
        for (y in 0..heightPart) {
            val fy: Float = y * h / heightPart
            for (x in 0..widthPart) {
                val fx: Float = x * w / widthPart
                setXY(verts, index, fx, fy)
                index += 1
            }
        }
    }

}