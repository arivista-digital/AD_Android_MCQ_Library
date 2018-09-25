package `in`.arivista.mcq.mcq


import android.content.Context
import android.text.Layout
import android.util.AttributeSet
import android.view.View
import android.widget.*


open class CustomizedView : LinearLayout {
    var textview: ArivistaTextView? = null
    var radioButton: Arivista_RadioButton? = null
    var radioGrop:RadioGroup?=null

    var ctx: Context? = null

    constructor(context: Context) : super(context) {
        ctx = context
        init()

    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        ctx = context

        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        ctx = context
        init()
    }

    private fun init() {
//        orientation = VERTICAL

    }

    fun addTextView(quetion: String) {
        View.inflate(context, R.layout.custom_layout, this)
        orientation = VERTICAL
        val textView = ArivistaTextView(context)
        textView.setText(quetion)
        textView.setOnClickListener() {
            Toast.makeText(context, "Text Clicked", Toast.LENGTH_LONG).show()
        }
        addView(textView)
    }

    fun addRadioButton(choice: String) {
         radioButton = Arivista_RadioButton(context)
        //radioGrop.addView(radioButton)
        radioButton!!.setText(choice)
        radioGrop?.addView(radioButton)

    }

    fun addCheckedBox(choice: String) {
        val checkBox =  ArivistaCheckedButton(context)
        checkBox.setText(choice)
        addView(checkBox)
    }

    fun setQuestion(quetion: String) {
        addTextView(quetion)
    }

    fun setChoiceType(choices: ArrayList<String>, choiceType: ChoiceType) {
        if (choiceType == ChoiceType.SINGLE) {
            View.inflate(context, R.layout.custom_radiobutton, this)
            radioGrop = RadioGroup(context)
            for (choice in choices) {
                addRadioButton(choice)
            }
            addView(radioGrop)
        } else {
            View.inflate(context, R.layout.custom_checkedbox, this)
            for (choice in choices) {
                addCheckedBox(choice)
            }
        }
    }

    fun setAnsColor(){
        val checkedRadioButtonId = radioGrop!!.getCheckedRadioButtonId()
        val selectedView = findViewById(checkedRadioButtonId) as RadioButton
        if(selectedView!!.isChecked){
            radioButton!!.setAnswerColor(Arivista_RadioButton.radioProperties.RADIO_BUTTON_CORRECT_COLOR)
        }

    }
}