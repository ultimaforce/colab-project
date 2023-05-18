package View.Views;

import java.util.List;
import Model.People.Student;
import View.UIHelper;

public class ViewRus extends UIHelper {

    @Override
    public void exitProgram() {
        System.out.println("Выход из программы!");
    }

    @Override
    public void drawListOfStudents(List<Student> students) {
        if (super.isData(students)) {
            System.out.println("+----------------------------------------------+");
            System.out.println("|----------- Вывод списка студентов -----------|");
            super.printListOfStudents(students);
            System.out.println("|---------------- Конец списка ----------------|");
            System.out.println("+----------------------------------------------+");
        } else {
            System.out.println("Список студентов пуст! ...");
        } 
    }

    @Override
    public String suggestInputCommand() {
        System.out.print("Введите команду: ");
        return super.suggestInputString();
    }

    @Override
    public int suggestInputNumber() {
        String message = "Введите число";
        String mistakeMessage = "Нужно ввести число! Попробуйте еще раз";
        return super.suggestInputNumber(message, mistakeMessage);
    }

    @Override
    public String suggestInputString(String message) {
        System.out.printf("%s: ", message);
        return super.suggestInputString();
    }

    @Override
    public String getLanguageInfo() {
        return "Русский";
    }

    @Override
    public boolean suggestInputAnswerToAQuestion() {
        String message = "Хотите продолжить работу в программе?";
        return super.suggestInputAnswerToAQuestion(message);
    }

    @Override
    public void printDeleteInfo(boolean success, long studentID) {
        if (success) {
            System.out.printf("Студент # %d был удален.\n", studentID);
        } else {
            System.out.printf("Не удалось найти студента с номером # %d..\n", studentID);
        }
    }
}
