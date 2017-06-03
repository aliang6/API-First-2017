package split.split;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReadyPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready_page);

        // Retrieve localplayername from CreateRoom.java or JoinRoom.java
        String localPlayerName = getIntent().getStringExtra("localname");
        //TextView t = (TextView)findViewById(R.id.LocalNameText);
        //t.setText(localPlayerName);


    }
}
