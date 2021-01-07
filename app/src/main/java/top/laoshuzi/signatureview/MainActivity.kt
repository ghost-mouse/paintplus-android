package top.laoshuzi.signatureview

import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import top.laoshuzi.kxgraphics.kxdesign.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val canvas = Canvas()
        val paint = getPaint { toStrokePaint() }
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
            }
        }

        val canvasDesign = CanvasDesign {
            use() {
                fill(0x777777)
                fill(ARGB(127, 127, 127, 127))
                translate(10f, 10f)
                rotate(180f)
                scale(0.5f, 0.5f)
            }
        }
        canvas.design(canvasDesign)

    }
}