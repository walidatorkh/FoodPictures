package assaf.finkelshtein;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Downloader.DownloaderCallbacks, DialogInterface.OnClickListener {

    private ProgressDialog progressDialog;
    private Downloader downloader;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonDownload_onClick(View view) {

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Downloading...");
        progressDialog.setMessage("Please Wait...");
        progressDialog.setIcon(R.drawable.downloading);
        progressDialog.setCancelable(false);

        progressDialog.setButton(Dialog.BUTTON_NEGATIVE, "Cancel", this); // Positive and Neutral buttons can also be created (but most of the time it doesn't have any sense).

        progressDialog.show();

        // Start some operation in a different thread (otherwise the dialog won't be shown):
        downloader = new Downloader(this);
        Thread thread = new Thread(downloader);
        thread.start();
    }

    // On completion - close the dialog:
    public void downloadComplete() {
        progressDialog.dismiss();
        // Note: this method runs in a different thread, thus it can't touch the UI.
    }

    // On completion - close the dialog:
    public void downloadCanceled() {
        // progressDialog.dismiss();
        // Note: this method runs in a different thread, thus it can't touch the UI.
    }

    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case Dialog.BUTTON_NEGATIVE:
                downloader.cancelDownload();
                break;
        }
    }
}
