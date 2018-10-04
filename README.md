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
<arivista.lib.mcq.choiceview.ArivistaChoiceView
        android:id="@+id/arivista_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```
* MainActivity Funtionalites
* Add the questions
### Single Choice Questions ###
```
 val choicesSingle = ArrayList<ChoiceModel>()
        choicesSingle.add(ChoiceModel(1, "Option 1", false))
        choicesSingle.add(ChoiceModel(2, "Option 2", false))
        choicesSingle.add(ChoiceModel(3, "Option 3", false))
        choicesSingle.add(ChoiceModel(4, "Option 4", true))
        choicesSingle.add(ChoiceModel(5, "Option 5", false))
```
### Mutiple Choice Questions ###

```
 val choicesMulti = ArrayList<ChoiceModel>()
        choicesMulti.add(ChoiceModel(1, "Option 1", true))
        choicesMulti.add(ChoiceModel(2, "Option 2", true))
        choicesMulti.add(ChoiceModel(3, "Option 3", false))
        choicesMulti.add(ChoiceModel(4, "Option 4", false))
        choicesMulti.add(ChoiceModel(5, "Option 5", false))
```

* Custom view object creation
```
      val arivistaview = findViewById<ArivistaChoiceView>(R.id.arivista_view)
```

* Set Qusetion just call the fuctions on custom view 

```
        arivistaview.setQuestion("Single choice question?");
        arivistaview.setChoiceType(choicesSingle, ChoiceType.SINGLE)

        arivistaview.setQuestion("Multi choice question?")
        arivistaview.setChoiceType(choicesMulti, ChoiceType.MULTIPLE)
```

### Screenshots ###

 ![Alt text](/app/screenshots/mcq.gif)

### Links ###
* [Arivista Digital Pvt Ltd](https://www.arivistadigital.org/ "Arivista")

### License ###

* Copyright 2018 The Android Open Source Project, Inc.
* Arivista Digital Pvt Ltd
