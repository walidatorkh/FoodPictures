package john.bryce;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonShowDialog_onClick(View view) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("Delete this Contact?")
                .setTitle("Confirm Delete")
                .setIcon(R.drawable.delete)
                .setPositiveButton("Yes", this)
                .setNegativeButton("No", this)
                .setNeutralButton("Cancel", this)
                .setCancelable(false)
                .create();

        dialog.show();
    }

    public void onClick(DialogInterface dialogInterface, int which) {
        switch (which) {
            case Dialog.BUTTON_POSITIVE:
                Toast.makeText(this, "You clicked Yes!", Toast.LENGTH_SHORT).show();
                break;
            case Dialog.BUTTON_NEGATIVE:
                Toast.makeText(this, "You clicked No!", Toast.LENGTH_SHORT).show();
                break;
            case Dialog.BUTTON_NEUTRAL:
                Toast.makeText(this, "You Canceled the Dialog!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
