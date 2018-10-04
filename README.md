### MCQ - Multiple Choice Questions Generate ###

* Language - Android Kotlin
* IDE - Android Studio 3.1

### What is this repository for? ###

* This is Customized MCQ 
* Handle by Single and Mutiple choice questions
* Values pass to arrayList question will generate automatically

### Use Customized Component ###

* RadioButton
* CheckBox

### Solutions ###

* Single Answer Selection
* Mutiple Answer Selection
* Correct and Wrong answers differentiate by color
* Submit Answer
* Clear Selection
* Reveal Answer

### How to use ###

 * activity_main Layout initialize
 
```
<in.arivista.mcq.mcq.Arivista_Custom_View
        android:id="@+id/arivista_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```
* MainActivity Funtionalites
* Add the questions
### Single Choice Questions ###
```
val choicesList = ArrayList<QuestionModal>()
        choicesList.add(QuestionModal(1, "Option 1", true))
        choicesList.add(QuestionModal(2, "Option 2", false))
        choicesList.add(QuestionModal(3, "Option 3", false))
        choicesList.add(QuestionModal(4, "Option 4", false))
```
### Mutiple Choice Questions ###

```
val choicesList = ArrayList<QuestionModal>()
        choicesList.add(QuestionModal(1, "Option 1", true))
        choicesList.add(QuestionModal(2, "Option 2", false))
        choicesList.add(QuestionModal(3, "Option 3", true))
        choicesList.add(QuestionModal(4, "Option 4", false))
```

* Custom view object creation
```
      val arivista_view = findViewById(R.id.arivista_view) as Arivista_Custom_View
```

* Set Qusetion just call the fuctions on custom view 

```
  arivista_view.setQuestion("how to implement Radio Buttons?");
  arivista_view.setChoiceType(choicesList, ChoiceType.SINGLE)
```

### Screenshots ###

 ![Scheme](https://bitbucket.org/sureshseeniss/mcq/src/master/app/screenshots/mcq.gif)

### Links ###
* [Arivista Digital Pvt Ltd](https://www.arivistadigital.org/ "Arivista")

### License ###

* Copyright 2018 The Android Open Source Project, Inc.
* Arivista Digital Pvt Ltd
