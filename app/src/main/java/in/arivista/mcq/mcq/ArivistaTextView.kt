package `in`.arivista.mcq.mcq

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.widget.TextView

class ArivistaTextView : AppCompatTextView {

    object properties: TextViewProperties()

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        initView()
    }

    constructor(context: Context, attributeSet: AttributeSet, style: Int) : super(context, attributeSet, style) {
        initView()
    }

    fun initView() {
        textSize = properties.DEFAULT_TEXT_FONT_SIZE
        typeface = properties.DEFAULT_TEXT_FONT_FAMILIY
        setTextColor(properties.DEFAULT_TEXT_FONT_COLOR)
    }


}