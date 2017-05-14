package com.example.devil.browser;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TabHost th;
    TextView showresult;
    long start;
    long stop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        th= (TabHost) findViewById(R.id.tabhost);
        Button newtab= (Button) findViewById(R.id.addtab);
        Button bstart= (Button) findViewById(R.id.bsw);
        Button bstop= (Button) findViewById(R.id.stop);
        showresult= (TextView) findViewById(R.id.show);
        newtab.setOnClickListener(this);
        th.setup();
        TabHost.TabSpec spec=th.newTabSpec("tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("stopwatch");
        th.addTab(spec);
        spec=th.newTabSpec("tag2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Tab");
        th.addTab(spec);
        spec=th.newTabSpec("tag3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("addtab");
        th.addTab(spec);

    }

    @Override
    public void onClick(View arg0) {

        switch (arg0.getId()){

            case R.id.addtab:
                TabHost.TabSpec ourspec =th.newTabSpec("tag1");
                TabHost.TabSpec spec = ourspec.setContent(new TabHost.TabContentFactory() {
                    @Override
                    public View createTabContent(String tag) {
                        TextView text = new TextView(MainActivity.this);
                        text.setText("you have created a new tab");
                        return (text);
                    }
                });
                ourspec.setIndicator("New");
                th.addTab(ourspec);

                break;

            case R.id.bsw:
                start= System.currentTimeMillis();

                break;

            case R.id.stop:
                stop=System.currentTimeMillis();

                if (start!=0){
                    long result=stop-start;
                    int mills =(int)result;
                    int second= (int)result/1000;
                    int minutes=second/60;
                    mills=mills%100;
                    second=second%60;
                    showresult.setText(String.format("%d:%02d:%02d",minutes,second,mills));

                }

                break;
        }

    }
}
