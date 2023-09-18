import com.jsoftware.test.api.*;

abstract class Question implements IQuestion {// Question interface primarily used as a parent not intended to be used
                                              // by itself
    private String question;// stores question

    public Question(String inputQuestion) {
        question = inputQuestion;// intializes question
    }

    public String getQuestion() {
        return question;// returns question
    }
}
