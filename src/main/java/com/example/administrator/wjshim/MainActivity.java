package com.example.administrator.wjshim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // MapView 참고 http://seuny.tistory.com/14
    public void getWeather(View view)
    {
        EditText tvLon = (EditText) findViewById(R.id.lon);
        String strLon = tvLon.getText().toString();
        int lon = Integer.parseInt(strLon);

        EditText tvLat = (EditText) findViewById(R.id.lat);
        String strLat = tvLat.getText().toString();
        int lat = Integer.parseInt(strLat);


        // 날씨를 읽어오는 API 호출
        OpenWeatherAPITask t= new OpenWeatherAPITask();
        try {
            Weather w = t.execute(lon,lat).get();

            System.out.println("Temp :"+w.getTemprature());
            System.out.println("City :"+w.getCity());
            System.out.println("IMG :"+w.getImg());

            TextView tem = (TextView)findViewById(R.id.tem);
            String temperature = String.valueOf(w.getTemprature());

            tem.setText(temperature);
            //w.getTemprature());


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }



}
