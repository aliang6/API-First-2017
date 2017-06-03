package split.split;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JoinRoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_room);

        // Retrieve localplayername from CreateJoinRoom.java
        String localPlayerName = getIntent().getStringExtra("localname");
        TextView t = (TextView)findViewById(R.id.localNameText);
        t.setText(localPlayerName);
    }
}
