package split.split;

import android.Manifest;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class CreateRoom extends AppCompatActivity {
    private final String API_URL = "http://10.11.73.128:8004/create_room";
    private RequestQueue reqQueue;
    private String roomNumber;
    private JSONArray roomMembers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_room);

        // Retrieve localplayername from CreateJoinRoom.java
        final String localPlayerName = getIntent().getStringExtra("localname");
        TextView t = (TextView)findViewById(R.id.LocalNameText);
        t.setText(localPlayerName);

        reqQueue = Volley.newRequestQueue(getApplicationContext());

        Button joinButton = (Button)findViewById(R.id.readyButton);//obtained from ifconfig
        joinButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {

                        Intent intent = new Intent(view.getContext(), ReadyPage.class);
                        // Changes value for local player name
                        intent.putExtra("localName", localPlayerName);
                        startActivity(intent);
                    }
                }
        );

        openRoom();
    }

    private void openRoom(){
        JSONObject requestParams = new JSONObject();
        try {
            requestParams.put("userName", getIntent().getStringExtra("localname"));
            requestParams.put("userId", "test");
            requestParams.put("roomName", "abc");
            requestParams.put("roomId", ((TextView)findViewById(R.id.createRoomId)).getText().toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(),requestParams.toString(),Toast.LENGTH_LONG).show();

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, API_URL, requestParams,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        TextView createRoomId = (TextView) findViewById(R.id.createRoomId);
                        try {
                            createRoomId.setText(""+response.get("roomId"));
                            roomNumber = response.getJSONObject("value").getString("roomId");

                            try {
                                Toast.makeText(getApplicationContext(),response.getJSONObject("value").getJSONArray("members").toString(),Toast.LENGTH_LONG).show();
                                roomMembers=response.getJSONObject("value").getJSONArray("members");
                            } catch (JSONException e) {
                                Toast.makeText(getApplicationContext(),e.getStackTrace().toString(),Toast.LENGTH_LONG).show();
                                e.printStackTrace();
                            }
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(),e.getStackTrace().toString(),Toast.LENGTH_LONG);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(getApplicationContext(),"YIIIS",Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),volleyError.toString(),Toast.LENGTH_LONG).show();
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
                headers.put("User-agent", "My useragent");
                return headers;
            }
        };
        reqQueue.add(req);

    }
}
