package edu.washington.cheongs.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class TopicsList extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics_list);
        QuizApp topicsAcquired = (QuizApp)getApplication();
        final ArrayList<Topic> pickOne = topicsAcquired.topics;

        String[] values = new String[pickOne.size()];
        for(int i = 0; i < pickOne.size(); i++) {
            values[i] = pickOne.get(i).getTitle();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, values);
        final ListView listview = (ListView) findViewById(R.id.topics);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent topicOverview = new Intent(TopicsList.this, Fragment.class);
                String topic = QuizApp.getInstance().getElements().get(position).getTitle();
                String longDesc = QuizApp.getInstance().getElements().get(position).getShortDesc();
                topicOverview.putExtra("topic", topic);
                topicOverview.putExtra("desc", longDesc);
                topicOverview.putExtra("listOfTopics", pickOne);
                startActivity(topicOverview);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_topics_list, menu);
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
