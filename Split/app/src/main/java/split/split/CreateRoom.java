package split.split;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class CreateRoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_room);

        // Retrieve localplayername from CreateJoinRoom.java
        final String localPlayerName = getIntent().getStringExtra("localname");
        TextView t = (TextView)findViewById(R.id.LocalNameText);
        t.setText(localPlayerName);

        Button joinButton = (Button)findViewById(R.id.button);

        joinButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), ReadyPage.class);
                        // Changes value for local player name
                        intent.putExtra("localname", localPlayerName);
                        startActivityForResult(intent, 0);
                    }
                }
        );

    }
}
