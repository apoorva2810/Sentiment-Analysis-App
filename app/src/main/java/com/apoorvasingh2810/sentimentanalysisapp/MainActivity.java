package com.apoorvasingh2810.sentimentanalysisapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button analyzeSentimentBtn;
    String sentiment;
    private class AskWatsonTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... textsToAnalyze) {

            System.out.println(editText.getText());

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textView.setText("What is happening inside a thread - we are running Watson ALchemyAPI");

                }
            });
            sentiment ="Test Sentiment";
            System.out.println(sentiment);

            return sentiment;
        }

        @Override
        protected void onPostExecute(String result) {
            textView.setText("The message Sentiment is: "+ result);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigning Id's to add parameters

        textView=(TextView)findViewById(R.id.textView);
        editText=(EditText)findViewById(R.id.editText);
        analyzeSentimentBtn=(Button)findViewById(R.id.analyzeSentimentBtn);

        analyzeSentimentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("Logging to the console that the analyzeSentimentBtn pressed for the text : "+ editText);
                textView.setText("Showing sentiment to be checked for : "+ editText.getText());

                AskWatsonTask task= new AskWatsonTask();
                task.execute(new String[]{});
            }
        });
    }
}
