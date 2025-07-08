package top.laoshuzi.kxgraphics.kxdesign.path

import android.graphics.Path

/**
 * Created by laoshuzi on 2021/1/19.
 */
class PathDesign(var block: Path.() -> Unit)

fun PathDesign.design(path: Path) {
    path.block()
}