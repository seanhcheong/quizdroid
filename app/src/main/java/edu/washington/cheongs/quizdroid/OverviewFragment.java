package edu.washington.cheongs.quizdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class OverviewFragment extends Fragment {

    public OverviewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View starter = inflater.inflate(R.layout.activity_overview, container, false);


        final Intent initial = getActivity().getIntent();
        final String topic = initial.getStringExtra("topic");
        TextView title = (TextView) starter.findViewById(R.id.title);
        TextView desc = (TextView) starter.findViewById(R.id.desc);
        TextView num = (TextView) starter.findViewById(R.id.num);

        if (topic.equals("Physics")) {
            title.setText("Welcome to the Physics Quiz!");
            desc.setText("Test your knowledge on some physics trivia!");
            num.setText("Question Count: 3");
        } else if (topic.equals("Math")) {
            title.setText("Welcome to the Math Quiz!");
            desc.setText("Do you think you're smarter than a 5th grader? Test your mathematical skills");
            num.setText("Question Count: 3");
        } else if (topic.equals("Marvel Super Heroes")) {
            title.setText("Welcome to the Marvel Super Heroes Quiz");
            desc.setText("Marvel, Not DC super heroes! Test your knowledge!");
            num.setText("Question Count: 3");
        }

        Button begin = (Button) starter.findViewById(R.id.begin);
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initial.putExtra("topic", topic);
                initial.putExtra("count", 0);
                initial.putExtra("num", 0);

                android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new TestingFragment());
                transaction.commit();

            }
        });

        return starter;
    }
}