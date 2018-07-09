package thetachanka.club.happyvalleyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.goodiebag.pinview.Pinview;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Happy Valley Youth Group 2018");
        setContentView(R.layout.login_page);
        Pinview pinview = findViewById(R.id.pin);
        pinview.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean b) {
                if (pinview.getValue().equals("1234")) {
                    findViewById(R.id.incorrect_password).setVisibility(View.INVISIBLE);
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } else {
                    findViewById(R.id.incorrect_password).setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
