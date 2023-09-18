import java.util.ArrayList;
import com.jsoftware.test.api.*;

public class MultipleChoiceQuestion extends Question implements IMultipleChoiceQuestion {// inherits question and uses
                                                                                         // the MultipleChoiceQuestion
                                                                                         // interface
    private int answer;// stoers answer
    private ArrayList<String> choices;// stores the multiple choices

    public MultipleChoiceQuestion(String inputQuestion, ArrayList<String> inputChoices, int inputAnswer) {// constructor
        super(inputQuestion);// passes question to parent constructor
        answer = inputAnswer;// initializes answer
        choices = inputChoices;// initializes multiple choices
    }

    public String getQuestion() {
        String answers = "";
        for (int i = 1; i <= choices.size(); i++) {// concatenates the multiple choices with the question
            answers += choices.get(i - 1) + "\n";
        }
        return super.getQuestion() + "\n" + answers;// returns question with it's choices
    }

    public boolean checkAnswer(int index) {// checks if input matches stores answer
        if (index == answer) {
            return true;
        } else {
            return false;
        }
    }
}