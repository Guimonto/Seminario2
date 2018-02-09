package labs.sem03a.seminario2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    private static final int INTENT_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Button uno = findViewById(R.id.button1);

        Button dos = findViewById(R.id.button2);

        Button tres = findViewById(R.id.button3);

        Button quatre = findViewById(R.id.button4);
    }

    public void predeterminado(View v){

        switch (v.getId()){

            case R.id.button2:
                Intent fav = new Intent(this, FavouriteActivity.class);
                startActivity(fav);
                break;

            case R.id.button3:
                Intent sett = new Intent(this, SettingsActivity.class);
                startActivity(sett);
                break;

            case R.id.button4:
                Intent abo = new Intent(this, AboutActivity.class);
                startActivity(abo);
                break;

            case R.id.button1:
                Intent quotation = new Intent(this, QuotationActivity.class);
                startActivity(quotation);
                break;
        }
    }
}
