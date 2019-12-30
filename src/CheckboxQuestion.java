import java.util.ArrayList;
@Author (
        author = "Sylvain K",
        date = "12/27/2019",
        currentRevision = 6,
        lastModified = "12/29/2019"
)
public class CheckboxQuestion extends Question {
    public CheckboxQuestion(String questionString,
                            ArrayList<String> setOfPossibleAnswers,
                            ArrayList<String> sublistOfCorrectAnswers){
        this.setQuestionString(questionString);
        this.setSetOfPossibleAnswers(setOfPossibleAnswers);
        this.setSublistOfCorrectAnswers(sublistOfCorrectAnswers);
    }
}
