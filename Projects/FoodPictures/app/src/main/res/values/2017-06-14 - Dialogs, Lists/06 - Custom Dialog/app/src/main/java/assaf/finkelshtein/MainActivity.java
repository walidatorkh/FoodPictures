package assaf.finkelshtein;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Dialog dialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // User clicks the Select Gender button:
    public void buttonSelectGender_onClick(View view) {

        // Create the dialog:
        dialog = new Dialog(this);

        // Remove its header area:
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // Must be before setContentView.

        // Set its layout:
        dialog.setContentView(R.layout.gender_dialog);

        // Prevent closing the dialog by clicking outside of it or by clicking the back button:
        dialog.setCancelable(false);

        // Set dialog buttons click listener:
        Button buttonOK = (Button)dialog.findViewById(R.id.buttonOK);
        Button buttonCancel = (Button)dialog.findViewById(R.id.buttonCancel);
        buttonOK.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);

        // Show the dialog:
        dialog.show();
    }

    public void onClick(View v) {

        if(v.getId() == R.id.buttonOK) {

            RadioButton radioButtonMale = (RadioButton)dialog.findViewById(R.id.radioButtonMale);
            RadioButton radioButtonFemale = (RadioButton)dialog.findViewById(R.id.radioButtonFemale);

            if(radioButtonMale.isChecked()) {
                Toast.makeText(this, "Gender Selected: Male", Toast.LENGTH_LONG).show();
            }
            else if(radioButtonFemale.isChecked()) {
                Toast.makeText(this, "Gender Selected: Female", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(this, "Gender Selected: None", Toast.LENGTH_LONG).show();
            }
        }

        // Must dismiss the dialog in order for it to close on OK and on Cancel:
        dialog.dismiss();
    }
}