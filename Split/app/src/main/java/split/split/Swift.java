package split.split;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Swift extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swift);
        final TextView timer = (TextView)findViewById(R.id.Timer);
        final Button tapButton = (Button)findViewById(R.id.tapButton);

        new CountDownTimer(6000, 1000) {

            public void onTick(long millisUntilFinished) {
                String text = (int)(millisUntilFinished/1000) + "";
                timer.setText(text);
            }

            public void onFinish() {
                timer.setVisibility(View.GONE);
            }
        }.start();

        final Intent intent = new Intent(this, ResultPage.class);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tapButton.setVisibility(View.VISIBLE);

                new CountDownTimer(5000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        final long reactionTime = millisUntilFinished;
                        final String text = ((5.000 - reactionTime / 1000.0) + "").substring(0, 6);
                        tapButton.setText(text);
                        tapButton.setOnClickListener(
                                new View.OnClickListener() {
                                    public void onClick(View view) {
                                        final Handler handler2 = new Handler();
                                        handler.postDelayed(new Runnable(){
                                            public void run() {
                                                intent.putExtra("localName", getIntent().getStringExtra("localName"));
                                                intent.putExtra("localPrice", getIntent().getStringExtra("localPrice"));
                                                intent.putExtra("localScore", tapButton.getText().toString());
                                                startActivity(intent);
                                            }
                                        }, 1000);
                                    }
                                }
                        );
                    }

                    public void onFinish() {
                        intent.putExtra("localName", getIntent().getStringExtra("localName"));
                        intent.putExtra("localPrice", getIntent().getStringExtra("localPrice"));
                        intent.putExtra("localScore", tapButton.getText().toString());
                        startActivity(intent);
                    }
                }.start();
            }
        }, 5500);


    }
}
