package assaf.finkelshtein;

public class Downloader implements Runnable {

    private DownloaderCallbacks callbacks;
    private boolean cancelRequested;

    public Downloader(DownloaderCallbacks callbacks) {
        this.callbacks = callbacks;
    }

    public void cancelDownload() {
        cancelRequested = true;
    }

    public void run() {

        for (int i = 0; i < 100; i++) {

            try {
                Thread.sleep(100);
            }
            catch (Exception e) { }

            if(cancelRequested) {
                callbacks.downloadCanceled();
                return;
            }
        }

        callbacks.downloadComplete();
    }

    public interface DownloaderCallbacks {
        void downloadComplete();
        void downloadCanceled();
    }
}
