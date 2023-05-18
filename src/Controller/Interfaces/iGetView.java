package Controller.Interfaces;

import java.util.List;
import Model.People.Student;

public interface iGetView {

    /** Provides to user language info */
    String getLanguageInfo();

    /** Show list with Student objects */
    void drawListOfStudents(List<Student> students);

    /** Show message when close the program */
    void exitProgram();

    /** Suggests Enter Command */
    String suggestInputCommand();

    /** Suggests Enter Number */
    int suggestInputNumber();

    /** Suggests Enter Line */
    String suggestInputString(String message);

    /** Suggests Enter Answer to a question */
    boolean suggestInputAnswerToAQuestion();
    
    /** Print result of deleting the student with uniq id */
    void printDeleteInfo(boolean success, long studentID);
}