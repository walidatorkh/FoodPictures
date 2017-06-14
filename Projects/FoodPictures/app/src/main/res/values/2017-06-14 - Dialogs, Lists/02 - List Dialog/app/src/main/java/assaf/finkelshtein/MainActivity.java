package assaf.finkelshtein;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayoutMain;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayoutMain = (LinearLayout)findViewById(R.id.linearLayoutMain);
    }

    public void selectColor_onClick(View view) {

        String[] items = {"Red", "Green", "Blue", "Yellow", "Cyan", "Magenta"};

        final int[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA};

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        alertDialog.setIcon(R.drawable.colors);

        alertDialog.setTitle("Select Color");

        alertDialog.setCancelable(false);

        alertDialog.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                linearLayoutMain.setBackgroundColor(colors[which]);
            }
        });

        alertDialog.setNegativeButton("Cancel", null);

        alertDialog.show();
    }
}
