package com.example.administrator.wjshim;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016-08-13.
 */
public class OpenWeatherAPIClient {

    final static String openWeatherURL = "http://api.openweathermap.org/data/2.5/weather";
    final static String openWeatherKey ="1e5c0351a8b4cf2e91c917abe26f0c92";
    //이미지 경로
    final static String OPEN_WEATHER_PNG = "http://openweathermap.org/img/w/";
    public Weather getWeather(int lat, int lon){
        Weather w = new Weather();
        String urlString = openWeatherURL + "?lat="+lat + "&lon="+lon+"&APPID="+openWeatherKey;

        try{
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            JSONObject json = new JSONObject(getStringFromInputStream(in));

            // parse JSON
            w = parseJSON(json);
            w.setIon(lon);
            w.setLat(lat);
        }catch(MalformedURLException e){
            System.err.println("Malformed URL");
            e.printStackTrace();
            return null;

        }catch(JSONException e) {
            System.err.println("JSON parsing error");
            e.printStackTrace();
            return null;
        }catch(IOException e){
            System.err.println("URL Connection failed");
            e.printStackTrace();
            return null;
        }
        return w;
    }
    private Weather parseJSON(JSONObject json) throws JSONException {
        Weather w = new Weather();
        w.setTemprature(json.getJSONObject("main").getInt("temp"));
        w.setImg(OPEN_WEATHER_PNG+json.getJSONObject("weather").getString("icon")+".png");
        w.setCity(json.getString("name"));
        //w.setCloudy();

        return w;
    }

    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }
}
