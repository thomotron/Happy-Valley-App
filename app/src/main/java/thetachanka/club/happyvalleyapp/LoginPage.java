package thetachanka.club.happyvalleyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
    }

    public void login(View v) {
        EditText passField = findViewById(R.id.password_field);
        String passText = passField.getText().toString();
        if (passText.equals("hvyg18")) {
            findViewById(R.id.incorrect_password).setVisibility(View.INVISIBLE);
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        } else {
            findViewById(R.id.incorrect_password).setVisibility(View.VISIBLE);
        }
    }
}
