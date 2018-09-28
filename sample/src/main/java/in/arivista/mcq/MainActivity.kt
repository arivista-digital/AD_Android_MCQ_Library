package `in`.arivista.mcq

import `in`.arivista.mcq.mcq.choiceview.ArivistaCustomView
import `in`.arivista.mcq.mcq.model.ChoiceModel
import `in`.arivista.mcq.mcq.utils.ChoiceType
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)


            val choicesList = ArrayList<ChoiceModel>()
            choicesList.add(ChoiceModel(1, "Option 1", true))
            choicesList.add(ChoiceModel(2, "Option 2", false))
            choicesList.add(ChoiceModel(3, "Option 3", false))
            choicesList.add(ChoiceModel(4, "Option 4", false))

            val choicesList1 = ArrayList<ChoiceModel>()
            choicesList1.add(ChoiceModel(1, "Option 1", true))
            choicesList1.add(ChoiceModel(2, "Option 2", false))
            choicesList1.add(ChoiceModel(3, "Option 3", true))
            choicesList1.add(ChoiceModel(4, "Option 4", false))

            val arivistaview = findViewById<ArivistaCustomView>(R.id.arivista_view)

            arivistaview.setQuestion("how to implement Radio Buttons?");
            arivistaview.setChoiceType(choicesList, ChoiceType.SINGLE)

            arivistaview.setQuestion("how to implement Radio CheckedBox?");
            arivistaview.setChoiceType(choicesList1, ChoiceType.MULTIPLE)


    }
}
