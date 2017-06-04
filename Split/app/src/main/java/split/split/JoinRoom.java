package split.split;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JoinRoom extends AppCompatActivity {

    private final String API_URL = "http://10.11.73.128:8004/join_room";
    private RequestQueue reqQueue;
    private JSONArray roomMembers;
    private String roomNumber;

    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_room);

        // Retrieve localplayername from CreateJoinRoom.java
        final String localPlayerName = getIntent().getStringExtra("localname");
        TextView t = (TextView)findViewById(R.id.LocalNameText);
        t.setText(localPlayerName);


        reqQueue = Volley.newRequestQueue(getApplicationContext());

        Button joinButton = (Button)findViewById(R.id.readyButton);

        joinButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {

                        enterRoom();

                        Intent intent = new Intent(view.getContext(), ReadyPage.class);
                        // Changes value for local player name
                        intent.putExtra("localName", localPlayerName);
                        startActivity(intent);
                    }
                }
        );


    }

    private void enterRoom(){
        JSONObject requestParams = new JSONObject();
        try{
            requestParams.put("userName", getIntent().getStringExtra("localname"));
            requestParams.put("roomId", ((EditText)findViewById(R.id.joinRoomId)).getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, API_URL, requestParams,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response){
                            System.out.println(response.toString());
                        try {
                            roomNumber = response.getJSONObject("value").getString("roomId");
                            Toast.makeText(getApplicationContext(),response.getJSONObject("value").getJSONArray("members").toString(),Toast.LENGTH_LONG).show();
                            roomMembers=response.getJSONObject("value").getJSONArray("members");
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(),e.getStackTrace().toString(),Toast.LENGTH_LONG).show();
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<>();
                params.put("userName", getIntent().getStringExtra("localname"));
                params.put("userId", "test");
                params.put("roomName", "abc");
                params.put("roomId", ((TextView)findViewById(R.id.createRoomId)).getText().toString());
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type","application/x-www-form-urlencoded");
                headers.put("charset","utf-8");
                headers.put("User-agent", "My useragent");
                return headers;
            }
        };
        reqQueue.add(req);
    }



 }