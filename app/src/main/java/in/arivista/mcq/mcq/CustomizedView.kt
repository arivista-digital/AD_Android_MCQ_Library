package `in`.arivista.mcq.mcq


import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.*
import android.widget.RadioGroup


open class CustomizedView : LinearLayout {
    var textview: ArivistaTextView? = null
    var radioButton: Arivista_RadioButton? = null
    var radioGroup: RadioGroup? = null

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

    //Add Text View
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

    //Add Radio Buttons
    fun addRadioButton(choice: String) {
        radioButton = Arivista_RadioButton(context)
        //radioGroup.addView(radioButton)
        radioButton!!.setText(choice)
        radioGroup?.addView(radioButton)
    }

    //Add Check boxes
    fun addCheckedBox(choice: String) {
        val checkBox = ArivistaCheckedButton(context)
        checkBox.setText(choice)
        addView(checkBox)
    }

    //Set question Titls
    fun setQuestion(quetion: String) {
        addTextView(quetion)
    }

    //Add  Radio Buttons and checkboxes
    fun setChoiceType(choices: ArrayList<QuestionModal>, choiceType: ChoiceType) {
        if (choiceType == ChoiceType.SINGLE) {
            View.inflate(context, R.layout.custom_radiobutton, this)
            radioGroup = RadioGroup(context)
            for (choice in choices) {
                addRadioButton(choice.choiceText)
            }
            addView(radioGroup)
        } else {
            View.inflate(context, R.layout.custom_checkedbox, this)
            for (choice in choices) {
                addCheckedBox(choice.choiceText)
            }
        }
    }

    //Set Answered Color Correct or Wrong
    fun setAnsColor(choicesList: ArrayList<QuestionModal>) {
        try {
            val checkedRadioButtonId = radioGroup!!.getCheckedRadioButtonId()
            if (checkedRadioButtonId != 0) {
                radioButton = findViewById(radioGroup!!.checkedRadioButtonId) as Arivista_RadioButton
                if (radioButton!!.isChecked) {
                    if (choicesList.get(checkedRadioButtonId - 1).isC_ans_w_ans)
                        radioButton!!.setColor(Arivista_RadioButton.radioProperties.RADIO_BUTTON_CORRECT_COLOR)
                    else
                        radioButton!!.setColor(Arivista_RadioButton.radioProperties.RADIO_BUTTON_WRONG_COLOR)
                }
                radioGropList()
            } else {
                Toast.makeText(context, "Please to select answer", Toast.LENGTH_LONG).show()
            }
        } catch (e: Exception) {
            Toast.makeText(context, "Please to select answer", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    //Reset colors in radio buttons
    fun radioGropList() {
        for (i in 0 until radioGroup!!.childCount) {
            val b: Arivista_RadioButton = radioGroup!!.getChildAt(i) as Arivista_RadioButton
            if (!b.isChecked) {
                b.setColor(Arivista_RadioButton.radioProperties.RADIO_BUTTON_DEFAULT_COLOR)
                b.isEnabled = false
            }
        }
    }

    //Clear Radio Checked
    fun radioClearChecked() {
        for (i in 0 until radioGroup!!.childCount) {
            val b: Arivista_RadioButton = radioGroup!!.getChildAt(i) as Arivista_RadioButton
            b.setColor(Arivista_RadioButton.radioProperties.RADIO_BUTTON_DEFAULT_COLOR)
            b.isChecked = false
            b.isEnabled = true
        }
    }

    //Reveal Answer
    fun answerReveal(choicesList: ArrayList<QuestionModal>) {
        for (i in 0 until radioGroup!!.childCount) {
            val b: Arivista_RadioButton = radioGroup!!.getChildAt(i) as Arivista_RadioButton
            if (choicesList.get(i).isC_ans_w_ans) {
                b.isChecked = true
                b.setColor(Arivista_RadioButton.radioProperties.RADIO_BUTTON_CORRECT_COLOR)
            } else {
                b.setColor(Arivista_RadioButton.radioProperties.RADIO_BUTTON_DEFAULT_COLOR)
                b.isChecked = false
                b.isEnabled = false
            }

        }
    }
}