package ambika.android.com.first_page;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import me.relex.circleindicator.CircleIndicator;


public class MainActivity extends AppCompatActivity{
    private DrawerLayout mdrawer;
    private ActionBarDrawerToggle mdrawertoggle;
    //ViewPager viewpager;
    //CustomSwipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdrawer =(DrawerLayout) findViewById(R.id.drawerlayout);
        mdrawertoggle = new ActionBarDrawerToggle(this,mdrawer,R.string.open,R.string.close);
        mdrawer.addDrawerListener(mdrawertoggle);
        mdrawertoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigation = (NavigationView) findViewById(R.id.drawer);
        setdrawercontent(navigation);
        //navigation.setNavigationItemSelectedListener(this);
        //viewpager = (ViewPager) findViewById(R.id.pager);
        //adapter = new CustomSwipeAdapter(this);
        //CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        //viewpager.setAdapter(adapter);
        //indicator.setViewPager(viewpager);



    }
    public void selectItemDrawer(MenuItem menuItem){
        Fragment myfragment=null;
        Class fragmentClass =null;
        if(menuItem.getItemId()==R.id.aboutus) {
            android.support.v4.app.FragmentManager fragementManager = getSupportFragmentManager();
            fragementManager.beginTransaction().replace(R.id.fragment, new AboutUs()).commit();
            menuItem.setChecked(true);
            setTitle(menuItem.getTitle());
            mdrawer.closeDrawers();
        }

    }
    private void setdrawercontent (NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectItemDrawer(item);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mdrawertoggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
