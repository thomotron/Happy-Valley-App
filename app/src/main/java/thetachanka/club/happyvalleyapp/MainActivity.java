package thetachanka.club.happyvalleyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Timetable 2018");
        setContentView(R.layout.activity_main);

        String url = "http://thetachanka.club:5000";
        WebView webview = findViewById(R.id.web_view);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(url);
    }

}
