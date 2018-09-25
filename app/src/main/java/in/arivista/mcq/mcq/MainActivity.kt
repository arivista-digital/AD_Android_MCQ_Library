package `in`.arivista.mcq.mcq

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity(),QuestionListener {

     var questionPresenter: QuestionPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val choices= arrayListOf<String>("option1","option2","option3","option4")

        val arivista_view=findViewById(R.id.arivista_view) as CustomizedView

        arivista_view.setQuestion("how to implement Radio Buttons?");
        arivista_view.setChoiceType(choices,ChoiceType.SINGLE)
        arivista_view.setQuestion("how to implement Checked Box?");
        arivista_view.setChoiceType(choices,ChoiceType.MULTIPLE)


        var submitBtn=findViewById(R.id.submit) as Button
        var clearBtn=findViewById(R.id.submit) as Button
        var revealBtn=findViewById(R.id.submit) as Button

        submitBtn.setOnClickListener(){
            arivista_view.setAnsColor()
        }
        clearBtn.setOnClickListener(){

        }

        clearBtn.setOnClickListener(){

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
