package edu.washington.cheongs.quizdroid;

import android.app.Application;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;


    public class QuizApp extends Application {

        public ArrayList<Topic>topics;

        @Override
        public void onCreate() {
            super.onCreate();

            Log.e("QuizApp", "App is running");
            initializeSingletons();

            topics = new ArrayList<Topic>();
            String json = null;

            try {
                InputStream inputStream = getAssets().open("questions.json");
                json = readJSONFile(inputStream);
                
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        private String readJSONFile(InputStream inputStream) {


        }

        protected void initializeSingletons() {
            Singleton.initInstance();
        }


    }

