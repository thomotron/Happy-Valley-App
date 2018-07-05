package thetachanka.club.happyvalleyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    String words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setTitle("Timetable 2018");
        setContentView(R.layout.activity_main);

        String url = "http://thetachanka.club:5000";
        WebView view = findViewById(R.id.web_view);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);
    }

}
