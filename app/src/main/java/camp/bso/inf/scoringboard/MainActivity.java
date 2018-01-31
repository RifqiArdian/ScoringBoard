package camp.bso.inf.scoringboard;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnDetailPersib;
    Button btnDetailPersija;
    Button btnBerita;
    Button btnMaps;
    int scorePersib =0;
    int scorePersija =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDetailPersib = findViewById(R.id.btnPersib);
        btnDetailPersib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,DetailPersib.class);
                startActivity(i);
            }
        });

        btnDetailPersija = findViewById(R.id.btnPersija);
        btnDetailPersija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,DetailPersija.class);
                startActivity(i);
            }
        });

        btnBerita = findViewById(R.id.btnBerita);
        btnBerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                String urllink = "https://sport.detik.com/sepakbola/indeksfokus/2894/persib-vs-persija/berita";
                browserIntent.setData(Uri.parse(urllink));
                startActivity(browserIntent);
            }
        });

        btnMaps = findViewById(R.id.btnMaps);
        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:-6.957254, 107.712072");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
        });
    }

    public void incrementPersib(View view){
        scorePersib = scorePersib + 1;
        displayScorePersib(scorePersib);
    }

    public void incrementPersija(View view){
        scorePersija = scorePersija + 1;
        displayScorePersija(scorePersija);
    }

    public void decrementPersib(View view){
        if(scorePersib>0) {
            scorePersib = scorePersib - 1;
        }else{
            Toast.makeText(this, "Score tidak boleh kurang dari 0", Toast.LENGTH_SHORT).show();
        }
        displayScorePersib(scorePersib);
    }

    public void decrementPersija(View view){
        if(scorePersija>0) {
            scorePersija = scorePersija - 1;
        }else{
            Toast.makeText(this, "Score tidak boleh kurang dari 0", Toast.LENGTH_SHORT).show();
        }
        displayScorePersija(scorePersija);
    }

    public void reset(View view){
        scorePersija = 0;
        scorePersib = 0;
        displayScorePersija(scorePersija);
        displayScorePersib(scorePersib);
    }

    private void displayScorePersib(int scorePersib){
        TextView ScorePersib = (TextView)findViewById(R.id.TvScorePersib);
        ScorePersib.setText(""+scorePersib);
    }

    private void displayScorePersija(int scorePersija){
        TextView ScorePersija = (TextView)findViewById(R.id.TvScorePersija);
        ScorePersija.setText(""+scorePersija);
    }
}
