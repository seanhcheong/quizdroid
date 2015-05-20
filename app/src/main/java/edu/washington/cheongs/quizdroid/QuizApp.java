package edu.washington.cheongs.quizdroid;

import android.app.Application;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;


    public class QuizApp extends Application implements TopicRepository {

        public ArrayList<Topic> topics;
        public static QuizApp instance;

//        public ArrayList<String> listOfTitles;

        public static void initInstance() {
            if (instance == null) {
                instance = new QuizApp();
            }
        }

//        public ArrayList<String>quizTitles() {
//            return listOfTitles;
//        }
        public static QuizApp getInstance() {
            return instance;
        }

        public ArrayList<Topic> getElements() {
            return topics;
        }

        protected void initialization() {
            QuizApp.initInstance();
        }



        @Override
        public void onCreate() {
            super.onCreate();

            Log.d("QuizApp", "App is running");
            initialization();

            topics = new ArrayList<Topic>();
            String json = null;

            try {
                InputStream inputStream = getAssets().open("questions.json");
                json = readJSONFile(inputStream);

                JSONArray container = new JSONArray(json);
                for (int i = 0; i < container.length(); i++) {
                    String title = container.getJSONObject(i).getString("title");
//                    listOfTitles.add(title);
                    String desc = container.getJSONObject(i).getString("desc");
                    JSONArray questions = container.getJSONObject(i).getJSONArray("Questions");
                    ArrayList<Quiz> topicOptions = new ArrayList<Quiz>();
                    for (int j = 0; j < topicOptions.size(); j++) {
                        String questionAsked = questions.getJSONObject(i).getString("text");
                        int correctAnswer = questions.getJSONObject(i).getInt("answer");
                        JSONArray answerOptions = questions.getJSONObject(i).getJSONArray("answers");
                        String answer1 = answerOptions.getString(0);
                        String answer2 = answerOptions.getString(1);
                        String answer3 = answerOptions.getString(2);
                        String answer4 = answerOptions.getString(3);
                        topicOptions.add(new Quiz(questionAsked, correctAnswer, answer1, answer2, answer3, answer4));
                    }

                    Topic single = new Topic(title, desc, topicOptions);
                    topics.add(single);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public String readJSONFile(InputStream inputStream) throws IOException {
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            return new String(buffer, "UTF-8");
        }
    }

