package com.codetodev.siin;

import android.os.StrictMode;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class ServerConnect {

    String urlServer = "http://android-siin.appspot.com";

    public void login(String username, String password) throws UnsupportedEncodingException {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        StringBuilder text = null;

        try {

            JSONObject dataObject = new JSONObject();
            dataObject.put("username", username);
            dataObject.put("password", password);
            String data = dataObject.toString();

            //Create connection and send data login to server
            URL loginUrl = new URL(urlServer + "/_api/v1/authentication");
            HttpURLConnection conn = (HttpURLConnection) loginUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();

            OutputStream os = new BufferedOutputStream(conn.getOutputStream());
            os.write(data.getBytes());
            os.flush();

            //Get server response data
            String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = br.readLine()) != null) {
                text.append(line).append("\n");
            }

            br.close();
            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (!text.toString().isEmpty()) {
            //Show response
            Log.d(ServerConnect.class.getSimpleName(), text.toString());
        } else {
            Log.d(ServerConnect.class.getSimpleName(), "False!");
        }
    }
}
