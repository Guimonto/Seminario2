package labs.sem03a.seminario2;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class QuotationActivity extends AppCompatActivity {

    boolean newQuotation = true;

    boolean addQuotation = false;

    TextView tvCita;
    TextView tvAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotation);

        TextView tv = findViewById(R.id.textViewScroll);
        tv.setText(getString(R.string.hello, getString(R.string.nameless)));

        tvCita = findViewById(R.id.textViewScroll);
        tvAuthor = findViewById(R.id.textViewQuot);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_quotation, menu);

        menu.findItem(R.id.refresh_button).setVisible(newQuotation);

        menu.findItem(R.id.add_button).setVisible(newQuotation && addQuotation);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.refresh_button:

                tvCita.setText(R.string.sample);
                tvAuthor.setText(R.string.sample_author);

                return true;

            case R.id.add_button:

                return true;

        }

        return super.onOptionsItemSelected(item);
    }


}
