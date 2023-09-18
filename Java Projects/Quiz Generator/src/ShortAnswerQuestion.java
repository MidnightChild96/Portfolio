import com.jsoftware.test.api.*;
import java.util.*;

public class ShortAnswerQuestion extends Question implements IShortAnswerQuestion {// implements the short answer
                                                                                   // interface and extends the question
                                                                                   // class
    private ArrayList<String> solution;

    public ShortAnswerQuestion(String inputQuestion, String[] inputSolution) {
        super(inputQuestion);// uses the question constructor
        solution = new ArrayList<String>(Arrays.asList(inputSolution));// creates an ArrayList of solutions
    }

    public String getQuestion() {
        return super.getQuestion();// returns the question
    }

    public boolean checkAnswer(String answer) {
        answer = answer.toLowerCase();// converts the input to lowercase
        String[] splitAnswer = answer.split(",");// splits the answer on commas
        int counter = solution.size() - 1;// counts how many answers correct
        for (int i = 0; i < splitAnswer.length; i++) {// loops through the entire array of answers
            for (int j = 0; j < solution.size(); j++) {// loops through the entire array of solutions
                if (splitAnswer[i].equals(solution.get(j))) {
                    counter--;// counts down every time an answer matches with a solution
                }
            }
        }
        if (counter <= 0) {
            return true;// returns true if all answers match the solution
        } else {
            return false;// returns false if not all answers are present
        }
    }

}
