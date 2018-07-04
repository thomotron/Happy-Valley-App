package thetachanka.club.happyvalleyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    private Statement statement;
    private Connection con;
    private ResultSet result;
    private ResultSetMetaData rsMetaData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            con = DriverManager.getConnection("jdbc:mysql://domain-name:3306/hvyg", "caleb", "doesn't work ATM");
            statement = con.createStatement();
            result = statement.executeQuery("SELECT day, dayNo, month, activity, location, meditation FROM timetable;");
            rsMetaData = result.getMetaData();
        } catch (SQLException e) {
            unableToConnect();
        }
    }

    public void loadTimeTable() {
        TextView ttt = findViewById(R.id.timetable_text);
        try {
            ttt.setText(rsMetaData.getColumnName(1));
        } catch (SQLException e) {
            unableToConnect();
        }

    }

    public void unableToConnect() {
        TextView tv = findViewById(R.id.timetable_text);
        tv.setText("Unable to connect");
    }
}
