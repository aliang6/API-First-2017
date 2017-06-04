package split.split;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class VotePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_page);

        final Button tapper = (Button)findViewById(R.id.TapperButton);

        tapper.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), Tapper.class);
                        intent.putExtra("localName", getIntent().getStringExtra("localName"));
                        intent.putExtra("localPrice", getIntent().getStringExtra("localPrice"));
                        startActivity(intent);
                    }
                }
        );
    }
}
