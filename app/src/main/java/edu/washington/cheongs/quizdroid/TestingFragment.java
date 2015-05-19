package edu.washington.cheongs.quizdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.ArrayList;


public class TestingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View starter = inflater.inflate(R.layout.activity_testing, container, false);

        final Intent data = getActivity().getIntent();
        final String topic = data.getStringExtra("topic");
        final int count = data.getIntExtra("count", 0);
        final int num = data.getIntExtra("num", 0);
        TextView question = (TextView) starter.findViewById(R.id.question);
        TextView answer1 = (TextView) starter.findViewById(R.id.answer1);
        TextView answer2 = (TextView) starter.findViewById(R.id.answer2);
        TextView answer3 = (TextView) starter.findViewById(R.id.answer3);
        TextView answer4 = (TextView) starter.findViewById(R.id.answer4);

        ArrayList<Topic> selection = Singleton.getInstance().getElements();

        if (topic.equals("Physics")) {
            ArrayList<Quiz> selectedQuiz = selection.get(0).getQuestions();
            question.setText(selectedQuiz.get(count).getQuestion());
            answer1.setText(selectedQuiz.get(count).getAnswer1());
            answer2.setText(selectedQuiz.get(count).getAnswer2());
            answer3.setText(selectedQuiz.get(count).getAnswer3());
            answer4.setText(selectedQuiz.get(count).getAnswer4());

        } else if (topic.equals("Math")) {
            ArrayList<Quiz> selectedQuiz = selection.get(1).getQuestions();
            question.setText(selectedQuiz.get(count).getQuestion());
            answer1.setText(selectedQuiz.get(count).getAnswer1());
            answer2.setText(selectedQuiz.get(count).getAnswer2());
            answer3.setText(selectedQuiz.get(count).getAnswer3());
            answer4.setText(selectedQuiz.get(count).getAnswer4());
        } else {
            ArrayList<Quiz> selectedQuiz = selection.get(2).getQuestions();
            question.setText(selectedQuiz.get(count).getQuestion());
            answer1.setText(selectedQuiz.get(count).getAnswer1());
            answer2.setText(selectedQuiz.get(count).getAnswer2());
            answer3.setText(selectedQuiz.get(count).getAnswer3());
            answer4.setText(selectedQuiz.get(count).getAnswer4());
        }

        TextView quizType = (TextView) starter.findViewById(R.id.quizTitle);
        quizType.setText(topic + " Question #" + (count + 1));

        Button submit = (Button) starter.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup radio = (RadioGroup) starter.findViewById(R.id.radio);
                int radioId = radio.getCheckedRadioButtonId();
                if (radioId != -1) {
                    TextView checkedButton = (TextView) starter.findViewById(radioId);
                    data.putExtra("topic", topic);
                    data.putExtra("answer", checkedButton.getText());
                    data.putExtra("count", count + 1);
                    data.putExtra("num", num);

                    android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, new SummaryFragment());
                    transaction.commit();
                }
            }
        });
        return starter;
    }
}
