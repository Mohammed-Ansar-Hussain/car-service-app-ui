package com.example.cap_carassistpro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    GridView gridview,gridview1;

    public static String[] osNameList = {
            "Car Polish",
            "Complete Car SPA",
            "Bumper Repainting",
            "AC service",
            "Oil change",
            "Interior detailing",
            "Express service",
            "Dent removal",
    };
    public static int[] osImages = {
            R.drawable.carpolish,
            R.drawable.completecarspa,
            R.drawable.bumperrepainting,
            R.drawable.acservice,
            R.drawable.oilchange,
            R.drawable.interiordetailing,
            R.drawable.expressservice,
            R.drawable.dentremoval,};

    public static String[] osNameList1 = {
            "Repair Job",
            "Bike Ceramic",
            "General Service",
            "Premium Bike Service",

    };
    public static int[] osImages1 = {
            R.drawable.repairjob,
            R.drawable.bikeceramic,
            R.drawable.generalservice,
            R.drawable.premiumbikeservice,
            };


    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<ImageModel> imageModelArrayList;

    private int[] myImageList = new int[]{R.drawable.cmg4, R.drawable.cmg2,
            R.drawable.cmg3,R.drawable.cmg6
            ,R.drawable.cmg5,R.drawable.cmg1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridview=(GridView)findViewById(R.id.customgrid2);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:startActivity(new Intent(MainActivity.this,carpolish.class));
                    break;
                        //Toast.makeText(context, "You Clicked 1 -"+result[position], Toast.LENGTH_SHORT).show();

                    case 1://Toast.makeText(context, "You Clicked 1 -"+result[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 2:break;
                    case 3:break;
                    case 4:break;
                    case 5:break;

                }
            }
        });

        gridview1=(GridView)findViewById(R.id.customgrid1);
        gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:startActivity(new Intent(MainActivity.this,carpolish.class));
                        break;
                    //Toast.makeText(context, "You Clicked 1 -"+result[position], Toast.LENGTH_SHORT).show();

                    case 1://Toast.makeText(context, "You Clicked 1 -"+result[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 2:break;
                    case 3:break;
                    case 4:break;
                    case 5:break;

                }
            }
        });


        toolbar=(Toolbar)findViewById(R.id.toolbarmain);
        toolbar.setTitle("<---your CAR we CARE--->");
        setSupportActionBar(toolbar);

        // Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)

                .withHeaderBackground(R.drawable.cmg6)
                .addProfiles(
                        new ProfileDrawerItem().withName("").withEmail("").withIcon(getResources().getDrawable(R.drawable.cmg5))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();


        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("HOME");
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("Profile");
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName("Contact Us");
        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(4).withName("About Us");
        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(5).withName("Logout");

//create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        item3,
                        item4,
                        item5

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        switch (position)
                        {
                            case 1:break;
                            case 2:break;
                            case 3:break;
                            case 4:break;
                            case 5:break;

                        }
                        return true;
                    }
                })
                .build();

        gridview = (GridView) findViewById(R.id.customgrid2);
        gridview.setAdapter(new CustomAdapter(this, osNameList, osImages));

        imageModelArrayList = new ArrayList<>();
        imageModelArrayList = populateList();

        init();


        gridview1 = (GridView) findViewById(R.id.customgrid1);
        gridview1.setAdapter(new CustomAdapter1(this, osNameList1, osImages1));

        imageModelArrayList = new ArrayList<>();
        imageModelArrayList = populateList();



    }

    private ArrayList<ImageModel> populateList(){

        ArrayList<ImageModel> list = new ArrayList<>();

        for(int i = 0; i < 6; i++){
            ImageModel imageModel = new ImageModel();
            imageModel.setImage_drawable(myImageList[i]);
            list.add(imageModel);
        }

        return list;
    }

    private void init() {

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(MainActivity.this,imageModelArrayList));

        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES =imageModelArrayList.size();

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id== R.id.queriesmenu)
        {
           // logout();
            //finish();
         //   startActivity(new Intent(mainnavigate.this, MainActivity.class));
        }

        if(id== R.id.chatbotmenu)
        {

          //  startActivity(new Intent(mainnavigate.this, lostnfound.class));
        }

        if(id== R.id.settingsmenu)
        {

          //  startActivity(new Intent(mainnavigate.this, nutshell.class));
        }


        return super.onOptionsItemSelected(item);
    }


}
