package labs.sem03a.seminario2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import labs.sem03a.seminario2.Seminario2B.CustomAdapter;
import labs.sem03a.seminario2.Seminario2B.Quotation;

public class FavouriteActivity extends AppCompatActivity {

    Context context;
    ListView favouriteListView;
    List<Quotation> quotationList;
    Adapter adapter;
    int selectedItem;
    boolean clearAllQuotations;

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

        favouriteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Quotation q = (Quotation) favouriteListView.getItemAtPosition(position);
                String author = q.getAuthor();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://en.wikipedia.org/wiki/Special:Search?search=" + author));

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
            }
        });

        favouriteListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = position;

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage(R.string.confirmation_delete);

                builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        quotationList.remove(selectedItem);
                        ((CustomAdapter) adapter).notifyDataSetChanged();
                        //adapter.notify();
                    }
                });

                builder.setNegativeButton(android.R.string.no, null);

                builder.create().show();

                return  true;
            }
        });

        if (quotationList.size() > 0){
            clearAllQuotations = true;
        }
    }



    public void authorInfoImplicit(View v){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://en.wikipedia.org/wiki/Special:Search?search=Albert Einstein"));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_favourite, menu);

        menu.findItem(R.id.clear_action).setVisible(clearAllQuotations);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){

            case R.id.clear_action:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setMessage(R.string.confirmation_delete_all);

                builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        quotationList.clear();

                        ((CustomAdapter) adapter).notifyDataSetChanged();

                        clearAllQuotations = false;

                        supportInvalidateOptionsMenu();
                    }
                });

                builder.setNegativeButton(android.R.string.no, null);

                builder.create().show();

                return true;

        }

        return super.onOptionsItemSelected(item);
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
