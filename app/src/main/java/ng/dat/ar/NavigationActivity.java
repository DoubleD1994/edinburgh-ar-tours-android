package ng.dat.ar;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class NavigationActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView mNavView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawlay);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mNavView = (NavigationView) findViewById(R.id.navView);

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
                        Intent iAR = new Intent(NavigationActivity.this, ARActivity.class);
                        startActivity(iAR);
                        break;
                    case R.id.nav_map:
                        Intent iMap = new Intent(NavigationActivity.this, MainMenu.class);
                        startActivity(iMap);
                        break;
                    case R.id.nav_tour:
                        Intent iTour = new Intent(NavigationActivity.this, ToursActivity.class);
                        startActivity(iTour);
                        break;
                    case R.id.nav_help:
                        Intent iHelp = new Intent(NavigationActivity.this, HelpActivity.class);
                        startActivity(iHelp);
                        break;
                    case R.id.nav_settings:
                        Intent iSettings = new Intent(NavigationActivity.this, PreferencesActivity.class);
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


}
