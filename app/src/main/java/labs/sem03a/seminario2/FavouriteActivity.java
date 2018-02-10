package labs.sem03a.seminario2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import labs.sem03a.seminario2.Seminario2B.CustomAdapter;
import labs.sem03a.seminario2.Seminario2B.Quotation;

public class FavouriteActivity extends AppCompatActivity {

    Context context;
    ListView favouriteListView;
    List<Quotation> quotationList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        context = this;
        favouriteListView = (ListView) findViewById(R.id.lvFavourite);
        quotationList = new ArrayList<>();
        quotationList.addAll(getMockQuotations());
        adapter = new CustomAdapter(this, R.layout.quotation_list_row, quotationList);

        favouriteListView.setAdapter((ListAdapter) adapter);

    }

    public void authorInfoImplicit(View v){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://en.wikipedia.org/wiki/Special:Search?search=Albert Einstein"));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public ArrayList<Quotation> getMockQuotations(){
        ArrayList<Quotation> quotations = new ArrayList<>();
        Quotation item;

        item = new Quotation();
        item.setTexto("Think Big");
        item.setAuthor("IMAX");
        quotations.add(item);

        item = new Quotation();
        item.setTexto("Push button publishing");
        item.setAuthor("Blogger");
        quotations.add(item);

        item = new Quotation();
        item.setTexto("Beauty outside. Beast inside");
        item.setAuthor("Mac Pro");
        quotations.add(item);

        item = new Quotation();
        item.setTexto("American by birth. Rebel by choice");
        item.setAuthor("Harley Davidson");
        quotations.add(item);

        item = new Quotation();
        item.setTexto("Don't be evil");
        item.setAuthor("Google");
        quotations.add(item);

        item = new Quotation();
        item.setTexto("If you want to impress someone, put him on your Black list");
        item.setAuthor("Johnnie Walker");
        quotations.add(item);

        item = new Quotation();
        item.setTexto("Live in your world. Play in ours");
        item.setAuthor("Playstation");
        quotations.add(item);

        item = new Quotation();
        item.setTexto("Impossible is nothing");
        item.setAuthor("Adidas");
        quotations.add(item);

        item = new Quotation();
        item.setTexto("Solutions for a small planet");
        item.setAuthor("IBM");
        quotations.add(item);

        item = new Quotation();
        item.setTexto("I'm lovin it");
        item.setAuthor("McDonalds");
        quotations.add(item);

        return quotations;
    }
}
