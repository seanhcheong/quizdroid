package edu.washington.cheongs.quizdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class OverviewFragment extends Fragment {

    public OverviewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View starter = inflater.inflate(R.layout.activity_overview, container, false);


        final Intent initial = getActivity().getIntent();
        final String topic = initial.getStringExtra("topic");
        final String description = initial.getStringExtra("desc");

        TextView title = (TextView) starter.findViewById(R.id.title);
        TextView desc = (TextView) starter.findViewById(R.id.desc);
        TextView num = (TextView) starter.findViewById(R.id.num);

        title.setText(topic);
        desc.setText(description);
        num.setText("Question Count: 3");

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