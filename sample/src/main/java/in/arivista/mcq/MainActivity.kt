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
        choicesList1.add(ChoiceModel(1, "Option 1", true))
        choicesList1.add(ChoiceModel(2, "Option 2", false))
        choicesList1.add(ChoiceModel(3, "Option 3", true))
        choicesList1.add(ChoiceModel(4, "Option 4", false))

        val arivistaview = findViewById<ArivistaCustomView>(R.id.arivista_view)

        arivistaview.setQuestion("You are my brother, But I am not your brother?");
        arivistaview.setChoiceType(choicesListques1, ChoiceType.SINGLE)

        arivistaview.setQuestion("how to implement Radio CheckedBox?");
        arivistaview.setChoiceType(choicesList1, ChoiceType.MULTIPLE)


    }
}
