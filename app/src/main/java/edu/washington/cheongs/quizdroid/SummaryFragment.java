package edu.washington.cheongs.quizdroid;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SummaryFragment extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View starter = inflater.inflate(R.layout.activity_summary, container, false);

        final Intent data = getActivity().getIntent();
        final String topic = data.getStringExtra("topic");
        String answer = data.getStringExtra("answer");
        final int count = data.getIntExtra("count", 0);
        int num = data.getIntExtra("num", 0);
        int answerID = data.getIntExtra("answerSelection", 0);

        String answer1 = data.getStringExtra("answer1");
        String answer2 = data.getStringExtra("answer2");
        String answer3 = data.getStringExtra("answer3");
        String answer4 = data.getStringExtra("answer4");

        ArrayList<String> answerOptions = new ArrayList<String>();
        answerOptions.add(answer1);
        answerOptions.add(answer2);
        answerOptions.add(answer3);
        answerOptions.add(answer4);

        // int correctOption = data.getIntExtra("correctOption");

        TextView summary = (TextView) starter.findViewById(R.id.summary);
        TextView chosenAnswer = (TextView) starter.findViewById(R.id.chosenAnswer);
        TextView correctAnswer = (TextView) starter.findViewById(R.id.correctAnswer);
        TextView numCorrect = (TextView) starter.findViewById(R.id.numCorrect);

//        if(count == 1) {
//            correctAnswer.setText(answerOptions.get(correctOption));
//        } else if(count == 2) {
//
//        }
//















        summary.setText(topic);
        chosenAnswer.setText("Your answer was: " + answer);

        if (topic.equals("Physics")) {
            if (count == 1) {
                correctAnswer.setText("Correct Answer: Apple");
            } else if (count == 2) {
                correctAnswer.setText("Correct Answer: 3 Times");
            } else {
                correctAnswer.setText("Correct Answer: 9.8 m/s/s");
            }

            if (answer.equals("Apple") || answer.equals("3 Times") ||
                    answer.equals("9.8 m/s/s")) {
                num++;
            }
        } else if (topic.equals("Math")) {
            if (count == 1) {
                correctAnswer.setText("Correct Answer: 16");
            } else if (count == 2) {
                correctAnswer.setText("Correct Answer: 28");
            } else {
                correctAnswer.setText("Correct Answer: 6");
            }

            if (answer.equals("16") || answer.equals("28") || answer.equals("6")) {
                num++;
            }
        } else {
            if (count == 1) {
                correctAnswer.setText("Correct Answer: Photographer");
            } else if (count == 2) {
                correctAnswer.setText("Correct Answer: Tony Stark");
            } else {
                correctAnswer.setText("Correct Answer: Cosmic Storm");
            }

            if (answer.equals("Photographer") || answer.equals("Tony Stark") ||
                    answer.equals("Cosmic Storm")) {
                num++;
            }
        }

        numCorrect.setText("You have " + num + " out of " + count + " correct");
        final int number = num;

        Button next = (Button) starter.findViewById(R.id.next);
        if (count == 3) {
            next.setText("Finish");
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent restart = new Intent(getActivity(), TopicsList.class);
                    startActivity(restart);
                }
            });
        } else {
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    data.putExtra("topic", topic);
                    data.putExtra("count", count);
                    data.putExtra("num", number);

                    android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, new TestingFragment());
                    transaction.commit();
                }
            });
        }

        return starter;
    }


}
