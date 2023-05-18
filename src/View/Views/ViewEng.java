package View.Views;

import java.util.List;

import Model.People.Student;
import View.UIHelper;

public class ViewEng extends UIHelper {

    @Override
    public void exitProgram() {
        System.out.println("Close the program!");
    }

    @Override
    public void drawListOfStudents(List<Student> students) {
        if (super.isData(students)) {
            System.out.println("+---------------------------------------------+");
            System.out.println("|----------- Display students list -----------|");
            super.printListOfStudents(students);
            System.out.println("|------------------ End list -----------------|");
            System.out.println("+---------------------------------------------+");
        } else {
            System.out.println("List of studensts is empty! ...");
        } 
    }

    @Override
    public String suggestInputCommand() {
        System.out.print("Enter command: ");
        return super.suggestInputString();
    }

    @Override
    public int suggestInputNumber() {
        String message = "Enter number";
        String mistakeMessage = "Only numbers allowed! Try again";
        return super.suggestInputNumber(message, mistakeMessage);
    }

    @Override
    public String suggestInputString(String message) {
        System.out.printf("%s: ", message);
        return super.suggestInputString();
    }

    @Override
    public String getLanguageInfo() {
        return "English";
    }

    @Override
    public boolean suggestInputAnswerToAQuestion() {
        String message = "Would you like to continue?";
        return super.suggestInputAnswerToAQuestion(message);
    }

    @Override
    public void printDeleteInfo(boolean success, long studentID) {
        if (success) {
            System.out.printf("Student # %d was deleted.\n", studentID);
        } else {
            System.out.printf("Couldn't delete the student by # %d..\n", studentID);
        }
    }
    
}
