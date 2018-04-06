package ng.dat.ar;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TourDescription extends AppCompatActivity {

    TextView tour_id, tour_name, tour_description;
    String JSON_STRING_TOUR, JSON_STRING_POI;
    JSONObject jsonObject;
    JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_description);
        String id = getIntent().getStringExtra("tour_id");

        tour_id = (TextView) findViewById(R.id.txt_tour_id);
        tour_name = (TextView) findViewById(R.id.txt_tour_name);
        tour_description = (TextView)  findViewById(R.id.txt_tour_descrip);

        BackgroundTaskTour backgroundTaskTour = new BackgroundTaskTour();
        backgroundTaskTour.tour_id = id;
        backgroundTaskTour.execute();

        BackgroundTaskPoi backgroundTaskPoi = new BackgroundTaskPoi();
        backgroundTaskPoi.tour_id = id;
        backgroundTaskPoi.execute();
    }

    public void parseJsonTour()
    {
        if(JSON_STRING_TOUR==null)
        {
            Toast.makeText(getApplicationContext(), "First Get JSON", Toast.LENGTH_LONG).show();
        }
        else
        {
            try
            {
                jsonObject = new JSONObject(JSON_STRING_TOUR);
                jsonArray = jsonObject.getJSONArray("server_response");
                int count = 0;

                String id = "", name = "", description = "";

                while(count<jsonArray.length())
                {
                    JSONObject JO = jsonArray.getJSONObject(count);
                    id = JO.getString("tour_id");
                    name = JO.getString("name");
                    description = JO.getString("description");

                    count++;
                }

                tour_id.setText(id);
                tour_name.setText(name);
                tour_description.setText(description);

            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void parseJsonPoi()
    {
        if(JSON_STRING_POI==null)
        {
            Toast.makeText(getApplicationContext(), "First Get JSON", Toast.LENGTH_LONG).show();
        }
        else
        {
            try
            {
                jsonObject = new JSONObject(JSON_STRING_POI);
                jsonArray = jsonObject.getJSONArray("server_response");

                Toast.makeText(getApplicationContext(), jsonArray.toString(), Toast.LENGTH_LONG).show();

            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
    }

    class BackgroundTaskTour extends AsyncTask<Void, Void, String>
    {
        String json_url;
        String tour_id;

        @Override
        protected void onPreExecute()
        {
            json_url="http://punier-boresights.000webhostapp.com/json_get_selected_tour.php?tour_id="+tour_id+"";
        }

        @Override
        protected String doInBackground(Void... voids)
        {
            try
            {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();

                while((JSON_STRING_TOUR = bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(JSON_STRING_TOUR+"\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values)
        {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result)
        {
            JSON_STRING_TOUR = result;
            parseJsonTour();
        }
    }

    class BackgroundTaskPoi extends AsyncTask<Void, Void, String>
    {
        String json_url;
        String tour_id;

        @Override
        protected void onPreExecute()
        {
            json_url="http://punier-boresights.000webhostapp.com/json_get_tours_pois.php?tour_id="+tour_id+"";
        }

        @Override
        protected String doInBackground(Void... voids)
        {
            try
            {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();

                while((JSON_STRING_POI = bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(JSON_STRING_POI+"\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values)
        {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result)
        {
            JSON_STRING_POI = result;
            parseJsonPoi();
        }
    }
}
