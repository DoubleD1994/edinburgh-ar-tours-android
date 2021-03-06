package ng.dat.ar;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daviddryburgh on 28/03/2018.
 */

public class PoiAdapter extends ArrayAdapter
{
    List list = new ArrayList();

    public PoiAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }


    public void add(@Nullable Pois object) {
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
        final PoiHolder poiHolder;
        if(row == null)
        {
            //List each POI on the screen as a card.
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.poi_card, parent, false);
            poiHolder = new PoiHolder();
            poiHolder.tx_id = (TextView) row.findViewById(R.id.tx_id);
            poiHolder.tx_name = (TextView) row.findViewById(R.id.tx_name);
            poiHolder.tx_lat = (TextView) row.findViewById(R.id.tx_latitude);
            poiHolder.tx_lon = (TextView) row.findViewById(R.id.tx_longitude);
            poiHolder.tx_alt = (TextView) row.findViewById(R.id.tx_altitude);
            row.setTag(poiHolder);

            // When user clicks on a POI, the ARActivity is launched and the ID of this POI is
            // Passed to the ARActivity class.
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String poi_id = poiHolder.tx_id.getText().toString();

                    Intent intent = new Intent(getContext(), ARActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("access", "location");
                    intent.putExtra("poiId", poi_id);
                    getContext().startActivity(intent);

                }
            });

        }
        else
        {
            poiHolder = (PoiHolder)row.getTag();
        }

        Pois poi = (Pois)this.getItem(position);
        poiHolder.tx_id.setText(poi.getId());
        poiHolder.tx_name.setText(poi.getName());
        poiHolder.tx_lat.setText(poi.getLat());
        poiHolder.tx_lon.setText(poi.getLon());
        poiHolder.tx_alt.setText(poi.getAlt());

        return row;
    }

    static class PoiHolder
    {
        TextView tx_id, tx_name, tx_lat, tx_lon, tx_alt;
    }
}
