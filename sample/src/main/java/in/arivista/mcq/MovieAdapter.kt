package `in`.arivista.mcq

import android.content.Context
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

import java.util.ArrayList

import `in`.arivista.mcq.mcq.choiceview.ArivistaCustomView
import `in`.arivista.mcq.mcq.model.ChoiceModel
import `in`.arivista.mcq.mcq.utils.ChoiceType

class MovieAdapter(private val mContext: Context, list: ArrayList<ChoiceModel>) : ArrayAdapter<ChoiceModel>(mContext, 0, list) {
    private var moviesList = ArrayList<ChoiceModel>()

    init {
        moviesList = list
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItem = convertView
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_main, parent, false)

        val arivistaview = listItem!!.findViewById<View>(R.id.arivista_view) as ArivistaCustomView

        arivistaview.setQuestion("You are my brother, But I am not your brother?")
        arivistaview.setChoiceType(moviesList, ChoiceType.SINGLE)

        //arivistaview.setQuestion("What kind of Food is Good at morning session?")
        //arivistaview.setChoiceType(moviesList, ChoiceType.MULTIPLE)

        return arivistaview
    }
}