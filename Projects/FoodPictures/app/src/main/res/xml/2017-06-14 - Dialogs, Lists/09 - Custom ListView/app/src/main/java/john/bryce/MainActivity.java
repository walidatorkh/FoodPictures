package john.bryce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewFood;
    private ArrayList<Food> food = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewFood = (ListView)findViewById(R.id.listViewFood);

        food.add(new Food("Bread", R.drawable.bread));
        food.add(new Food("Cheese", R.drawable.cheese));
        food.add(new Food("Ice Cream", R.drawable.icecream));
        food.add(new Food("Pizza", R.drawable.pizza));
        food.add(new Food("Sushi", R.drawable.sushi));

        FoodAdapter foodAdapter = new FoodAdapter(this, food);

        listViewFood.setAdapter(foodAdapter);

    }
}
