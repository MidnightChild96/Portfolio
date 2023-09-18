import com.jsoftware.test.api.*;
import java.util.*;

public class QuestionSet implements IQuestionSet {// primarily stores the set of questions and generates them
    ArrayList<IQuestion> questionSet = new ArrayList<IQuestion>();// stores the questions

    public IQuestionSet emptyTestSet() {
        questionSet.clear();// uses ArrayList built in method to clear
        return this;// returns this object
    }

    public IQuestionSet randomSample(int size) {
        if (size > questionSet.size()) {// returns current set if the bound is outside the size of the test
            System.out.println("There is not enough questions without repeating!");
            return this;
        } else {
            QuestionSet sample = new QuestionSet();// creates a new object to store a smaller sample
            HashSet<Integer> randomNumbers = new HashSet<Integer>();// used to ensure unique numbers
            Random numGen = new Random();// generates random numbers
            for (int i = 0; i < size; i++) {// loops until target sample size is reached
                while (true) {// generates random numbers until one is not used already
                    int num = numGen.nextInt(questionSet.size() - 1);
                    if (randomNumbers.contains(num) == false) {
                        randomNumbers.add(num);// adds to list of random numbers
                        break;
                    }

                }
            }
            Iterator<Integer> it = randomNumbers.iterator();// used to iterate through list of random numbers

            while (it.hasNext()) {
                sample.add(questionSet.get(it.next()));// adds question to the new sample
            }
            return sample;// returns the new sample set
        }
    }

    public boolean remove(int index) {// removes question
        if (index >= questionSet.size()) {// cannot remove question if out ouf bounds
            return false;
        } else {
            questionSet.remove(index);// uses ArrayList built in function to remove
            return true;
        }
    }

    public IQuestion getQuestion(int index) {
        if (index >= questionSet.size()) {// if question is out of bounds returns a null
            System.out.println("That is out of bounds");
            return null;
        } else {
            return questionSet.get(index);// returns using ArrayList's method
        }
    }

    public int size() {
        return questionSet.size();// returns ArrayList method
    }

    public boolean add(IQuestion question) {
        questionSet.add(question);// adds a question object to the array should never end in false
        return true;
    }
}
