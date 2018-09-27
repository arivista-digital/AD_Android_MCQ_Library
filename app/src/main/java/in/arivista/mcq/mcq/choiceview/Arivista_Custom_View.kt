package `in`.arivista.mcq.mcq.choiceview


import `in`.arivista.mcq.mcq.*
import `in`.arivista.mcq.mcq.utils.ChoiceType
import `in`.arivista.mcq.mcq.model.ChoiceModel
import `in`.arivista.mcq.mcq.utils.RadioButtonProperties
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.RadioGroup


open class Arivista_Custom_View : LinearLayout {

    var radioButton: Arivista_RadioButton? = null
    var radioGroup: RadioGroup? = null
    var submitBtn: Button? = null
    var revealBtn: Button? = null
    var clearBtn: Button? = null
    var linearLayout:LinearLayout?=null

    var choicesList = ArrayList<ChoiceModel>()

    var radioProperties = RadioButtonProperties()

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
        View.inflate(context, R.layout.custom_radiobutton, this)
    }

    //Add TextView
    fun addTextView(quetion: String) {

        View.inflate(context, R.layout.text_view_layout, this)
        orientation = VERTICAL

        val textView = TextView(context)
        textView.textSize=20f
        textView.setTextColor(Color.BLACK)
        textView.setText(quetion)

        addView(textView)
    }

    //Add radio Buttons and checkboxes
    fun setChoiceType(choices: ArrayList<ChoiceModel>, choiceType: ChoiceType) {
        choicesList = choices
        if (choiceType == ChoiceType.SINGLE) {

            radioGroup = RadioGroup(context)

            for (choice in choices) {
                addRadioButton(choice.choiceText)
            }
            addView(radioGroup)
            addFormControlButtons()
        }
    }

    //Add Radio Buttons
    fun addRadioButton(choice: String) {
        radioButton = Arivista_RadioButton(context)
        radioButton!!.setText(choice)
        radioGroup?.addView(radioButton)

        //Radio Button Change Listener
        radioButton!!.setOnCheckedChangeListener() { compoundButton: CompoundButton, b: Boolean ->
            if (b) {

                submitButtonVisibility(submitBtn!!, true)
                clearButtonVisibility(clearBtn!!, true)
            }
        }

    }

    //Add submit clear reveal Button
    fun addFormControlButtons(){
        linearLayout = LinearLayout(context)
        linearLayout!!.orientation = HORIZONTAL

        submitBtn = Button(context)
        submitBtn!!.text = "Submit"
        submitBtn!!.width=ViewGroup.LayoutParams.WRAP_CONTENT
        submitBtn!!.height=ViewGroup.LayoutParams.WRAP_CONTENT
        submitButtonVisibility(submitBtn!!,false)


        clearBtn = Button(context)
        clearBtn!!.text = "Clear"
        clearBtn!!.width=ViewGroup.LayoutParams.WRAP_CONTENT
        clearBtn!!.height=ViewGroup.LayoutParams.WRAP_CONTENT
        clearButtonVisibility(clearBtn!!,false)

        revealBtn = Button(context)
        revealBtn!!.text = "Reveal"
        revealBtn!!.width=ViewGroup.LayoutParams.WRAP_CONTENT
        revealBtn!!.height=ViewGroup.LayoutParams.WRAP_CONTENT
        revealButtonVisibility(revealBtn!!,false)


        linearLayout!!.addView(submitBtn)
        linearLayout!!.addView(clearBtn)
        linearLayout!!.addView(revealBtn)

        addView(linearLayout)

        //Answer Submit listener
        submitBtn!!.setOnClickListener() {

            setSumbitAnswer(choicesList)
            submitButtonVisibility(submitBtn!!, false)
            revealButtonVisibility(revealBtn!!, true)
        }
        //Clear Checked Radio Buttons
        clearBtn!!.setOnClickListener() {

            revealButtonVisibility(revealBtn!!, false)
            submitButtonVisibility(submitBtn!!, false)
            clearButtonVisibility(clearBtn!!, false)
            radioClearChecked()

        }
        //Reveal Answers
        revealBtn!!.setOnClickListener() {

            answerReveal(choicesList)
            submitButtonVisibility(submitBtn!!, false)
            clearButtonVisibility(clearBtn!!, true)
            revealButtonVisibility(revealBtn!!, false)
        }
    }

    //Set question Titls
    fun setQuestion(quetion: String) {
        addTextView(quetion)
    }

    //Set Answered Color Correct or Wrong
    fun setSumbitAnswer(choicesList: ArrayList<ChoiceModel>) {

        try {

            val checkedRadioButtonId = radioGroup!!.getCheckedRadioButtonId()

            if (checkedRadioButtonId != 0) {

                radioButton = findViewById(radioGroup!!.checkedRadioButtonId) as Arivista_RadioButton
                if (radioButton!!.isChecked) {

                    if (choicesList.get(checkedRadioButtonId - 1).isC_ans_w_ans)
                        radioButton!!.setColor(radioProperties.RADIO_BUTTON_CORRECT_COLOR)
                    else
                        radioButton!!.setColor(radioProperties.RADIO_BUTTON_WRONG_COLOR)
                    radioGroupList()
                } else {

                    Toast.makeText(context, "Please to select answer", Toast.LENGTH_LONG).show()
                }
            } else {

                Toast.makeText(context, "Please to select answer", Toast.LENGTH_LONG).show()
            }
        } catch (e: Exception) {

            Toast.makeText(context, "Please to select answer", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    //Reset colors in radio buttons
    fun radioGroupList() {

        for (i in 0 until radioGroup!!.childCount) {

            val b = radioGroup!!.getChildAt(i) as Arivista_RadioButton
            if (!b.isChecked) {
                b.setColor(radioProperties.RADIO_BUTTON_DEFAULT_COLOR)
                b.isEnabled = false
            }
        }
    }

    //Clear Radio Checked
    fun radioClearChecked() {

        for (i in 0 until radioGroup!!.childCount) {
            val b = radioGroup!!.getChildAt(i) as Arivista_RadioButton
            b.setColor(radioProperties.RADIO_BUTTON_DEFAULT_COLOR)
            b.isEnabled = true
        }
        radioGroup!!.clearCheck()
    }

    //Reveal Answer
    fun answerReveal(choicesList: ArrayList<ChoiceModel>) {

        for (i in 0 until radioGroup!!.childCount) {

            val b = radioGroup!!.getChildAt(i) as Arivista_RadioButton

            if (choicesList.get(i).isC_ans_w_ans) {

                b.isChecked = true
                b.setColor(radioProperties.RADIO_BUTTON_CORRECT_COLOR)
            } else {

                b.setColor(radioProperties.RADIO_BUTTON_DEFAULT_COLOR)
                b.isChecked = false
                b.isEnabled = false
            }
        }
    }

    //Submit button controls
    fun submitButtonVisibility(submit: Button, visibility: Boolean) {

        submit.isEnabled = visibility
    }

    //Clear button controls
    fun clearButtonVisibility(clear: Button, visibility: Boolean) {

        clear.isEnabled = visibility
    }

    //Reveal button controls
    fun revealButtonVisibility(reveal: Button, visibility: Boolean) {

        reveal.isEnabled = visibility
    }
}