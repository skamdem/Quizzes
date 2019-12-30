import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    public static List<Question> quizQuestions;
    public static ArrayList<String> tempList = new ArrayList<>();
    public static ArrayList<String> tempListAnswer = new ArrayList<>();
    public static int score = 0;

    public static boolean checkEquals(ArrayList<String> l1, ArrayList<String> l2){
        if (l1.size() != l2.size()) return false;
        for (String s : l1){
            if (!(l2.contains(s))) return false;
        }
        return true;
    }

    public static void main(String[] args){
        quizQuestions = new ArrayList<>();
        TrueFalseQuestion tf1 = new TrueFalseQuestion("Georges Washington was the US first president", true);
        TrueFalseQuestion tf2 = new TrueFalseQuestion("One plus one equals two", true);
        TrueFalseQuestion tf3 = new TrueFalseQuestion("A minute has 50 seconds", false);

        tempList.add("22");
        tempList.add("24");
        tempList.add("20");
        MultipleChoiceQuestion mc1 = new MultipleChoiceQuestion("Number of hours in a day?", tempList,"24");
        tempList.clear();

        tempList.add("blue");
        tempList.add("green");
        tempList.add("no color");
        MultipleChoiceQuestion mc2 = new MultipleChoiceQuestion("Natural color of water?", tempList,"no color");
        tempList.clear();

        tempList.add("four");
        tempList.add("seven");
        tempList.add("6");
        MultipleChoiceQuestion mc3 = new MultipleChoiceQuestion("Number of days in a week?", tempList,"seven");
        tempList.clear();

        tempList.add("60");
        tempList.add("51");
        tempList.add("50");
        tempList.add("fifty");
        tempListAnswer.add("fifty");
        tempListAnswer.add("50");
        CheckboxQuestion cq1 = new CheckboxQuestion("Number of states in the US?", tempList, tempListAnswer);
        tempList.clear();
        tempListAnswer.clear();

        tempList.add("cyan");
        tempList.add("water");
        tempList.add("muddy");
        tempList.add("red");
        tempListAnswer.add("cyan");
        tempListAnswer.add("red");
        CheckboxQuestion cq2 = new CheckboxQuestion("Select colors among the list?", tempList, tempListAnswer);
        tempList.clear();
        tempListAnswer.clear();

        tempList.add("24");
        tempList.add("2");
        tempList.add("57");
        tempList.add("7");
        tempListAnswer.add("7");
        tempListAnswer.add("2");
        CheckboxQuestion cq3 = new CheckboxQuestion("select prime numbers from the list?", tempList, tempListAnswer);
        tempList.clear();
        tempListAnswer.clear();

        quizQuestions.add(tf1);
        quizQuestions.add(mc1);
        quizQuestions.add(cq1);
        quizQuestions.add(tf2);
        quizQuestions.add(mc2);
        quizQuestions.add(cq2);
        quizQuestions.add(tf3);
        quizQuestions.add(mc3);
        quizQuestions.add(cq3);

        Scanner sc = new Scanner(System.in);
        String input;

        for (Question q : quizQuestions){
            q.printQuestion();
            if ((q instanceof CheckboxQuestion) && !(q instanceof TrueFalseQuestion) && !(q instanceof MultipleChoiceQuestion)){
                System.out.println("Enter the different choices on separate lines and finally type 'Z' to terminate the list");
                input = sc.nextLine();
                ArrayList<String> tempL = new ArrayList<>();
                while (!input.equals("Z")){
                    tempL.add(input);
                    input = sc.nextLine();
                }
                if (checkEquals(tempL, q.getSublistOfCorrectAnswers())) {
                    score++;
                    System.out.println("GOOD");
                }
            } else {
                input = sc.nextLine();
                input = (input.toUpperCase().equals("TRUE") || (input.toUpperCase().equals("FALSE"))) ? input.toUpperCase() : input;
                //System.out.println("You entered: " + input);
                //System.out.println("Correct answer is: "+ q.getSublistOfCorrectAnswers().get(0).toString());
                if (input.equals(q.getSublistOfCorrectAnswers().get(0))) {
                    score++;
                    System.out.println("GOOD");
                }
            }

        }
        System.out.println("You score is: " + score + "/" + quizQuestions.size());
    }
}
