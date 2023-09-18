import java.util.Scanner;

public class TestMaker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);// takes user input
        int choice;//// used for menu options
        boolean menuLoop = true;// loops through the menu
        String filename;// stores name of file
        String question;// stores the question
        QuestionFactory factory = new QuestionFactory();// instantiates the question factory
        QuestionSet test = new QuestionSet();// instantiates the set of questions
        System.out.println("Welcome to TestMaker program!");
        System.out.println("What would you like to call this test?");
        filename = input.nextLine();// takes in name of the test
        while (menuLoop == true) {
            System.out.println(
                    "What would you like to do?\n1)add a multiple-choice question\n2)add a true/false question\n3)add a fill-in the blank question\n4)add short answer question\n5)remove a question\n6)exit program");
            choice = input.nextInt();// takes in the menu option
            input.nextLine();
            switch (choice) {
                case 1:// creates a multiple choice question
                    String[] options = new String[4];// all multiple choice questions bounded to 4 choices
                    String[] position = { "first", "second", "third", "fourth" };// used to display text for flavor
                    System.out.println("What is your multipe-choice question?");
                    question = input.nextLine();// first input is the question
                    for (int i = 0; i < 4; i++) {// loops for all choices
                        if (i == 3) {
                            System.out.print("please enter your " + position[i] + " and last choice: ");
                            options[i] = input.nextLine();
                        } else {
                            System.out.print("Please enter your " + position[i] + " choice: ");
                            options[i] = input.nextLine();
                        }
                    }
                    System.out.println("What choice was the answer?");
                    int mcAnswer = input.nextInt();// stores solution
                    input.nextLine();
                    test.add(factory.makeMultipleChoice(question, options, mcAnswer));// creates object and adds it to
                                                                                      // the array
                    break;
                case 2:
                    System.out.println("What is your True/False question?");
                    question = input.nextLine();// stores question
                    System.out.println("What is the answer?");
                    boolean tfAnswer = Boolean.valueOf(input.nextLine());// stores the answer
                    test.add(factory.makeTrueFalse(question, tfAnswer));// creates object and adds it to array
                    break;
                case 3:
                    System.out.println("What is your fill in the blank question?");
                    question = input.nextLine();// stores question
                    System.out.println("What is the answer? Please separate answers with a comma");
                    String[] blanksAnswers = input.nextLine().toLowerCase().split(",");// stores answers and separates
                                                                                       // it on commas
                    test.add(factory.makeFillInBlank(question, blanksAnswers));// creates object and adds it to array
                    break;
                case 4:
                    System.out.println("What is your short answer question?");
                    question = input.nextLine();// stores question
                    System.out.println("How many keywords does your short answer question have?");
                    int size = input.nextInt();// determines how many answers there are
                    input.nextLine();
                    String[] shortAnswers = new String[size];// initalizes an array for the answers
                    for (int i = 0; i < size; i++) {
                        System.out.println("What is a keyword in your short answer question?");
                        shortAnswers[i] = input.nextLine().toLowerCase();// converts all answers to lowercase and stores
                                                                         // it
                    }
                    test.add(factory.makeShortAnswer(question, shortAnswers));// creates object and adds it to arra
                    break;
                case 5:
                    System.out.println("Select the index of the question you would like to remove");
                    int index = input.nextInt();// stores what question to remove
                    input.nextLine();
                    test.remove(index);// removes the question
                    factory.remove(index);// removes the solution
                    break;
                case 6:
                    menuLoop = false;// leaves the menu
                    break;
                default:
                    System.out.println("That is not an option please try again!");// if choice is out of bounds
            }
        }
        factory.save(test, filename);// saves questions and answers to a text file
        input.close();
        System.out.println("Goodybye!");
    }
}