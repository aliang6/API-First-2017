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
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateRoom extends AppCompatActivity {
    private final String API_URL = "http://10.11.73.128:8004/create_room";
    private RequestQueue reqQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_room);

        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET);

        // Retrieve localplayername from CreateJoinRoom.java
        final String localPlayerName = getIntent().getStringExtra("localname");
        TextView t = (TextView)findViewById(R.id.LocalNameText);
        t.setText(localPlayerName);
        reqQueue = Volley.newRequestQueue(getApplicationContext());

        Button joinButton = (Button)findViewById(R.id.button);

        joinButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        openRoom();

                        Intent intent = new Intent(view.getContext(), ReadyPage.class);
                        // Changes value for local player name
                        intent.putExtra("localname", localPlayerName);
                        startActivityForResult(intent, 0);
                    }
                }
        );
    }

    private void openRoom(){
        JSONObject requestParams = new JSONObject();
        try{
            requestParams.put("userId", "test");
            requestParams.put("roomName", "abc");
            requestParams.put("userName", getIntent().getStringExtra("localname"));
            requestParams.put("roomId", ((TextView)findViewById(R.id.createRoomId)).getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, API_URL, requestParams,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(getApplicationContext(),"NAOOOOW",Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(getApplicationContext(),"YIIIS",Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),volleyError.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
        };
        reqQueue.add(req);
    }
}
