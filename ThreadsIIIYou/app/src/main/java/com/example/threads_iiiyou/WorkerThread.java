/*
package com.example.threads_iiiyou;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WorkerThread extends AsyncTask<String, Integer, String> {

    private File dataFile;

    public WorkerThread(File dataFile) {
        super();
        this.dataFile = dataFile;

    }

    @Override
    protected String doInBackground(String... str) {
        String enter = "\n";
        FileWriter writer = null;
        try {
            writer = new FileWriter(dataFile, true);
            writer.append(str[0].toString());
            writer.append(enter);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        String data = "";
        StringBuilder stringBuilder = new StringBuilder();

        try {
          FileReader  fileReader = new FileReader(dataFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((data = bufferedReader.readLine()) != null) {
                stringBuilder.append(data);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

*/
