package split.split;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class CreateJoinRoom extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_join_room);

    }

    /**
     * Create a room - called when user creates a room
     */
    public void roomCreate(View view) {
        Intent createRoom = new Intent(this, CreateRoom.class);
        startActivity(createRoom);
    }

    /**
     * Join a room - called when user joins a room
     */
    public void roomJoin(){
        //Intent joinRoom = new Intent(this, CreateRoomActivity.class);
        //startActivity(joinRoom);
    }
}
