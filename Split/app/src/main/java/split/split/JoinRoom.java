package split.split;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class JoinRoom extends AppCompatActivity {

    private final String API_URL = "localhost:8004/join_room";
    private RequestQueue reqQueue;

    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_room);

        // Retrieve localplayername from CreateJoinRoom.java
        String localPlayerName = getIntent().getStringExtra("localname");
        TextView t = (TextView)findViewById(R.id.LocalNameText);
        t.setText(localPlayerName);
        reqQueue = Volley.newRequestQueue(getApplicationContext());
    }

    private void enterRoom(){
        JSONObject requestParams = new JSONObject();
        try{
            requestParams.put("userId", "test");
            requestParams.put("roomName", "abc");
            requestParams.put("userName", getIntent().getStringExtra("localname"));
            requestParams.put("roomId", ((EditText)findViewById(R.id.joinRoomId)).getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, API_URL, requestParams,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast toast = Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        reqQueue.add(req);
    }
 }