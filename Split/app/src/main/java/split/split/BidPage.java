package split.split;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BidPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_page);

        // Retrieve localPlayerName from CreateRoom.java or JoinRoom.java
        final String localPlayerName = getIntent().getStringExtra("localName");
        final TextView t = (TextView)findViewById(R.id.localname);
        t.setText(localPlayerName);

        final TextView betAmt1 = (TextView)findViewById(R.id.betAmt1);
        final TextView betAmt2 = (TextView)findViewById(R.id.betAmt2);
        final TextView betAmt3 = (TextView)findViewById(R.id.betAmt3);
        final TextView priceText = (TextView)findViewById(R.id.localPrice);
        priceText.setText(getIntent().getStringExtra("localPrice"));
        final EditText priceInput = (EditText)findViewById(R.id.priceInput);

        final Button lockInButton = (Button)findViewById(R.id.readyButton);
        final Button updateButton = (Button)findViewById(R.id.updateButton);

        updateButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        final String price = priceInput.getText().toString();
                        // Remove dollar sign
                        if(price.charAt(0) == '$') {
                            betAmt1.setText(price);
                        }
                        else {
                            final String finalPrice = "$" + price;
                            priceText.setText(finalPrice);
                        }
                    }
                }
        );

        lockInButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        final Intent intent = new Intent(view.getContext(), VotePage.class);
                        // Change ready text to green

                        betAmt1.setTextColor(0xFF99CC00);
                        // 1 second delay
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                // Changes value for local player name
                                intent.putExtra("localName", localPlayerName);
                                intent.putExtra("localPrice", getIntent().getStringExtra("localPrice"));
                                startActivity(intent);
                            }
                        }, 1000);
                    }
                }
        );
    }
}
