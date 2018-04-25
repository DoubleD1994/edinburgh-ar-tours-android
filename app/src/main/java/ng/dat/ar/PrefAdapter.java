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

public class PrefAdapter extends ArrayAdapter
{
    List list = new ArrayList();


    public PrefAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }


    public void add(@Nullable ThePreferences object) {
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
        final PrefHolder prefHolder;
        if(row == null)
        {
            //List each preference on the screen as a card.
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.pref_card, parent, false);

            prefHolder = new PrefHolder();
            prefHolder.tx_id = (TextView) row.findViewById(R.id.prefId);
            prefHolder.tx_title = (TextView) row.findViewById(R.id.prefTitle);
            row.setTag(prefHolder);

            // When a user clicks on a preference, pass the id of that preference to the ARActivity
            // class.
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String pref_id = prefHolder.tx_id.getText().toString();
                    String pref_title = prefHolder.tx_title.getText().toString();

                    Intent intent = new Intent(getContext(), ARActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("access", "preference");
                    intent.putExtra("prefId", pref_id);
                    getContext().startActivity(intent);

                }
            });
        }
        else
        {
            prefHolder = (PrefHolder) row.getTag();
        }

        ThePreferences pref = (ThePreferences) this.getItem(position);
        prefHolder.tx_id.setText(pref.getId());
        prefHolder.tx_title.setText(pref.getTitle());

        return row;
    }

    static class PrefHolder
    {
        TextView tx_id, tx_title;
    }
}
