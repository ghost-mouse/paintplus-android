package top.laoshuzi.signatureview

import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import top.laoshuzi.kxgraphics.kxdesign.*
import top.laoshuzi.kxgraphics.kxdesign.canvas.*
import top.laoshuzi.kxgraphics.kxdesign.paint.getPaint
import top.laoshuzi.kxgraphics.kxdesign.paint.toStrokePaint
import top.laoshuzi.kxgraphics.kxdesign.path.PathDesign

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val canvas = Canvas()
        val paint = getPaint { toStrokePaint() }

        val canvasDesign = CanvasDesign {
            use() {
                fill(0x777777)
            }
        }
        canvas.design(canvasDesign)

        canvas.design {
            use() {
                fill(0x777777)
                fill(ARGB(127, 127, 127, 127))
                translate(10f, 10f)
                rotate(180f)
                scale(0.5f, 0.5f)
            }
            use(paint) {
                draw(Circle(1f, 1f, 5f))
                drawCircle(1f, 1f, 5f)
                draw(Oval(5f, 10f, 5f, 10f))
                drawOval(5f, 10f, 5f, 10f)
            }

            use(paint) {
                val pathDesign = PathDesign() {

                }
                draw(pathDesign)

                drawPath {

                }

            }
        }

    }
}