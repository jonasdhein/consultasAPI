package com.example.consultasapi;

import android.os.AsyncTask;
import android.os.Build;
import android.text.Html;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiTask extends AsyncTask<String, Void, String> {

    private TextView textView;

    public ApiTask(TextView text) {
        this.textView = text;
    }

    @Override
    protected String doInBackground(String... params) {

        Api api = new Api();
        String retorno = new String("");
        String body_json = new String("");

        String method = params[0].trim();

        String url_api = params[1].replaceAll(" ", "%20");
        if(params.length > 2) {
            body_json = params[2];
        }

        if(method.equals("post")){
            retorno = api.post(url_api, body_json);
        }else if(method.equals("get")){
            retorno = api.get(url_api);
        }

        return retorno;
    }

    @Override
    protected void onPostExecute(String s) {

        try {
            JSONObject jsonRequest = new JSONObject(s);



        } catch (JSONException ex) {
            ex.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }


    }
}