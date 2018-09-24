package `in`.arivista.mcq.mcq

import android.widget.Toast

open class QustionImplementation : QuestionPresenter {


    protected var listener: QuestionListener? = null

    constructor(Listener : QuestionListener){
        listener=Listener
    }

    override fun addRadioButton() {
        TODO("Add Radio Buttons")
    }

    override fun addCheckBox() {
        TODO("Add CheckBoxes")
    }

    override fun errorFound() {
        TODO("Error Found")
    }

}
