package split.split;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;


public class LastPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_page);

        final TextView lname = (TextView)findViewById(R.id.localname);
        lname.setText(getIntent().getStringExtra("localName"));

        final TextView lprice = (TextView)findViewById(R.id.localPrice);
        lprice.setText(getIntent().getStringExtra("localPrice"));

        Button venmoButton = (Button)findViewById(R.id.venmoButton);
        Button cardButton = (Button)findViewById(R.id.cardButton);

        venmoButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        final Intent intent = new Intent(view.getContext(), VotePage.class);
                        intent.putExtra("localName", getIntent().getStringExtra("localName"));
                        intent.putExtra("localPrice", getIntent().getStringExtra("localPrice"));
                        startActivity(intent);
                    }
                }
        );

        cardButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        final Intent intent = new Intent(view.getContext(), CardPage.class);
                        intent.putExtra("localName", getIntent().getStringExtra("localName"));
                        intent.putExtra("localPrice", getIntent().getStringExtra("localPrice"));
                        startActivity(intent);
                    }
                }
        );
    }
}
