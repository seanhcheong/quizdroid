package edu.washington.cheongs.quizdroid;

import android.app.Application;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;


    public class QuizApp extends Application {

        @Override
        public void onCreate() {
            super.onCreate();

            Log.i("QuizApp", "App is running");
            initializeSingletons();
        }

        protected void initializeSingletons() {
            Singleton.initInstance();
        }


    }

