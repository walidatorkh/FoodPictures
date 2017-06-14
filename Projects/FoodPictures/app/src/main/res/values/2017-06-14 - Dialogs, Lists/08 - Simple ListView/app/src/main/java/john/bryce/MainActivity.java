package john.bryce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listViewAnimals;
    private ArrayList<String> animals = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewAnimals = (ListView)findViewById(R.id.listViewAnimals);

        animals.add("Dog");
        animals.add("Cat");
        animals.add("Bunny");
        animals.add("Duckling");
        animals.add("Wolf");
        animals.add("Lion");
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Bunny");
        animals.add("Duckling");
        
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, animals);
        // android.R.layout.simple_list_item_1 => build in layout for displaying simple list.

        listViewAnimals.setOnItemClickListener(this);

        listViewAnimals.setAdapter(arrayAdapter);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, animals.get(i), Toast.LENGTH_SHORT).show();
    }
}
