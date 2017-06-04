package split.split;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.os.Handler;
import android.widget.EditText;

public class ReadyPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready_page);

        // Retrieve localPlayerName from CreateRoom.java or JoinRoom.java
        final String localPlayerName = getIntent().getStringExtra("localName");
        TextView t = (TextView)findViewById(R.id.localname);
        t.setText(localPlayerName);

        final TextView readyText = (TextView)findViewById(R.id.betAmt1);
        final TextView readyText2 = (TextView)findViewById(R.id.betAmt2);
        final TextView readyText3 = (TextView)findViewById(R.id.readyText3);
        final TextView pricePrompt = (TextView)findViewById(R.id.pricePrompt);
        final TextView priceText = (TextView)findViewById(R.id.localPrice);
        final EditText priceInput = (EditText)findViewById(R.id.priceInput);

        final Button readyButton = (Button)findViewById(R.id.readyButton);
        final Button updateButton = (Button)findViewById(R.id.updateButton);


        updateButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        final String price = priceInput.getText().toString();
                        // Remove dollar sign
                        if(price.charAt(0) == '$') {
                            final String finalPrice = price.substring(1, price.length());
                            priceText.setText(finalPrice);
                        }
                        else {
                            final String finalPrice = price;
                            priceText.setText(finalPrice);
                        }
                    }
                }
        );

        readyButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        final Intent intent = new Intent(view.getContext(), BidPage.class);
                        // Change ready text to green

                        readyText.setTextColor(0xFF99CC00);
                        // 1 second delay
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Changes value for local player name
                                intent.putExtra("localName", localPlayerName);
                                intent.putExtra("localPrice", priceText.getText().toString());
                                startActivity(intent);
                                /*readyText.setText("0.00");
                                readyText2.setText("0.00");
                                readyText3.setText("0.00");
                                pricePrompt.setText("How much are you willing to risk?");
                                readyButton.setText("LOCK IN");
                                updateButton.setId(2);
                                readyButton.setId(3);*/
                            }
                        }, 1000);
                    }
                }
        );
    }
}
