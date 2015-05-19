package edu.washington.cheongs.quizdroid;


import java.util.ArrayList;

public class Singleton implements TopicRepository {
    public ArrayList<Topic> topics;
    private static Singleton instance;

    public static void initInstance() {
        if (instance == null)
        {
            instance = new Singleton();
        }
    }

    public static Singleton getInstance() {
        return instance;
    }

    private Singleton() {

    }


    public ArrayList<Topic> getElements() {
        topics = new ArrayList<>();

        Topic physics = new Topic();
        Topic math = new Topic();
        Topic marvel = new Topic();

        Quiz physicsQ1 = new Quiz();
        Quiz physicsQ2 = new Quiz();
        Quiz physicsQ3 = new Quiz();

        Quiz mathQ1 = new Quiz();
        Quiz mathQ2 = new Quiz();
        Quiz mathQ3 = new Quiz();

        Quiz marvelQ1 = new Quiz();
        Quiz marvelQ2 = new Quiz();
        Quiz marvelQ3 = new Quiz();

        physics.setTitle("Physics");
        physics.setShortDesc("The effects of Gravity and more!");
        physics.setLongDesc("The branch of science concerned with the nature and properties of matter and energy. ");

        math.setTitle("Math");
        math.setShortDesc("Adding, subtracting, and more!");
        math.setLongDesc("The abstract science of number, quantity, and space. Mathematics may be studied in its own right");

        marvel.setTitle("Marvel Super Heroes");
        marvel.setShortDesc("Marvel Super Heroes, not DC");
        marvel.setLongDesc("Benevolent fictional characters with superhuman powers, such as Thor.");

        physicsQ1.setQuestion("What fruit fell on Isaac Newton's head? ");
        physicsQ2.setQuestion("How much hotter is a lightning bolt compared to the Sun? ");
        physicsQ3.setQuestion("What is the acceleration of gravity on Earth? ");

        physicsQ1.setAns1("Apple");
        physicsQ1.setAns2("Orange");
        physicsQ1.setAns3("Banana");
        physicsQ1.setAns4("Kiwi");
        physicsQ1.setRightAnswer(0);

        physicsQ2.setAns1("2 Times");
        physicsQ2.setAns2("8 Times");
        physicsQ2.setAns3("3 Times");
        physicsQ2.setAns4("None of the above");
        physicsQ2.setRightAnswer(2);

        physicsQ3.setAns1("9.4 m/s/s");
        physicsQ3.setAns2("8.6 m/s/s");
        physicsQ3.setAns3("9.8 m/s/s");
        physicsQ3.setAns4("10.6 m/s/s");
        physicsQ3.setRightAnswer(2);

        ArrayList<Quiz> physicsQs = new ArrayList<>();
        physicsQs.add(physicsQ1);
        physicsQs.add(physicsQ2);
        physicsQs.add(physicsQ3);
        physics.setQuestions(physicsQs);

        mathQ1.setQuestion("What is the sum of 6 and 10? ");
        mathQ2.setQuestion("What is the product of 7 and 4? ");
        mathQ3.setQuestion("What is 12 minus 6? ");

        mathQ1.setAns1("13");
        mathQ1.setAns2("16");
        mathQ1.setAns3("12");
        mathQ1.setAns4("2");
        mathQ1.setRightAnswer(1);

        mathQ2.setAns1("12");
        mathQ2.setAns2("43");
        mathQ2.setAns3("24");
        mathQ2.setAns4("28");
        mathQ2.setRightAnswer(3);

        mathQ3.setAns1("5");
        mathQ3.setAns2("6");
        mathQ3.setAns3("7");
        mathQ3.setAns4("8");
        mathQ3.setRightAnswer(1);

        ArrayList<Quiz> mathQs = new ArrayList<>();
        mathQs.add(mathQ1);
        mathQs.add(mathQ2);
        mathQs.add(mathQ3);
        math.setQuestions(mathQs);

        marvelQ1.setQuestion("What is the occupation of Peter Parker? ");
        marvelQ2.setQuestion("What is Iron Man's true secret identity? ");
        marvelQ3.setQuestion("What gave Mr. Fantastic his super powers? ");

        marvelQ1.setAns1("Chef");
        marvelQ1.setAns2("Boxer");
        marvelQ1.setAns3("Scientist");
        marvelQ1.setAns4("Photographer");
        marvelQ1.setRightAnswer(3);

        marvelQ2.setAns1("Bill Nye, the Science guy");
        marvelQ2.setAns2("Ned Stark");
        marvelQ2.setAns3("Tony Stark");
        marvelQ2.setAns4("Bart Simpson");
        marvelQ2.setRightAnswer(2);

        marvelQ3.setAns1("RadioActive Apple");
        marvelQ3.setAns2("Sleep Deprivation");
        marvelQ3.setAns3("Cosmic Storm");
        marvelQ3.setAns4("Gifted by parents");
        marvelQ3.setRightAnswer(2);

        ArrayList<Quiz> marvelQ = new ArrayList<>();
        marvelQ.add(marvelQ1);
        marvelQ.add(marvelQ2);
        marvelQ.add(marvelQ3);
        marvel.setQuestions(marvelQ);

        topics.add(0, physics);
        topics.add(1, math);
        topics.add(2, marvel);

        return topics;
    }
}

