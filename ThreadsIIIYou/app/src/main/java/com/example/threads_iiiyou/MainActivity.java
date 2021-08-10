package com.example.threads_iiiyou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private TextView mTvShowData;
    private EditText mEtPutData;
    private Button mBtnGetData;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        file = new File(getFilesDir(), "data.txt");
        mBtnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = mEtPutData.getText().toString();
                mEtPutData.setText("");
                try {
                    asyncTask.execute(value);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }

    public void initView() {
        mTvShowData = findViewById(R.id.tvDataShow);
        mEtPutData = findViewById(R.id.etData);
        mBtnGetData = findViewById(R.id.btnSave);
    }

    private final AsyncTask<String, Integer, String> asyncTask = new AsyncTask<String, Integer, String>() {
        @Override
        protected String doInBackground(String... strings) {
            String enter = "\n";
            FileWriter writer = null;
            try {
                writer = new FileWriter(file, true);
                writer.append(strings[0].toString());
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
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while ((data = bufferedReader.readLine()) != null) {
                    stringBuilder.append(data);
                }
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mTvShowData.setText(stringBuilder.toString());
        }
    };

}