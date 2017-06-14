package john.bryce;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    private LinearLayout linearLayoutMain;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayoutMain = (LinearLayout)findViewById(R.id.linearLayoutMain);
    }

    public void buttonChangeColor_onClick(View view) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Change Color")
                .setMessage("to random color?")
                .setIcon(R.drawable.colors)
                .setCancelable(false)
                .setPositiveButton("Yes", this)
                .setNegativeButton("No", this)
                .create();

        dialog.show();
    }

    public void onClick(DialogInterface dialogInterface, int which) {
        if(which == Dialog.BUTTON_POSITIVE) {
            linearLayoutMain.setBackgroundColor(getRandomColor());
        }
    }

    private int getRandomColor() {
        int red = (int)(Math.random() * 256);
        int green = (int)(Math.random() * 256);
        int blue = (int)(Math.random() * 256);
        int color = Color.rgb(red, green, blue);
        return color;
    }
}
