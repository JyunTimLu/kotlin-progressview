package tw.timlu.progressview

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


/**
 * Created by juntinglu on 2017/5/20.
 */
class ProgressView : View {

    var paint : Paint = Paint()
    var paint2 : Paint = Paint()

    var firstColor = 0
    var secondColor = 0

    var width : Double = 0.0
    var height : Double = 0.0
    var secondWidth : Double = 0.0
    var secondHeight : Double = 0.0

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    constructor(context: Context) :super(context)

    constructor(context: Context, attrs: AttributeSet) :super(context, attrs) {
        val attrs : TypedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.ProgressView, 0, 0)
        firstColor = attrs.getColor(R.styleable.ProgressView_firstColor, Color.WHITE)
        secondColor = attrs.getColor(R.styleable.ProgressView_secondColor, Color.WHITE)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = firstColor
        paint2.color = secondColor
        canvas?.drawRect(0.toFloat(), 0.toFloat(), width.toFloat(), height.toFloat(), paint)
        if (secondWidth != 0.0 && secondHeight != 0.0) {
            canvas?.drawRect(width.toFloat(), 0.toFloat(), width.toFloat() + secondWidth.toFloat()
                    , secondHeight.toFloat(), paint2)
        }
    }

    fun setWH(width:Double, height:Double) {
        this.width = width
        this.height = height
        invalidate()
    }

    fun setSWH(width:Double, height:Double) {
        this.secondWidth = width
        this.secondHeight = height
        invalidate()
    }

}