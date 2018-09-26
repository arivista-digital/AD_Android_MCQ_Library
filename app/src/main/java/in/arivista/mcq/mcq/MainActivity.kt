package `in`.arivista.mcq.mcq

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity(), QuestionListener {

    var questionPresenter: QuestionPresenter? = null

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
//        arivista_view.setQuestion("how to implement Checked Box?");
//        arivista_view.setChoiceType(choicesList,ChoiceType.MULTIPLE)


        //Answer Submit
        submitBtn.setOnClickListener() {
            arivista_view.setSumbitAnswer(choicesList)
            submitBtn.isEnabled = false
            revealBtn!!.isEnabled = true
        }
        //Clear Checked Radio Buttons
        clearBtn.setOnClickListener() {
            arivista_view.radioClearChecked()
            revealBtn.isEnabled = false
            submitBtn.isEnabled = false
            clearBtn.isEnabled = false
        }
        //Reveal Answers
        revealBtn.setOnClickListener() {
            arivista_view.answerReveal(choicesList)
            submitBtn.isEnabled = false
            clearBtn.isEnabled = true
        }

        //questionPresenter= QustionImplementation(this);

    }

    //Success Listener
    override fun onSuccess() {
        questionPresenter!!.addCheckBox()
        questionPresenter!!.addRadioButton()
    }

    //Failure Listener
    override fun onFailure() {
        questionPresenter!!.errorFound()
    }
}
