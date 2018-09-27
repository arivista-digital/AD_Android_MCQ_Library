package `in`.arivista.mcq.mcq.choiceview

import `in`.arivista.mcq.mcq.R
import `in`.arivista.mcq.mcq.utils.RadioButtonDrawable
import `in`.arivista.mcq.mcq.utils.RadioButtonProperties
import `in`.arivista.mcq.mcq.utils.Utils
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet

class Arivista_RadioButton : android.support.v7.widget.AppCompatRadioButton {

    val radioProperties = RadioButtonProperties()

    private var mCircleRadius = Utils.dp2Px(6)
    private var mStrokeWidth = Utils.dp2Px(2)
    private var mExplodeCounts = 5
    private var mStrokeRadius = Utils.dp2Px(10)
    private var mOuterPadding = Utils.dp2Px(4)
    private var mInAnimDuration = 400
    private var mOutAnimDuration = 300
    private var mCheckedColor = radioProperties.RADIO_BUTTON_DEFAULT_COLOR
    private var mUnCheckedColor = Color.GRAY


    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    protected fun init(attrs: AttributeSet?) {
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.ArivistaRadioButton)
            mCircleRadius = a.getDimensionPixelOffset(R.styleable.ArivistaRadioButton_lrb_innerCircleRadius, mCircleRadius)
            mStrokeRadius = a.getDimensionPixelOffset(R.styleable.ArivistaRadioButton_lrb_strokeRadius, mStrokeRadius)
            mStrokeWidth = a.getDimensionPixelOffset(R.styleable.ArivistaRadioButton_lrb_strokeWidth, mStrokeWidth)
            mOuterPadding = a.getDimensionPixelOffset(R.styleable.ArivistaRadioButton_lrb_outterPadding, mOuterPadding)
            mExplodeCounts = a.getInt(R.styleable.ArivistaRadioButton_lrb_explodeCount, mExplodeCounts)
            mInAnimDuration = a.getInt(R.styleable.ArivistaRadioButton_lrb_inAnimDuration, mInAnimDuration)
            mOutAnimDuration = a.getInt(R.styleable.ArivistaRadioButton_lrb_outAnimDuration, mOutAnimDuration)
            mCheckedColor = a.getColor(R.styleable.ArivistaRadioButton_lrb_checkedColor, mCheckedColor)
            mUnCheckedColor = a.getColor(R.styleable.ArivistaRadioButton_lrb_unCheckedColor, mUnCheckedColor)
        }
        if (mCircleRadius > mStrokeRadius)
            throw IllegalArgumentException("Outer radius can't be less than Inner Radius")
        setColor(setColorDefault())

    }

    fun setColor(value: Int) {
        val drawable = RadioButtonDrawable.Builder()
                .inAnimDuration(mInAnimDuration)
                .outAnimDuration(mOutAnimDuration)
                .radius(mStrokeRadius)
                .innerRadius(mCircleRadius)
                .strokeSize(mStrokeWidth)
                .explodeCount(mExplodeCounts)
                .checkedColor(value)
                .unCheckedColor(mUnCheckedColor)
                .outerPadding(mOuterPadding)
                .build()
        drawable.setInEditMode(isInEditMode)
        drawable.setAnimEnable(false)
        buttonDrawable = drawable
        drawable.setAnimEnable(true)
    }

    private fun setColorDefault(): Int {
        return RadioButtonProperties().RADIO_BUTTON_DEFAULT_COLOR
    }

    override fun toggle() {
        // we override to prevent toggle when the radio is already
        // checked (as opposed to check boxes widgets)
        if (!isChecked) {
            super.toggle()
        }
    }

    override fun onSaveInstanceState(): Parcelable? {
        super.onSaveInstanceState()
        val bundle = Bundle()
        bundle.putParcelable("superState", super.onSaveInstanceState())
        bundle.putBoolean("isChecked", isChecked)
        return bundle
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        var state = state
        if (state != null && state is Bundle) {
            val bundle = state as Bundle?
            isChecked = bundle!!.getBoolean("isChecked", false)
            state = bundle.getParcelable("superState")
        }
        super.onRestoreInstanceState(state)
    }
}