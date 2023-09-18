import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import com.jsoftware.test.api.*;

public class QuestionFactory implements IQuestionFactory {
    ArrayList<String> writeAssist = new ArrayList<String>();// used primarily for storing answer key

    public IQuestion makeMultipleChoice(String question, String[] choices, int answer) {// creates an instance of
                                                                                        // multiple choice object
        MultipleChoiceQuestion newQuestion = new MultipleChoiceQuestion(question,
                new ArrayList<String>(Arrays.asList(choices)), answer);// creates a new instance
        writeAssist.add("MultipleChoice," + String.valueOf(answer));// adds answer and category
        return newQuestion;// returns the object
    }

    public IQuestion makeTrueFalse(String question, boolean answer) {// creates a true or false question
        TrueFalseQuestion newQuestion = new TrueFalseQuestion(question, answer);// creaets an instance of the true false
                                                                                // question object
        writeAssist.add("TrueFalse," + String.valueOf(answer));// stores answer and cateogry
        return newQuestion;// returns the object
    }

    public IQuestion makeFillInBlank(String question, String[] keywords) {// creates a fill in the blank question
        FillInBlanksQuestion newQuestion = new FillInBlanksQuestion(question,
                new ArrayList<String>(Arrays.asList(keywords)));// creates an instance of the FillinBlanksQuestion
                                                                // object
        String combinedSolution = "";// used to store the several solutions
        for (int i = 0; i < keywords.length; i++) {// concatenates the solution into a single string
            if (i == keywords.length - 1) {
                combinedSolution += keywords[i];
            } else {
                combinedSolution += keywords[i] + ",";
            }
        }
        writeAssist.add("FillInBlank," + keywords.length + "," + combinedSolution);// stores answer and category
        return newQuestion;// reutrns object
    }

    public IQuestion makeShortAnswer(String question, String[] answer) {// creates a short answer question
        ShortAnswerQuestion newQuestion = new ShortAnswerQuestion(question, answer);// creates an instance
        String combinedSolution = "";// used to store the several answers
        for (int i = 0; i < answer.length; i++) {// concaenates the array of answers into a string
            if (i == answer.length - 1) {
                combinedSolution += answer[i];
            } else {
                combinedSolution += answer[i] + ",";
            }
        }
        writeAssist.add("ShortAnswer," + answer.length + "," + combinedSolution);// stores category and solution
        return newQuestion;// returns object
    }

    public IQuestionSet load(String filename) {// reads the set of questions
        QuestionSet test = new QuestionSet();// creates a new instance of QuestionSet
        String[] splitLine;// used to split user input
        String choice;// used to separate categories for questions
        String question;// stores the question
        try {
            File inputFile = new File(filename);// creates an instance of the file
            Scanner reader = new Scanner(inputFile);// reads the file
            while (reader.hasNextLine()) {
                splitLine = reader.nextLine().split(",");// splits the string on commas
                choice = splitLine[0];// the first element is always the category of question
                switch (choice) {
                    case "MultipleChoice":
                        MultipleChoiceQuestion mcQuestion;// initializes multiple choice
                        ArrayList<String> options = new ArrayList<String>();// stores the choices
                        question = splitLine[2];// third element always the question
                        for (int i = 3; i < 7; i++) {// numbers all the choices for flavor
                            options.add(i - 2 + ")" + splitLine[i]);
                        }
                        mcQuestion = new MultipleChoiceQuestion(question, options, Integer.parseInt(splitLine[1]));// creates
                                                                                                                   // a
                                                                                                                   // instance
                                                                                                                   // with
                                                                                                                   // inputs
                        test.add(mcQuestion);// adds the question to the array
                        break;
                    case "TrueFalse":
                        question = splitLine[2];// the third element is always the question
                        TrueFalseQuestion tfQuestion = new TrueFalseQuestion(question, Boolean.valueOf(splitLine[1]));// creates
                                                                                                                      // an
                                                                                                                      // instance
                                                                                                                      // with
                                                                                                                      // inputs
                        test.add(tfQuestion);// adds question to the array
                        break;
                    case "FillInBlank":
                        FillInBlanksQuestion fbQuestion;// initializes object
                        question = splitLine[splitLine.length - 1];// question is always the last element
                        ArrayList<String> fbSolution = new ArrayList<String>();// stores the array of solutions
                        for (int i = 2; i < splitLine.length - 1; i++) {// goes through string to store the solutions
                            fbSolution.add(splitLine[i]);
                        }
                        fbQuestion = new FillInBlanksQuestion(question, fbSolution);// creates an instance
                        test.add(fbQuestion);// stores the question
                        break;
                    case "ShortAnswer":
                        ShortAnswerQuestion saQuestion;// initializes object
                        question = splitLine[splitLine.length - 1];// question is always the last element
                        String[] saSolutions = new String[Integer.parseInt(splitLine[1])];// parses an int stating how
                                                                                          // many answers there are
                        for (int i = 2; i < splitLine.length - 2; i++) {// loops through all the solutions
                            saSolutions[i - 2] = splitLine[i];
                        }
                        saQuestion = new ShortAnswerQuestion(question, saSolutions);// creates and instance
                        test.add(saQuestion);// stores question
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        }
        System.out.println("Test loaded successful!");
        return test;// returns the array
    }

    public boolean save(IQuestionSet testSet, String filename) {
        try {
            FileWriter writer = new FileWriter(filename);// writes to the file
            String inputQuestion[];// takes in the questions
            String newString = "";// used to store the line to be written
            for (int i = 0; i < testSet.size(); i++) {// loops through entire array
                if (testSet.getQuestion(i) instanceof MultipleChoiceQuestion) {// multiple choice is unique since it
                                                                               // requires storing the list of choices
                                                                               // which have new line characters
                    inputQuestion = testSet.getQuestion(i).getQuestion().split("\n");
                    for (int j = 0; j < inputQuestion.length; j++) {
                        if (j == inputQuestion.length - 1) {
                            newString += inputQuestion[j];
                        } else {// stores all questions ending with a comma
                            newString += inputQuestion[j] + ",";
                        }
                    }
                    writer.write(writeAssist.get(i) + "," + newString + "\n");
                } else {
                    writer.write(writeAssist.get(i) + "," + testSet.getQuestion(i).getQuestion() + "\n");// stores the
                                                                                                         // question
                                                                                                         // with the
                                                                                                         // category and
                                                                                                         // solution
                                                                                                         // separated by
                                                                                                         // commas
                }

            }
            writer.close();
            System.out.println("Test saved.");
            return true;
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
            return false;
        }
    }

    public IQuestionSet makeEmptyQuestionSet() {
        return new QuestionSet();// returns a new instance
    }

    public void remove(int index) {
        writeAssist.remove(index);// uses ArrayList method
    }
}
