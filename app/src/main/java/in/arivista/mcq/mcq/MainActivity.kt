package `in`.arivista.mcq.mcq

import `in`.arivista.mcq.mcq.choiceview.Arivista_Custom_View
import `in`.arivista.mcq.mcq.utils.ChoiceType
import `in`.arivista.mcq.mcq.model.ChoiceModel
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

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

        val arivista_view = findViewById(R.id.arivista_view) as Arivista_Custom_View

        arivista_view.setQuestion("how to implement Radio Buttons?");
        arivista_view.setChoiceType(choicesList, ChoiceType.SINGLE)

        arivista_view.setQuestion("how to implement Radio CheckedBox?");
        arivista_view.setChoiceType(choicesList1, ChoiceType.MULTIPLE)


    }

}
