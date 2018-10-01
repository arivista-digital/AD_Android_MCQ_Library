package `in`.arivista.mcq

import `in`.arivista.mcq.mcq.choiceview.ArivistaCustomView
import `in`.arivista.mcq.mcq.model.ChoiceModel
import `in`.arivista.mcq.mcq.utils.ChoiceType
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.R.menu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.GridView
import android.R.attr.data
import android.widget.ArrayAdapter
import `in`.arivista.mcq.MovieAdapter






class MainActivity : AppCompatActivity() {

    var mGridView: GridView? = null
    private var mAdapter: MovieAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grid)


        val choicesListques1 = ArrayList<ChoiceModel>()
        choicesListques1.add(ChoiceModel(1, "1. Friend", false))
        choicesListques1.add(ChoiceModel(2, "2. Daughter", false))
        choicesListques1.add(ChoiceModel(3, "3. Mother", false))
        choicesListques1.add(ChoiceModel(4, "4. Sister", true))
        choicesListques1.add(ChoiceModel(4, "5. Lover", false))


      //  val choicesList1 = ArrayList<ChoiceModel>()
     //   choicesList1.add(ChoiceModel(1, "1. Idily", true))
     //   choicesList1.add(ChoiceModel(2, "2. Pongal", true))
     //   choicesList1.add(ChoiceModel(3, "3. Chicken", false))
     //   choicesList1.add(ChoiceModel(4, "4. Meat", false))

        mGridView = findViewById(R.id.container) as GridView
        mAdapter=MovieAdapter(this,choicesListques1)
        mGridView!!.adapter=mAdapter
        mAdapter!!.notifyDataSetInvalidated()


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    @Override
  override fun onOptionsItemSelected(item:MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        var id = item.getItemId()

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_adjust_1) {
            adjustGridView(1);
            return true;
        }else if(id == R.id.action_adjust_2){
            adjustGridView(2);
            return true;
        }else if(id == R.id.action_adjust_3){
            adjustGridView(3);
            return true;
        }else if(id == R.id.action_adjust_4){
            adjustGridView(4);
            return true;
        }else if(id == R.id.action_adjust_5){
            adjustGridView(5);
            return true;
        }else if(id == R.id.action_adjust_6){
            adjustGridView(6);
            return true;
        }else if(id == R.id.action_adjust_7){
            adjustGridView(7);
            return true;
        }else if(id == R.id.action_adjust_8){
            adjustGridView(8);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    fun adjustGridView(numColumns:Int) {
        mGridView!!.setNumColumns(numColumns);
    }
}
