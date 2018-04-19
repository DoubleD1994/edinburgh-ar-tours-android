package ng.dat.ar;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
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

public class PlacesActivity extends AppCompatActivity {

    String JSON_STRING;
    JSONObject jsonObject;
    JSONArray jsonArray;
    PoiAdapter poiAdapter;
    ListView listView;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView mNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        new BackgroundTask().execute();
        setTitle("Places");

        mDrawerLayout = (DrawerLayout) findViewById(R.id.prefDrawLay);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mNavView = (NavigationView) findViewById(R.id.placesNavView);

        //Toolbar mTool = (Toolbar) findViewById(R.id.actionNavToolbar);
        //setSupportActionBar(mTool);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.nav_ar:
                        Intent iAR = new Intent(PlacesActivity.this, ARActivity.class);
                        startActivity(iAR);
                        break;
                    case R.id.nav_map:
                        Intent iMap = new Intent(PlacesActivity.this, ARActivity.class);
                        startActivity(iMap);
                        break;
                    case R.id.nav_tour:
                        Intent iTour = new Intent(PlacesActivity.this, ToursActivity.class);
                        startActivity(iTour);
                        break;
                    case R.id.nav_help:
                        Intent iHelp = new Intent(PlacesActivity.this, HelpActivity.class);
                        startActivity(iHelp);
                        break;
                    case R.id.nav_settings:
                        Intent iSettings = new Intent(PlacesActivity.this, PlacesActivity.class);
                        startActivity(iSettings);
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void parseJson()
    {
        if(JSON_STRING==null)
        {
            Toast.makeText(getApplicationContext(), "First Get JSON", Toast.LENGTH_LONG).show();
        }
        else
        {
            poiAdapter = new PoiAdapter(this, R.layout.poi_row_layout);
            listView = (ListView) findViewById(R.id.listview);
            listView.setAdapter(poiAdapter);

            try
            {
                jsonObject = new JSONObject(JSON_STRING);
                jsonArray = jsonObject.getJSONArray("server_response");
                int count = 0;

                String id, name, lat, lon, alt;

                while(count<jsonArray.length())
                {
                    JSONObject JO = jsonArray.getJSONObject(count);
                    id = JO.getString("id");
                    name = JO.getString("name");
                    lat = JO.getString("latitude");
                    lon = JO.getString("longitude");
                    alt = JO.getString("altitude");

                    Pois poi = new Pois(id, name, lat, lon, alt);
                    poiAdapter.add(poi);

                    count++;
                }
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
    }

    class BackgroundTask extends AsyncTask<Void, Void, String>
    {
        String json_url;

        @Override
        protected void onPreExecute()
        {
            json_url="http://punier-boresights.000webhostapp.com/json_get_pois.php";
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

                while((JSON_STRING = bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(JSON_STRING+"\n");
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
            JSON_STRING = result;
            parseJson();
        }
    }

}
