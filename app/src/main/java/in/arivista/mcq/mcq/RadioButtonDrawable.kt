package `in`.arivista.mcq.mcq

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable

internal class RadioButtonDrawable private constructor(builder: Builder) : Drawable(), Animatable {

    private var mRunning = false

    private val mPaint: Paint
    private var mEntranceAnimator: ValueAnimator? = null
    private var mAnimProgress: Float = 0.toFloat()
    private var mScaleFactor = 1f
    private val mInAnimDuration: Int
    private val mOutAnimDuration: Int
    private val mExplodeCounts: Int
    private val mStrokeSize: Int
    private var mWidth: Int = 0
    private val mHeight: Int
    private val mRadius: Int
    private val mInnerRadius: Int
    private var mCurColor: Int = 0
    private val mColorState: ColorStateList?
    private var mChecked = false

    private var mInEditMode = false
    private var mAnimEnable = true

    private var mExplosionsAnimator: ExplosionAnimator? = null
    private var explosionAnimationIsRunning: Boolean? = true

    init {
        mInAnimDuration = builder.mInAnimDuration
        mOutAnimDuration = builder.mOutAnimDuration
        mExplodeCounts = builder.mExplodeCounts
        mStrokeSize = builder.mStrokeSize
        mWidth = (builder.mRadius + builder.mOuterPadding) * 2
        mHeight = mWidth
        mRadius = builder.mRadius
        mInnerRadius = builder.mInnerRadius
        mColorState = builder.mColorStateList

        mPaint = Paint()
        mPaint.isAntiAlias = true
    }

    fun setInEditMode(b: Boolean) {
        mInEditMode = b
    }

    fun setAnimEnable(b: Boolean) {
        mAnimEnable = b
    }

    //    boolean isAnimEnable(){
    //        return mAnimEnable;
    //    }

    override fun getIntrinsicWidth(): Int {
        return mWidth
    }

    override fun getIntrinsicHeight(): Int {
        return mHeight
    }

    override fun getMinimumWidth(): Int {
        return mWidth
    }

    override fun getMinimumHeight(): Int {
        return mHeight
    }

    override fun isStateful(): Boolean {
        return true
    }

    override fun draw(canvas: Canvas) {
        if (mChecked)
            drawChecked(canvas)
        else
            drawUnchecked(canvas)
    }

    private fun drawChecked(canvas: Canvas) {
        val cx = bounds.exactCenterX()
        val cy = bounds.exactCenterY()

        if (isRunning) {
            canvas.scale(1 - mScaleFactor, 1 + mScaleFactor, cx, cy)
            mPaint.color = mCurColor
            mPaint.strokeWidth = mStrokeSize.toFloat()
            mPaint.style = Paint.Style.STROKE
            canvas.drawCircle(cx, cy, mRadius.toFloat(), mPaint)

            mPaint.color = mCurColor
            mPaint.style = Paint.Style.FILL
            val centerY = cy - (mRadius + mStrokeSize) * (1 - mAnimProgress)
            val radius = mInnerRadius * mAnimProgress
            canvas.drawCircle(cx, centerY, radius, mPaint)
        } else {
            mPaint.color = mCurColor
            mPaint.strokeWidth = mStrokeSize.toFloat()
            mPaint.style = Paint.Style.STROKE
            canvas.drawCircle(cx, cy, mRadius.toFloat(), mPaint)

            mPaint.style = Paint.Style.FILL
            canvas.drawCircle(cx, cy, mInnerRadius.toFloat(), mPaint)
        }
    }

    private fun drawUnchecked(canvas: Canvas) {
        val cx = bounds.exactCenterX()
        val cy = bounds.exactCenterY()

        mPaint.color = mCurColor
        mPaint.strokeWidth = mStrokeSize.toFloat()
        mPaint.style = Paint.Style.STROKE
        canvas.drawCircle(cx, cy, mRadius.toFloat(), mPaint)
        if ((!explosionAnimationIsRunning!!)) {
            explosionAnimationIsRunning = true
            val animator = ExplosionAnimator(this, bounds, mCurColor, mExplodeCounts, mRadius, mInnerRadius)
            animator.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    mExplosionsAnimator = null
                }
            })
            animator.duration = mOutAnimDuration.toLong()
            mExplosionsAnimator = animator
            animator.start()
        }
        if (mExplosionsAnimator != null)
            mExplosionsAnimator!!.draw(canvas)
    }

    override fun onStateChange(state: IntArray): Boolean {
        val checked = Utils.hasState(state, android.R.attr.state_checked)
        val color = mColorState!!.getColorForState(state, mCurColor)
        var needRedraw = false

        if (mChecked != checked) {
            mChecked = checked
            explosionAnimationIsRunning = false
            needRedraw = true
            if (!mInEditMode && mAnimEnable)
                start()

        }

        if (mCurColor != color) {
            mCurColor = color
            needRedraw = true
        }

        return needRedraw
    }

    override fun setAlpha(alpha: Int) {
        mPaint.alpha = alpha
    }

    override fun setColorFilter(cf: ColorFilter?) {
        mPaint.colorFilter = cf
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    private fun resetAnimation() {
        mAnimProgress = 0f
    }

    override fun start() {
        resetAnimation()
        startScaleAnimation()
        update()
        invalidateSelf()
    }

    override fun stop() {
        mRunning = false
        invalidateSelf()
    }

    override fun isRunning(): Boolean {
        return mRunning
    }

    private fun startScaleAnimation() {
        mEntranceAnimator = ValueAnimator.ofFloat(0f, 0.1f, 0f, -0.1f, 0f, 0.04f, 0f).setDuration(mInAnimDuration.toLong())
        mEntranceAnimator!!.addUpdateListener { valueAnimator ->
            mScaleFactor = valueAnimator.animatedValue as Float
            invalidateSelf()
        }
        mEntranceAnimator!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animator: Animator) {

            }

            override fun onAnimationEnd(animator: Animator) {
                mRunning = false
            }

            override fun onAnimationCancel(animator: Animator) {
                mRunning = false
            }

            override fun onAnimationRepeat(animator: Animator) {

            }
        })
        mEntranceAnimator!!.start()
    }

    private fun update() {
        mRunning = true
        val animator = ValueAnimator.ofFloat(0F, 1f)
        animator.duration = (mInAnimDuration / 2).toLong()
        animator.addUpdateListener { valueAnimator ->
            mAnimProgress = valueAnimator.animatedValue as Float
            invalidateSelf()
        }
        animator.start()
    }

    internal class Builder {

        var mInAnimDuration: Int = 0
        var mOutAnimDuration: Int = 0
        var mExplodeCounts: Int = 0
        var mStrokeSize: Int = 0
        var mRadius: Int = 0
        var mInnerRadius: Int = 0
        private var mCheckedColor: Int = 0
        private var mUnCheckedColor: Int = 0
        var mOuterPadding: Int = 0
        var mColorStateList: ColorStateList? = null


        fun build(): RadioButtonDrawable {
            val states = arrayOf(intArrayOf(-android.R.attr.state_checked), intArrayOf(android.R.attr.state_checked))
            val colors = intArrayOf(mUnCheckedColor, mCheckedColor)
            mColorStateList = ColorStateList(states, colors)

            return RadioButtonDrawable(this)
        }


        fun strokeSize(size: Int): Builder {
            mStrokeSize = size
            return this
        }

        fun explodeCount(count: Int): Builder {
            mExplodeCounts = count
            return this
        }

        fun checkedColor(color: Int): Builder {
            mCheckedColor = color
            return this
        }

        fun unCheckedColor(color: Int): Builder {
            mUnCheckedColor = color
            return this
        }

        fun radius(radius: Int): Builder {
            mRadius = radius
            return this
        }

        fun innerRadius(radius: Int): Builder {
            mInnerRadius = radius
            return this
        }

        fun outAnimDuration(duration: Int): Builder {
            mOutAnimDuration = duration
            return this
        }

        fun inAnimDuration(duration: Int): Builder {
            mInAnimDuration = duration
            return this
        }

        fun outerPadding(padding: Int): Builder {
            mOuterPadding = padding
            return this
        }
    }
}