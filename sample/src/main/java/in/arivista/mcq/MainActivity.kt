package `in`.arivista.mcq

import `in`.arivista.mcq.mcq.choiceview.ArivistaChoiceView
import `in`.arivista.mcq.mcq.model.ChoiceModel
import `in`.arivista.mcq.mcq.utils.ChoiceType
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val choicesListques1 = ArrayList<ChoiceModel>()
        choicesListques1.add(ChoiceModel(1, "1. Friend", false))
        choicesListques1.add(ChoiceModel(2, "2. Daughter", false))
        choicesListques1.add(ChoiceModel(3, "3. Mother", false))
        choicesListques1.add(ChoiceModel(4, "4. Sister", true))
        choicesListques1.add(ChoiceModel(4, "5. Lover", false))


        val choicesList1 = ArrayList<ChoiceModel>()
        choicesList1.add(ChoiceModel(1, "1. Idily", true))
        choicesList1.add(ChoiceModel(2, "2. Pongal", true))
        choicesList1.add(ChoiceModel(3, "3. Chicken", false))
        choicesList1.add(ChoiceModel(4, "4. Meat", false))


        val arivistaview = findViewById<ArivistaChoiceView>(R.id.arivista_view)

        arivistaview.setQuestion("You are my brother, But I am not your brother?");
        arivistaview.setChoiceType(choicesListques1, ChoiceType.SINGLE)

        arivistaview.setQuestion("What kind of Food is Good at morning session?")
        arivistaview.setChoiceType(choicesList1, ChoiceType.MULTIPLE)

    }
}
