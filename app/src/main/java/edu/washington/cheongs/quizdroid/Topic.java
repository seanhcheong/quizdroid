package edu.washington.cheongs.quizdroid;

import java.io.Serializable;
import java.util.ArrayList;

public class Topic implements Serializable {
    public String title;
    public String shortDesc;
    public String longDesc;
    public ArrayList<Quiz> questions;
    public ArrayList<Topic> TopicList;


    public Topic(String title, String desc, ArrayList<Quiz> topicOptions) {
        this.title = title;
        this.shortDesc = desc;
        this.questions = topicOptions;

    }

    public String getTitle() {
        return title;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public ArrayList<Quiz> getQuestions() {
        return questions;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShortDesc(String desc) {
        this.shortDesc = desc;
    }

    public void setLongDesc(String desc) {
        this.longDesc = desc;
    }

    public void setQuestions(ArrayList<Quiz> questions) {
        this.questions = questions;
    }
}