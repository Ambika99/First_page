package ambika.android.com.first_page;

import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import me.relex.circleindicator.CircleIndicator;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout mdrawer;
    private ActionBarDrawerToggle mdrawertoggle;
    ViewPager viewpager;
    CustomSwipeAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdrawer =(DrawerLayout) findViewById(R.id.drawerlayout);
        mdrawertoggle = new ActionBarDrawerToggle(this,mdrawer,R.string.open,R.string.close);
        mdrawer.addDrawerListener(mdrawertoggle);
        mdrawertoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewpager = (ViewPager) findViewById(R.id.pager);
        adapter = new CustomSwipeAdapter(this);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        viewpager.setAdapter(adapter);
        indicator.setViewPager(viewpager);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mdrawertoggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
