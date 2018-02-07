package labs.sem03a.seminario2;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class QuotationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotation);

        TextView tv = findViewById(R.id.textViewScroll);
        tv.setText(getString(R.string.hello, getString(R.string.nameless)));

        ImageButton button = findViewById(R.id.imageButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = findViewById(R.id.textViewQuot);
                tv.setText(getString(R.string.sample_author));

                TextView tv1 = findViewById(R.id.textViewScroll);
                tv1.setText(getString(R.string.sample));
            }
        });

    }


}
