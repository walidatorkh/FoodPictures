package assaf.finkelshtein;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // User clicks the button:
    public void buttonSelectDate_onClick(View view) {

        // Take calendar instance:
        Calendar calendar = Calendar.getInstance();

        // Take current year, month and day:
        int year = calendar.get(Calendar.YEAR);
        int monthOfYear = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        // Create date dialog:
        DatePickerDialog dialog = new DatePickerDialog(this, this, year, monthOfYear, dayOfMonth);

        // Prevent closing the dialog by clicking outside of it or by clicking the back button:
        dialog.setCancelable(false);

        // Show the dialog:
        dialog.show();
    }

    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        String message = String.format("Date Selected: %02d/%02d/%04d", dayOfMonth, monthOfYear + 1, year);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

