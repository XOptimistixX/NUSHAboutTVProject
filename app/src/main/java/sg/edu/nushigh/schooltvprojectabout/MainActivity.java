package sg.edu.nushigh.schooltvprojectabout;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int wayneClicks = 0;
    private static final int REQUIRED_CLICKS = 20, MILLIS_BEFORE_RESET = 2000;
    private CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView mTimelineRecyclerView = (RecyclerView) findViewById(R.id.timeline_view);
        mTimelineRecyclerView.setAdapter(new TimelineAdapter(this));
        mTimelineRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView mDeveloperRecyclerView = (RecyclerView) findViewById(R.id.developer_recycler_view);

        Person ambrose =    new Person("Ambrose Chua", "Year 5, 2017", getDrawable(R.drawable.ambrose));
        Person andrew =     new Person("Andrew Yapp", "Year 4, 2017", getDrawable(R.drawable.andrew));
        Person danielLau =  new Person("Daniel Lau", "Year 5, 2017", getDrawable(R.drawable.daniellau));
        Person danielLim =  new Person("Daniel Lim Wee Soong", "Year 5, 2017", getDrawable(R.drawable.daniellim));
        Person jeffSieu =   new Person("Jeff Sieu", "Year 5, 2017", getDrawable(R.drawable.jeffsieu));
        Person jeffrey =    new Person("Jeffrey Lee", "Year 4, 2017", getDrawable(R.drawable.jeffrey));
        Person jingQuan =   new Person("Chong Jing Quan", "Year 5, 2017", getDrawable(R.drawable.jingquan));
        Person kokRui =     new Person("Wong Kok Rui", "Year 4, 2017", getDrawable(R.drawable.kokrui));
        Person shiHern =    new Person("Lim Shi Hern", "Year 5, 2017", getDrawable(R.drawable.shihern));
        Person hanpu =      new Person("Liu Hanpu", "Year 5, 2017", getDrawable(R.drawable.hanpu));
        Person kaiJun =     new Person("Tay Kai Jun", "Year 5, 2017", getDrawable(R.drawable.kaijun));
        Person ngocLinh =   new Person("Cao Ngoc Linh", "Year 4, 2017", getDrawable(R.drawable.ngoclinh));
        Person shane =      new Person("Shane Ong", "Year 4, 2017", getDrawable(R.drawable.shane));
        Person owen =       new Person("Owen Leong", "Year 5, 2017", getDrawable(R.drawable.owen));
        Person zayne =      new Person("Zayne Siew", "Year 4, 2017", getDrawable(R.drawable.zayne));
        Person ziXuan =     new Person("Ng Zi Xuan", "Year 6, 2017", getDrawable(R.drawable.zixuan));
        Person wayne =      new Person("Wayne Tee", "Year 5, 2016", getDrawable(R.drawable.wayne2));
        Person jingXuan =   new Person("Tay Jing Xuan", "Year 5, 2016", getDrawable(R.drawable.jingxuan));



        List<App> apps = new ArrayList<>();
        List<Person> launcherPeople = new ArrayList<>(),
                homeScreenPeople = new ArrayList<>(),
                feedbackPeople = new ArrayList<>(),
                mapPeople = new ArrayList<>(),
                announcementsPeople = new ArrayList<>(),
                busTimingsPeople = new ArrayList<>(),
                poiPeople = new ArrayList<>(),
                aboutPeople = new ArrayList<>(),
                appventurePeople = new ArrayList<>(),
                acrylicPeople = new ArrayList<>();

        App launcher = new App("Launcher", launcherPeople);
        App homeScreen = new App("Home Screen", homeScreenPeople);
        App map = new App("School Map", mapPeople);
        App feedback = new App("Feedback", feedbackPeople);
        App announcements = new App("Announcements", announcementsPeople);
        App busTimings = new App("Bus Timings", busTimingsPeople);
        App poi = new App("Places of Interest", poiPeople);
        App about = new App("About", aboutPeople);
        App appventure = new App("AppVenture App", appventurePeople);
        App acrylic = new App("Acrylic Case and Plaque", acrylicPeople);

        launcherPeople.add(ambrose);
        launcherPeople.add(shiHern);
        launcherPeople.add(hanpu);
        homeScreenPeople.add(andrew);
        homeScreenPeople.add(ngocLinh);
        homeScreenPeople.add(shane);
        mapPeople.add(danielLim);
        mapPeople.add(jeffSieu);
        mapPeople.add(owen);
        mapPeople.add(kaiJun);
        feedbackPeople.add(jingQuan);
        feedbackPeople.add(jeffrey);
        announcementsPeople.add(danielLau);
        busTimingsPeople.add(wayne);
        busTimingsPeople.add(jingXuan);
        poiPeople.add(kokRui);
        poiPeople.add(zayne);
        aboutPeople.add(jeffSieu);
        appventurePeople.add(ziXuan);
        acrylicPeople.add(ambrose);


        apps.add(launcher);
        apps.add(homeScreen);
        apps.add(map);
        apps.add(feedback);
        apps.add(announcements);
        apps.add(busTimings);
        apps.add(poi);
        apps.add(about);
        apps.add(acrylic);
        apps.add(appventure);


        mDeveloperRecyclerView.setAdapter(new AppAdapter(this, apps));
        mDeveloperRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));


        View wayneFace = findViewById(R.id.face);
        wayneClicks = 0;
        timer = new CountDownTimer(MILLIS_BEFORE_RESET, MILLIS_BEFORE_RESET) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                if (wayneClicks == REQUIRED_CLICKS) {
                    Toast.makeText(getApplicationContext(), "Launching admin app", Toast.LENGTH_SHORT).show();
                    Intent launchIntent = getPackageManager().getLaunchIntentForPackage("sg.edu.nushigh.admin");
                    if (launchIntent != null) {
                        startActivity(launchIntent);
                    }
                }
                wayneClicks = 0;
            }
        }.start();
        wayneFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();
                timer.start();
                wayneClicks++;
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        wayneClicks = 0;
    }
}
