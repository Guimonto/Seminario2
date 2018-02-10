package labs.sem03a.seminario2.Seminario2B;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import labs.sem03a.seminario2.R;

/**
 * Created by Guill on 10/02/2018.
 */

public class CustomAdapter extends ArrayAdapter {

    private Context context;
    private int x;
    private List<Quotation> data;

    public CustomAdapter(Context context, int x, List<Quotation> data){
        super(context,x,data);
        this.context = context;
        this.x = x;
        this.data = data;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        View view = convertView;
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.quotation_list_row, null);
        }

        Quotation item = data.get(position);
        TextView tvQ = (TextView) view.findViewById(R.id.tvQuotation);
        TextView tvA = (TextView) view.findViewById(R.id.tvAuthor);
        tvQ.setText(item.getTexto());
        tvA.setText(item.getAuthor());
        return view;
    }
}
