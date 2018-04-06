package ng.dat.ar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by daviddryburgh on 28/03/2018.
 */

public class TourAdapter extends ArrayAdapter
{
    List list = new ArrayList();


    public TourAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }


    public void add(@Nullable Tours object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row;
        row = convertView;
        final TourHolder tourHolder;
        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.tour_row_layout, parent, false);

            tourHolder = new TourHolder();
            tourHolder.tx_id = (TextView) row.findViewById(R.id.tx_id);
            tourHolder.tx_name = (TextView) row.findViewById(R.id.tx_name);
            row.setTag(tourHolder);

            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String tour_id = tourHolder.tx_id.getText().toString();
                    String tour_name = tourHolder.tx_name.getText().toString();

                    Intent intent = new Intent(getContext(), TourDescription.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("tour_id", tour_id);
                    getContext().startActivity(intent);

                }
            });
        }
        else
        {
            tourHolder = (TourHolder)row.getTag();
        }

        Tours tour = (Tours)this.getItem(position);
        tourHolder.tx_id.setText(tour.getTour_id());
        tourHolder.tx_name.setText(tour.getName());

        return row;
    }

    static class TourHolder
    {
        TextView tx_id, tx_name;
    }
}
