import java.util.*;
import com.jsoftware.test.api.*;

public class FillInBlanksQuestion extends Question implements IFillInBlanksQuestion {// inherits parents and implements
                                                                                     // the FillInBlankQuestion
                                                                                     // interface
    private ArrayList<String> solution;// stores array of answers

    public FillInBlanksQuestion(String inputQuestion, ArrayList<String> inputSolution) {// constructor
        super(inputQuestion);// passes question to parent constructor
        solution = inputSolution;// initializes solution
    }

    public String getQuestion() {
        return super.getQuestion();// returns question
    }

    public boolean checkAnswer(String[] keywords) {
        ArrayList<String> answer = new ArrayList<String>(Arrays.asList(keywords));// converts input array into ArrayList
                                                                                  // class
        for (int i = 0; i < solution.size(); i++) {
            if (!solution.get(i).equals(answer.get(i))) {// checks all inputs and if any do not match it returns false
                return false;
            }
        }
        return true;
    }
}
