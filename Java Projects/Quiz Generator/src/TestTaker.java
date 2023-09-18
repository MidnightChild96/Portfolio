import java.util.*;

public class TestTaker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);// stores user input
        String testName;// stores name of test
        QuestionFactory factory = new QuestionFactory();// creates instance of the question factory
        QuestionSet test;// stores the set of questions
        String userinput;// used for user answers
        int score = 0;// stores the correct amount of questions gotten
        System.out.println("Welcome to the TestTaker program!");
        System.out.println("What test would you like to take?");
        testName = input.nextLine();// initializes the test name
        test = (QuestionSet) factory.load(testName);// loads the test
        System.out.println("Enter 1 to take a whole test or 2 to take a sample test.");
        int choice = input.nextInt();// asks for sample or entire test
        input.nextLine();
        if (choice == 2) {// sample is the only option that matters
            System.out.println("How many questions would you like?");
            int size = input.nextInt();// used to create bound for the sample
            input.nextLine();
            test = (QuestionSet) test.randomSample(size);// creates a new randomized question set
        }
        System.out.println("--------------------\nThe test starts now!\n--------------------");
        for (int i = 0; i < test.size(); i++) {// loops through all the questions
            System.out.print(test.getQuestion(i).getQuestion());
            System.out.print("Your answer: ");
            userinput = input.nextLine();
            if (test.getQuestion(i) instanceof MultipleChoiceQuestion) {
                MultipleChoiceQuestion mcQuestion = (MultipleChoiceQuestion) test.getQuestion(i);// casts the question
                                                                                                 // if it is a multiple
                                                                                                 // choice
                if (mcQuestion.checkAnswer(Integer.parseInt(userinput)) == true) {// if solution is correct increases
                                                                                  // score while incorrect does nothing
                    score++;
                    System.out.println("You got it!");
                } else {
                    System.out.println("Wrong!");
                }
            }
            if (test.getQuestion(i) instanceof TrueFalseQuestion) {
                TrueFalseQuestion tfQuestion = (TrueFalseQuestion) test.getQuestion(i);// casts the question to true or
                                                                                       // false
                if (tfQuestion.checkAnswer(Boolean.valueOf(userinput)) == true) {// if solution is correct increases
                                                                                 // score while incorrect does nothing
                    score++;
                    System.out.println("You got it!");
                } else {
                    System.out.println("Wrong!");
                }
            }
            if (test.getQuestion(i) instanceof FillInBlanksQuestion) {
                FillInBlanksQuestion fbQuestion = (FillInBlanksQuestion) test.getQuestion(i);// casts the question to
                                                                                             // fill in the blank
                if (fbQuestion.checkAnswer(userinput.split(",")) == true) {// if solution is correct increases score
                                                                           // while incorrect does nothing
                    score++;
                    System.out.println("You got it!");
                } else {
                    System.out.println("Wrong!");
                }
            }
            if (test.getQuestion(i) instanceof ShortAnswerQuestion) {
                ShortAnswerQuestion saQuestion = (ShortAnswerQuestion) test.getQuestion(i);// casts the question to
                                                                                           // short answer
                if (saQuestion.checkAnswer(userinput) == true) {// if solution is correct increases score while
                                                                // incorrect does nothing
                    score++;
                    System.out.println("You got it!");
                } else {
                    System.out.println("Wrong!");
                }
            }
        }
        System.out.println("You got " + score + " right out of " + test.size() + " questions total.");// prints out how
                                                                                                      // many correctly
                                                                                                      // answered
                                                                                                      // questions
        input.close();
    }
}
