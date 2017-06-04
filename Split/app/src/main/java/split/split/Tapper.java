package split.split;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.os.Handler;
import android.content.Intent;

public class Tapper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tapper);

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
                final TextView gameTimer = (TextView)findViewById(R.id.GameTimer);

                new CountDownTimer(15000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        String text = "Timer: " + (int)(millisUntilFinished/1000);
                        gameTimer.setText(text);
                    }

                    public void onFinish() {
                        intent.putExtra("localName", getIntent().getStringExtra("localName"));
                        intent.putExtra("localPrice", getIntent().getStringExtra("localPrice"));
                        intent.putExtra("localScore", tapButton.getText().toString());
                        startActivity(intent);
                    }
                }.start();
            }
        }, 5000);


    }

    public void incrementTap(View view) {
        Button tapButton = (Button)findViewById(R.id.tapButton);
        String count = tapButton.getText() + "";
        count = Integer.toString((Integer.parseInt(count) + 1));
        tapButton.setText(count);
    };
}
