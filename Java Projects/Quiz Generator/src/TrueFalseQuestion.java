import com.jsoftware.test.api.*;

public class TrueFalseQuestion extends Question implements ITrueFalseQuestion {// extends question class and implements
                                                                               // the TrueFalseQuestion interface
    private boolean solution;// stores the solution

    public TrueFalseQuestion(String inputQuestion, boolean inputSolution) {// constructor
        super(inputQuestion);// passes question to parent constructor
        solution = inputSolution;// solution is initialized
    }

    public String getQuestion() {
        return super.getQuestion();// returns question
    }

    public boolean checkAnswer(boolean answer) {
        if (answer == solution) {// checks if input matches with the stored answer
            return true;
        } else {
            return false;
        }
    }
}
