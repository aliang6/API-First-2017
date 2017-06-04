package split.split;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

public class ResultPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);

        final TextView localname = (TextView)findViewById(R.id.localname);
        final String lname = getIntent().getStringExtra("localName");
        localname.setText(lname);

        TextView localScore = (TextView)findViewById(R.id.localPrice);
        localScore.setText(getIntent().getStringExtra("localScore"));

        Button yes = (Button)findViewById(R.id.venmoButton);
        Button no = (Button)findViewById(R.id.noButton);

        yes.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        final Intent intent = new Intent(view.getContext(), VotePage.class);
                        intent.putExtra("localName", lname);
                        intent.putExtra("localPrice", getIntent().getStringExtra("localPrice"));
                        intent.putExtra("localScore", getIntent().getStringExtra("localScore"));
                        startActivity(intent);
                    }
                }
        );

        no.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        final Intent intent = new Intent(view.getContext(), LastPage.class);
                        intent.putExtra("localName", lname);
                        intent.putExtra("localPrice", getIntent().getStringExtra("localPrice"));
                        startActivity(intent);
                    }
                }
        );

    }
}
