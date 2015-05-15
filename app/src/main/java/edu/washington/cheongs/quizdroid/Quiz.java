package edu.washington.cheongs.quizdroid;


public class Quiz {
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int correctOption;

    public Quiz() {

    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }
    public String getAnswer2() {
        return answer2;
    }
    public String getAnswer3() {
        return answer3;
    }
    public String getAnswer4() {
        return answer4;
    }

    public void setAns1(String answer) {
        this.answer1 = answer;
    }

    public void setAns2(String answer) {
        this.answer2 = answer;
    }

    public void setAns3(String answer) {
        this.answer3 = answer;
    }

    public void setAns4(String answer) {
        this.answer4 = answer;
    }

    public void setRightAnswer(int option) {
        this.correctOption = option;
    }


}
