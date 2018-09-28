package `in`.arivista.mcq.mcq.choiceview


import `in`.arivista.mcq.mcq.*
import `in`.arivista.mcq.mcq.utils.ChoiceType
import `in`.arivista.mcq.mcq.model.ChoiceModel
import `in`.arivista.mcq.mcq.utils.RadioButtonProperties
import android.content.Context
import android.graphics.Color
import android.support.v7.widget.AppCompatCheckBox
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.RadioGroup
import android.widget.CheckBox


open class Arivista_Custom_View : LinearLayout {

    var radioButton: Arivista_RadioButton? = null
    var checkBox: AppCompatCheckBox? = null
    var radioGroup: RadioGroup? = null

    var submitBtn: Button? = null
    var revealBtn: Button? = null
    var clearBtn: Button? = null

    var linearLayout: LinearLayout? = null

    var submitBtn1: Button? = null
    var revealBtn1: Button? = null
    var clearBtn1: Button? = null

    var linearLayout1: LinearLayout? = null

    var choicesList = ArrayList<ChoiceModel>()

    var items = ArrayList<CheckBox>()

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

    }

    //Add TextView
    fun addTextView(quetion: String) {

        View.inflate(context, R.layout.text_view_layout, this)
        orientation = VERTICAL

        val textView = TextView(context)
        textView.textSize = 20f
        textView.setTextColor(Color.BLACK)
        textView.setText(quetion)

        addView(textView)
    }

    //Add radio Buttons and checkboxes
    fun setChoiceType(choices: ArrayList<ChoiceModel>, choiceType: ChoiceType) {
        choicesList = choices
        if (choiceType == ChoiceType.SINGLE) {
            View.inflate(context, R.layout.custom_radiobutton, this)
            radioGroup = RadioGroup(context)

            for (choice in choices) {
                addRadioButton(choice.choiceText)
            }
            addView(radioGroup)
            addFormControlButtons()
        } else {
            View.inflate(context, R.layout.custom_checkbox, this)
            for (choice in choices) {
                addCheckedButton(choice.choiceText)
            }
            addFormControlButtons1()
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

    //Add Radio Buttons
    fun addCheckedButton(choice: String) {
        checkBox = AppCompatCheckBox(context)
        checkBox!!.setText(choice)
        addView(checkBox)
        items.add(checkBox!!)

        //Radio Button Change Listener
        checkBox!!.setOnCheckedChangeListener() { compoundButton: CompoundButton, b: Boolean ->
            if (b) {

                submitButtonVisibility(submitBtn1!!, true)
                clearButtonVisibility(clearBtn1!!, true)
            }
        }

    }

    //Add submit clear reveal Button
    fun addFormControlButtons() {
        linearLayout = LinearLayout(context)
        linearLayout!!.orientation = HORIZONTAL

        submitBtn = Button(context)
        submitBtn!!.text = "Submit"
        submitBtn!!.width = ViewGroup.LayoutParams.WRAP_CONTENT
        submitBtn!!.height = ViewGroup.LayoutParams.WRAP_CONTENT
        submitButtonVisibility(submitBtn!!, false)


        clearBtn = Button(context)
        clearBtn!!.text = "Clear"
        clearBtn!!.width = ViewGroup.LayoutParams.WRAP_CONTENT
        clearBtn!!.height = ViewGroup.LayoutParams.WRAP_CONTENT
        clearButtonVisibility(clearBtn!!, false)

        revealBtn = Button(context)
        revealBtn!!.text = "Reveal"
        revealBtn!!.width = ViewGroup.LayoutParams.WRAP_CONTENT
        revealBtn!!.height = ViewGroup.LayoutParams.WRAP_CONTENT
        revealButtonVisibility(revealBtn!!, false)


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


    //Add submit clear reveal Button
    fun addFormControlButtons1() {
        linearLayout1 = LinearLayout(context)
        linearLayout!!.orientation = HORIZONTAL

        submitBtn1 = Button(context)
        submitBtn1!!.text = "Submit"
        submitBtn1!!.width = ViewGroup.LayoutParams.WRAP_CONTENT
        submitBtn1!!.height = ViewGroup.LayoutParams.WRAP_CONTENT
        submitButtonVisibility(submitBtn1!!, false)


        clearBtn1 = Button(context)
        clearBtn1!!.text = "Clear"
        clearBtn1!!.width = ViewGroup.LayoutParams.WRAP_CONTENT
        clearBtn1!!.height = ViewGroup.LayoutParams.WRAP_CONTENT
        clearButtonVisibility(clearBtn1!!, false)

        revealBtn1 = Button(context)
        revealBtn1!!.text = "Reveal"
        revealBtn1!!.width = ViewGroup.LayoutParams.WRAP_CONTENT
        revealBtn1!!.height = ViewGroup.LayoutParams.WRAP_CONTENT
        revealButtonVisibility(revealBtn1!!, false)


        linearLayout1!!.addView(submitBtn1)
        linearLayout1!!.addView(clearBtn1)
        linearLayout1!!.addView(revealBtn1)

        addView(linearLayout1)

        //Answer Submit listener
        submitBtn1!!.setOnClickListener() {

            setSumbitAnswer1(choicesList)
            submitButtonVisibility(submitBtn1!!, false)
            revealButtonVisibility(revealBtn1!!, true)
        }
        //Clear Checked Radio Buttons
        clearBtn1!!.setOnClickListener() {

            revealButtonVisibility(revealBtn1!!, false)
            submitButtonVisibility(submitBtn1!!, false)
            clearButtonVisibility(clearBtn1!!, false)
            radioClearChecked1()

        }
        //Reveal Answers
        revealBtn1!!.setOnClickListener() {

            answerReveal1(choicesList)
            submitButtonVisibility(submitBtn1!!, false)
            clearButtonVisibility(clearBtn1!!, true)
            revealButtonVisibility(revealBtn1!!, false)
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

    //Set Answered Color Correct or Wrong
    fun setSumbitAnswer1(choicesList: ArrayList<ChoiceModel>) {
        var i = 0
        for (item in items) {
            if (choicesList.get(i).isC_ans_w_ans && item.isChecked) {
                // val text: String = item.text.toString()
                item.isClickable = false
            } else {
                item.isEnabled = false
                item.isChecked = false
            }
            i++
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

    fun radioClearChecked1() {
        for (item in items) {
            item.isEnabled = true
            item.isChecked = false
            item.isClickable = true
        }
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

    //Reveal check Box Answer
    fun answerReveal1(choicesList: ArrayList<ChoiceModel>) {
        var i = 0;
        for (item in items) {
            if (choicesList.get(i).isC_ans_w_ans) {
                item.isChecked = true
                item.isEnabled = true
                item.isClickable = false
            } else {
                item.isChecked = false
            }
            i++
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