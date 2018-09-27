package `in`.arivista.mcq.mcq.utils

import android.content.res.Resources

internal object Utils {

    private val DENSITY = Resources.getSystem().displayMetrics.density

    fun dp2Px(dp: Int): Int {
        return Math.round(dp * DENSITY)
    }

    fun hasState(states: IntArray?, state: Int): Boolean {
        if (states == null)
            return false

        for (state1 in states)
            if (state1 == state)
                return true

        return false
    }
}