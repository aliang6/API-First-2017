package split.split;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.os.Handler;

public class ReadyPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready_page);

        // Retrieve localPlayerName from CreateRoom.java or JoinRoom.java
        String localPlayerName = getIntent().getStringExtra("localName");
        TextView t = (TextView)findViewById(R.id.localname);
        t.setText(localPlayerName);

        TextView readyText = (TextView)findViewById(R.id.readyText);


        Button readyButton = (Button)findViewById(R.id.readyButton);

        readyButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        // Change ready text to green
                        readyButton.setTextColor(0xff99cc);
                        // 3 second delay
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                /*Intent intent = new Intent(view.getContext(), ReadyPage.class);
                                // Changes value for local player name
                                intent.putExtra("localName", localPlayerName);
                                startActivity(intent);*/
                                
                            }
                        }, 3000);
                    }
                }
        );
    }
}
