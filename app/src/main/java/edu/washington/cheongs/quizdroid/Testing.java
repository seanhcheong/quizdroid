package edu.washington.cheongs.quizdroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.RadioGroup;
import android.widget.TextView;


import java.util.ArrayList;


public class Testing extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);

        ArrayList<String> physicsTrivia = new ArrayList<String>();
        physicsTrivia.add("What fruit fell on Isaac Newton's head? ");
        physicsTrivia.add("How much hotter is a lightning bolt compared to the Sun? ");
        physicsTrivia.add("What is the acceleration of gravity on Earth? ");

        ArrayList<String> mathTrivia = new ArrayList<String>();
        mathTrivia.add("What is the sum of 6 and 10? ");
        mathTrivia.add("What is the product of 7 and 4? ");
        mathTrivia.add("What is 12 minus 6? ");

        ArrayList<String> marvelTrivia = new ArrayList<String>();
        marvelTrivia.add("What is the occupation of Peter Parker? ");
        marvelTrivia.add("What is Iron Man's true secret identity? ");
        marvelTrivia.add("What gave Mr. Fantastic his super powers? ");

        ArrayList<String> physicsAnswer = new ArrayList<>();
        // Answers - Q1 for Physics
        physicsAnswer.add("Apple");
        physicsAnswer.add("Orange");
        physicsAnswer.add("Banana");
        physicsAnswer.add("Kiwi");
        // Answers - Q2 for Physics
        physicsAnswer.add("2 Times");
        physicsAnswer.add("8 Times");
        physicsAnswer.add("3 Times");
        physicsAnswer.add("None of the above");
        // Answers - Q3 for Physics
        physicsAnswer.add("9.4 m/s/s");
        physicsAnswer.add("8.6 m/s/s");
        physicsAnswer.add("9.8 m/s/s");
        physicsAnswer.add("10.6 m/s/s");

        ArrayList<String> mathAnswer = new ArrayList<>();
        // Answers - Q1 for Math
        mathAnswer.add("13");
        mathAnswer.add("16");
        mathAnswer.add("12");
        mathAnswer.add("2");
        // Answers - Q2 for Math
        mathAnswer.add("12");
        mathAnswer.add("43");
        mathAnswer.add("24");
        mathAnswer.add("28");
        // Answers - Q3 for Math
        mathAnswer.add("5");
        mathAnswer.add("6");
        mathAnswer.add("7");
        mathAnswer.add("8");

        ArrayList<String> marvelAnswer = new ArrayList<>();
        // Answers - Q1 for Marvel Super Heroes
        marvelAnswer.add("Chef");
        marvelAnswer.add("Boxer");
        marvelAnswer.add("Scientist");
        marvelAnswer.add("Photographer");
        // Answers - Q2 for Marvel Super Heroes
        marvelAnswer.add("Bill Nye, the Science guy");
        marvelAnswer.add("Ned Stark");
        marvelAnswer.add("Tony Stark");
        marvelAnswer.add("Bart Simpson");
        // Answers - Q3 for Marvel Super Heroes
        marvelAnswer.add("RadioActive Apple");
        marvelAnswer.add("Sleep Deprivation");
        marvelAnswer.add("Cosmic Storm");
        marvelAnswer.add("Gifted by parents");

        Intent data = getIntent();
        final String topic = data.getStringExtra("topic");
        final int count = data.getIntExtra("count", 0);
        final int num = data.getIntExtra("num", 0);
        TextView question = (TextView) findViewById(R.id.question);
        TextView answer1 = (TextView) findViewById(R.id.answer1);
        TextView answer2 = (TextView) findViewById(R.id.answer2);
        TextView answer3 = (TextView) findViewById(R.id.answer3);
        TextView answer4 = (TextView) findViewById(R.id.answer4);

        if (topic.equals("Physics")) {
            question.setText(physicsTrivia.get(count));
            answer1.setText(physicsAnswer.get(4 * count));
            answer2.setText(physicsAnswer.get(4 * count + 1));
            answer3.setText(physicsAnswer.get(4 * count + 2));
            answer4.setText(physicsAnswer.get(4 * count + 3));
        } else if (topic.equals("Math")) {
            question.setText(mathTrivia.get(count));
            answer1.setText(mathAnswer.get(4 * count));
            answer2.setText(mathAnswer.get(4 * count + 1));
            answer3.setText(mathAnswer.get(4 * count + 2));
            answer4.setText(mathAnswer.get(4 * count + 3));
        } else {
            question.setText(marvelTrivia.get(count));
            answer1.setText(marvelAnswer.get(4 * count));
            answer2.setText(marvelAnswer.get(4 * count + 1));
            answer3.setText(marvelAnswer.get(4 * count + 2));
            answer4.setText(marvelAnswer.get(4 * count + 3));
        }
        TextView quizType = (TextView) findViewById(R.id.quizTitle);
        quizType.setText(topic + " Question #" + (count + 1));
        Button submit = (Button) findViewById(R.id.submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup radio = (RadioGroup) findViewById(R.id.radio);
                int radioId = radio.getCheckedRadioButtonId();
                // Only move on if a valid radio button has been selected
                if (radioId != -1) {
                    Intent answerCheck = new Intent(Testing.this, Summary.class);
                    TextView checkedButton = (TextView) findViewById(radioId);
                    answerCheck.putExtra("topic", topic);
                    answerCheck.putExtra("answer", checkedButton.getText());
                    answerCheck.putExtra("count", count + 1);
                    answerCheck.putExtra("num", num);
                    startActivity(answerCheck);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_testing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}