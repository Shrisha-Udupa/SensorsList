package com.example.android.sensorslist;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    SensorManager sm = null;
    TextView textView = null;
    List <Sensor> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        List <Sensor> sensorList = sm.getSensorList(Sensor.TYPE_ALL);

       /* TextView textView = (TextView) findViewById(R.id.textView);

        for (Sensor s: list) {
            list.add("\n\n" +s.getName());

        }
*/
        ListView list = (ListView) findViewById(R.id.list);

        List <String> sensorNames = new ArrayList();
        for (int i=0; i<sensorList.size(); i++)
            sensorNames.add(((Sensor)sensorList.get(i)).getName());

        ArrayAdapter<String> adapter = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_1, sensorNames);
        list.setAdapter(adapter);




    }
}
