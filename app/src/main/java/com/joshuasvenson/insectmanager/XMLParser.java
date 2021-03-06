package com.joshuasvenson.insectmanager;

/**
 * Created by anaso_000 on 9/21/2016.
 */
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Name: XMLParser
Description: This class provides the code for fetching data from the API server Weather underground correponding to
current conditions of the weather according to the coordinates values, latitude and longitude, for each day
starting from the start date given in the API call.
Layout File: No activity
 */
public class XMLParser {

    HttpURLConnection conn;

    // N4n8Rr8T0MmshJsPpTftAFlmgjGEp1fJuQzjsnADtsEG9RFJRR
    // Get you own API Key here: http://www.wunderground.com/weather/api
    static final String API_KEY = "61ed0556abc8b758";

    public XMLParser() {}

    public String getWeatherData(String date, String lat, String lon) {

        String url = "http://api.wunderground.com/api/" + API_KEY
                + "/history_"+date+"/q/"+lat+","+lon+".xml";

        String weatherData = null;

        // Get the XML stream from the web
        try {
            /*HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();*/

            URL url2 = new URL(url);
            conn = (HttpURLConnection) url2.openConnection();
            conn.setRequestMethod("GET");

        } catch (Exception e) {
            Log.e("getWeather", "Error in http connection " + e.toString());
        }

        // Let's convert stream to string
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(conn.getInputStream()), 8);
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = is.readLine()) != null) {
                response.append(inputLine);
            }
            weatherData= response.toString();
        } catch (Exception e) {
            Log.e("getWeather", "Error converting result " + e.toString());
        }
        return weatherData;
    }

    /*
    Name: getMaxTemp
    Description: This method will parse an XML string into Java objects and get the value of the
    maximum temperature in fahrenheit from the XML string
    Paremeters: A string in XML format
    Returns: String with the maximum temperature value from the XML string
    */
    public String getMaxTemp(String weatherData) {

        String maxTemp = null;

        Pattern p = Pattern.compile("<maxtempi>(.*?)</maxtempi>");
        Matcher m = p.matcher(weatherData);
        if (m.find()) {
            maxTemp = m.toMatchResult().group(1);
        }
        return maxTemp;
    }

    /*
    Name: getMinTemp
    Description: This method will parse an XML string into Java objects and get the value of the
    minimum temperature in fahrenheit of a specific day from the XML string
    Paremeters: A string in XML format
    Returns: String with the minimum temperature value from the XML string
    */
    public String getMinTemp(String weatherData) {

        String minTemp = null;

        Pattern p = Pattern.compile("<mintempi>(.*?)</mintempi>");
        Matcher m = p.matcher(weatherData);
        if (m.find()) {
            minTemp = m.toMatchResult().group(1);
        }
        return minTemp;
    }

    /////////////////////////////////////////////////////////////
    // Add methods as needed for addition data retrieval from XML
    /////////////////////////////////////////////////////////////
}

