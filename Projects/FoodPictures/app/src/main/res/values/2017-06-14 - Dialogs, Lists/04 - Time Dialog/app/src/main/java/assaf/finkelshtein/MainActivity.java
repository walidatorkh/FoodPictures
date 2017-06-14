package assaf.finkelshtein;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // User clicks the button:
    public void buttonSelectTime_onClick(View view) {

        // Take calendar instance:
        Calendar calendar = Calendar.getInstance();

        // Take current time:
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Create time dialog:
        TimePickerDialog dialog = new TimePickerDialog(this, this , hourOfDay, minute, true); // true = 24 hour format.

        // Prevent closing the dialog by clicking outside of it or by clicking the back button:
        dialog.setCancelable(false);

        // Show the dialog:
        dialog.show();
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String message = String.format("Time Selected: %02d:%02d:00", hourOfDay, minute);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}