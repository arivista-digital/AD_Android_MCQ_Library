### MCQ - Multiple Choice Questions Generate ###

* Language - Android Kotlin
* IDE - Android Studio 3.1

### What is this repository for? ###

* This is Customized MCQ 
* Values pass to arrayList question will generate automatically

### Use Customized Component ###

* RadioButton

### Solutions ###

* Single Answer Selection
* Correct and Wrong answers differentiate by color
* Submit Answer
* Clear Selection
* Reveal Answer

### How to use ###
 ```
 * activity_main Layout initialize
```
<in.arivista.mcq.mcq.Arivista_Custom_View
        android:id="@+id/arivista_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```
* MainActivity Funtionalites

``` Add the questions
val choicesList = ArrayList<QuestionModal>()
        choicesList.add(QuestionModal(1, "Option 1", true))
        choicesList.add(QuestionModal(2, "Option 2", false))
        choicesList.add(QuestionModal(3, "Option 3", false))
        choicesList.add(QuestionModal(4, "Option 4", false))
```
```Custom view object creation
      val arivista_view = findViewById(R.id.arivista_view) as Arivista_Custom_View
```
```Set Qusetion just call the fuctions on custom view 
  arivista_view.setQuestion("how to implement Radio Buttons?");
  arivista_view.setChoiceType(choicesList, ChoiceType.SINGLE)
```
### License ###

* Copyright 2018 The Android Open Source Project, Inc.
* Arivista Digital Pvt Ltd

### Contacts ###

* Arivista Digital Pvt Ltd
* Android Team