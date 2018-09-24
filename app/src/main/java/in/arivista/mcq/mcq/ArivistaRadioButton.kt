package `in`.arivista.mcq.mcq

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.AppCompatRadioButton
import android.support.v7.widget.DrawableUtils
import android.util.AttributeSet

class ArivistaRadioButton : AppCompatRadioButton {

    object properties: RadioButtonProperties()

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

    }


}