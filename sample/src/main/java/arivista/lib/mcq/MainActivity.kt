package arivista.lib.mcq

import arivista.lib.mcq.choiceview.ArivistaChoiceView
import arivista.lib.mcq.model.ChoiceModel
import arivista.lib.mcq.utils.ChoiceType
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val choicesSingle = ArrayList<ChoiceModel>()
        choicesSingle.add(ChoiceModel(1, "Option 1", false))
        choicesSingle.add(ChoiceModel(2, "Option 2", false))
        choicesSingle.add(ChoiceModel(3, "Option 3", false))
        choicesSingle.add(ChoiceModel(4, "Option 4", true))
        choicesSingle.add(ChoiceModel(5, "Option 5", false))


        val choicesMulti = ArrayList<ChoiceModel>()
        choicesMulti.add(ChoiceModel(1, "Option 1", true))
        choicesMulti.add(ChoiceModel(2, "Option 2", true))
        choicesMulti.add(ChoiceModel(3, "Option 3", false))
        choicesMulti.add(ChoiceModel(4, "Option 4", false))
        choicesMulti.add(ChoiceModel(5, "Option 5", false))


        val arivistaview = findViewById<ArivistaChoiceView>(R.id.arivista_view)

        arivistaview.setQuestion("Single choice question?");
        arivistaview.setChoiceType(choicesSingle, ChoiceType.SINGLE)

        arivistaview.setQuestion("Multi choice question?")
        arivistaview.setChoiceType(choicesMulti, ChoiceType.MULTIPLE)

    }
}
