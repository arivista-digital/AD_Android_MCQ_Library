package `in`.arivista.mcq.mcq

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val choicesList = ArrayList<QuestionModal>()
        choicesList.add(QuestionModal(1, "Option 1", true))
        choicesList.add(QuestionModal(2, "Option 2", false))
        choicesList.add(QuestionModal(3, "Option 3", false))
        choicesList.add(QuestionModal(4, "Option 4", false))

        val arivista_view = findViewById(R.id.arivista_view) as Arivista_Custom_View


        //Buttons Control
        var submitBtn = findViewById(R.id.submit) as Button
        var clearBtn = findViewById(R.id.clear) as Button
        var revealBtn = findViewById(R.id.reveal) as Button

        arivista_view.buttonInitialization(submitBtn, clearBtn, revealBtn)

        arivista_view.setQuestion("how to implement Radio Buttons?");
        arivista_view.setChoiceType(choicesList, ChoiceType.SINGLE)

        //Answer Submit
        submitBtn.setOnClickListener() {
            arivista_view.setSumbitAnswer(choicesList)
            arivista_view.submitButtonVisibility(submitBtn,false)
        }
        //Clear Checked Radio Buttons
        clearBtn.setOnClickListener() {
            arivista_view.radioClearChecked()
            arivista_view.revealButtonVisibility(revealBtn,false)
            arivista_view.submitButtonVisibility(submitBtn,false)
            arivista_view.clearButtonVisibility(clearBtn,false)
        }
        //Reveal Answers
        revealBtn.setOnClickListener() {
            arivista_view.answerReveal(choicesList)
            arivista_view.submitButtonVisibility(submitBtn,false)
            arivista_view.clearButtonVisibility(clearBtn,true)
        }

        //questionPresenter= QustionImplementation(this);

    }

}
