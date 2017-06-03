package split.split;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class CreateJoinRoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_join_room);

        Button createRoom = (Button)findViewById(R.id.CreateButton);
        Button joinRoom = (Button)findViewById(R.id.JoinButton);
        final EditText nameInput = (EditText)findViewById(R.id.editText);

        // Switch to Create Room screen when button is clicked
        createRoom.setOnClickListener(
            new View.OnClickListener() {
                public void onClick(View view) {
                    // Changes value for local player name
                    /*Intent intent = new Intent(view.getContext(), CreateRoom.class);
                    intent.putExtra("localname", nameInput.getText().toString())
                    startActivityForResult(intent, 0); */
                }
            }
        );

        // Switch to Join Room screen when button is clicked
        joinRoom.setOnClickListener(
            new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), JoinRoom.class);
                    // Passes value for local player name
                    intent.putExtra("localname", nameInput.getText().toString());
                    startActivityForResult(intent, 0);
                }
            }
        );
    }
}
