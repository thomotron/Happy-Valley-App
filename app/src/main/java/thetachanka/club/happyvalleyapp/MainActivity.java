package thetachanka.club.happyvalleyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Timetable 2018");
        setContentView(R.layout.activity_main);

        String timetable_url = "http://thetachanka.club:5000/timetable/";
        String images_url = "http://thetachanka.club:5000/images/";
        String event_url = "http://thetachanka.club:5000/next-event/";

        WebView webTimetable = findViewById(R.id.web_timetable);
        webTimetable.getSettings().setJavaScriptEnabled(true);
        webTimetable.loadUrl(timetable_url);

        WebView webImages = findViewById(R.id.web_images);
        webImages.getSettings().setJavaScriptEnabled(true);
        webImages.loadUrl(images_url);

        WebView webEvent = findViewById(R.id.web_event);
        webEvent.getSettings().setJavaScriptEnabled(true);
        webEvent.loadUrl(event_url);

        Button timetableButton = findViewById(R.id.timetable_button);
        timetableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.web_timetable).setVisibility(View.VISIBLE);
                findViewById(R.id.web_images).setVisibility(View.INVISIBLE);
                findViewById(R.id.web_event).setVisibility(View.INVISIBLE);
            }
        });

        Button imagesButton = findViewById(R.id.images_button);
        imagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.web_timetable).setVisibility(View.INVISIBLE);
                findViewById(R.id.web_images).setVisibility(View.VISIBLE);
                findViewById(R.id.web_event).setVisibility(View.INVISIBLE);
            }
        });

        Button nextEventButton = findViewById(R.id.next_event_button);
        nextEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.web_timetable).setVisibility(View.INVISIBLE);
                findViewById(R.id.web_images).setVisibility(View.INVISIBLE);
                findViewById(R.id.web_event).setVisibility(View.VISIBLE);
            }
        });
    }

}
