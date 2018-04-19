package ng.dat.ar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity
{
    Button explore, tours, preferences, help;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        explore = (Button) findViewById(R.id.btn_explore);
    }

    public void launchExplore(View view)
    {
        startActivity(new Intent(this, ARActivity.class));
    }

    public void launchTours(View view)
    {
        startActivity(new Intent(this, ToursActivity.class));
    }

    public void launchPreferences(View view)
    {
        startActivity(new Intent(this, PlacesActivity.class));
    }

    public void launchHelp(View view)
    {
        startActivity(new Intent(this, HelpActivity.class));
    }
}
