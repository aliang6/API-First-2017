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
        final Button calc = (Button)findViewById(R.id.calcButton);
        final Button rps = (Button)findViewById(R.id.rpsButton);
        final Button swift = (Button)findViewById(R.id.swiftButton);
        final Button typist = (Button)findViewById(R.id.typistButton);
        final Button average = (Button)findViewById(R.id.averageButton);
        final Button random = (Button)findViewById(R.id.randomButton);

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

        calc.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), Tapper.class);
                        intent.putExtra("localName", getIntent().getStringExtra("localName"));
                        intent.putExtra("localPrice", getIntent().getStringExtra("localPrice"));
                        startActivity(intent);
                    }
                }
        );

        rps.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), Tapper.class);
                        intent.putExtra("localName", getIntent().getStringExtra("localName"));
                        intent.putExtra("localPrice", getIntent().getStringExtra("localPrice"));
                        startActivity(intent);
                    }
                }
        );

        average.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), Tapper.class);
                        intent.putExtra("localName", getIntent().getStringExtra("localName"));
                        intent.putExtra("localPrice", getIntent().getStringExtra("localPrice"));
                        startActivity(intent);
                    }
                }
        );

        typist.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), Tapper.class);
                        intent.putExtra("localName", getIntent().getStringExtra("localName"));
                        intent.putExtra("localPrice", getIntent().getStringExtra("localPrice"));
                        startActivity(intent);
                    }
                }
        );

        swift.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), Swift.class);
                        intent.putExtra("localName", getIntent().getStringExtra("localName"));
                        intent.putExtra("localPrice", getIntent().getStringExtra("localPrice"));
                        startActivity(intent);
                    }
                }
        );

        random.setOnClickListener(
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
