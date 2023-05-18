package View;

import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.iGetView;
import Model.People.Student;

public abstract class UIHelper implements iGetView {

    /**
     * Printing list of students
     * 
     * @param students - List<Student> students
     */
    protected void printListOfStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    /**
     * Check if the data exists
     * 
     * @param students - List<Student> students
     * @return boolean it contains
     */
    protected boolean isData(List<Student> students) {
        if (students.isEmpty())
            return false;
        return true;
    }

    /**
     * Suggests to user enter smth.
     * 
     * @return String user term
     */
    protected String suggestInputString() {
        Scanner iScanner = new Scanner(System.in);
        return iScanner.nextLine();
    }

    /**
     * Suggests to user enter number
     * 
     * @param message        - rule message
     * @param mistakeMessage - wrong input message
     * @return int number
     */
    protected int suggestInputNumber(String message, String mistakeMessage) {
        Scanner iScanner = new Scanner(System.in);
        boolean isCorrect = false;
        int number = -1;

        System.out.printf("%s: ", message);

        while (!isCorrect) {
            if (iScanner.hasNextInt()) {
                number = iScanner.nextInt();
                isCorrect = true;
            } else {
                iScanner.next();
                System.out.printf("%s: ", mistakeMessage);
            }
        }
        return number;
    }

    /**
     * Asks user a question and
     * suggests to enter an answer
     * 
     * @param message - question
     * @return bolean answer
     */
    protected boolean suggestInputAnswerToAQuestion(String message) {
        System.out.printf("%s Y/n: ", message);
        String answer = this.suggestInputString();
        if (answer.equals("Y") || answer.equals("y"))
            return true;
        return false;
    }
}
