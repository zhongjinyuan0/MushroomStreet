package mushroomstreet.mushroomstreet;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import fragment.HomePageFragment;
import fragment.MessageFragment;
import fragment.PersonalCenterFragment;
import fragment.SearchFragment;


public class MainActivity extends ActionBarActivity {

    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager homePageViewPager = (ViewPager) findViewById(R.id.homePageViewPager);
        fragments = new ArrayList<Fragment>();
        fragments.add(new HomePageFragment());
        fragments.add(new SearchFragment());
        fragments.add(new MessageFragment());
        fragments.add(new PersonalCenterFragment());
        HomePageViewPagerAdapter homePageViewPagerAdapter = new HomePageViewPagerAdapter(getSupportFragmentManager());
        homePageViewPager.setAdapter(homePageViewPagerAdapter);

    }

    class HomePageViewPagerAdapter extends FragmentPagerAdapter{


        public HomePageViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
