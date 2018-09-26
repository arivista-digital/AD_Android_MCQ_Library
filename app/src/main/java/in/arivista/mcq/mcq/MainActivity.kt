package `in`.arivista.mcq.mcq

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity(),QuestionListener {

     var questionPresenter: QuestionPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val choicesList=ArrayList<QuestionModal>()
        choicesList.add(QuestionModal(1,"s",true))
        choicesList.add(QuestionModal(2,"r",false))
        choicesList.add(QuestionModal(3,"t",false))
        choicesList.add(QuestionModal(4,"gfh",false))

        val arivista_view=findViewById(R.id.arivista_view) as CustomizedView

        arivista_view.setQuestion("how to implement Radio Buttons?");
        arivista_view.setChoiceType(choicesList,ChoiceType.SINGLE)
        arivista_view.setQuestion("how to implement Checked Box?");
        arivista_view.setChoiceType(choicesList,ChoiceType.MULTIPLE)


        var submitBtn=findViewById(R.id.submit) as Button
        var clearBtn=findViewById(R.id.clear) as Button
        var revealBtn=findViewById(R.id.reveal) as Button

        //Answer Submit
        submitBtn.setOnClickListener(){
            arivista_view.setAnsColor(choicesList)
        }
        //Clear Radio Buttons
        clearBtn.setOnClickListener(){
            arivista_view.radioClearChecked()
        }
        //Reveal Answers
        revealBtn.setOnClickListener(){
            arivista_view.answerReveal(choicesList)
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
