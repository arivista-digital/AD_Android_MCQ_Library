package `in`.arivista.mcq.mcq

import android.content.Context
import android.support.v7.widget.AppCompatCheckBox
import android.support.v7.widget.AppCompatRadioButton
import android.util.AttributeSet

class ArivistaCheckedButton : AppCompatCheckBox {

    object properties: CheckButtonProperties()

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
        textSize = properties.CHECK_BUTTON_SIZE
        setTextColor(properties.CHECK_BUTTON_DEFAULT_COLOR)
    }


}