package `in`.arivista.mcq.mcq

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(),QuestionListener {

     var questionPresenter: QuestionPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //questionPresenter= QustionImplementation(this);

        val sureshText=findViewById(R.id.sureshText) as ArivistaTextView
        sureshText.setText("Hi")


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
