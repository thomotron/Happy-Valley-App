package thetachanka.club.happyvalleyapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MainActivity extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setTitle("Timetable 2018");
        setContentView(R.layout.activity_main);
        readHTML();
    }

    /**
     * Executes the ConnectToWebpage onPostExecute method to read text from the webpage
     */
    public void readHTML() {
        new ConnectToWebpage().execute();
    }

    public class ConnectToWebpage extends AsyncTask<Void, Void, Void> {
        String words;

        /**
         * Reads the text from http://thetachanka.club:5000
         * @param params
         * @return null
         */
        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document doc = Jsoup.connect("http://thetachanka.club:5000").get();
                words = doc.text();
            } catch (Exception e) {text.setText("unable to connect");}
            return null;
        }

        /**
         * Sets the text of the TextView to the webpages text
         * @param aVoid
         */
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            text.setText(words);
        }
    }
}
