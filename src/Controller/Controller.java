package Controller;

import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;

public class Controller {
    /** Controller contains a list with UI setups */
    private List<iGetView> views;
    /** Controller contains a list with data sources */
    private List<iGetModel> models;
    /** Current object with Data */
    private iGetModel currentModel;
    /** Current object with UI settings */
    private iGetView currentView;

    /**
     * Constructor - create new Controller
     * 
     * @param models - list with iGetModel's objects
     * @param views  - list with iGetView's objects
     */
    public Controller(List<iGetModel> models, List<iGetView> views) {
        this.views = views;
        this.models = models;
        this.setup();
        this.run();
    }

    /**
     * Method to suggest user complete program settings
     */
    private void setup() {

        Scanner iScanner = new Scanner(System.in);
        /** Show list with indexes to choose language */
        System.out.println("Select language:");
        for (int i = 0; i < this.views.size(); i++) {
            System.out.printf("# %d - %s\n", i, this.views.get(i).getLanguageInfo());
        }
        /** set current language */
        this.currentView = this.views.get(iScanner.nextInt());

        /** Show list with indexes to choose data source */
        System.out.println("Select data source:");
        for (int j = 0; j < this.models.size(); j++) {
            System.out.printf("# %d - %s\n", j, this.models.get(j).getModelType());
        }
        /** set current data source */
        this.currentModel = this.models.get(iScanner.nextInt());

    }

    /**
     * Run program
     */
    public void run() {
        Commands com = Commands.NONE;
        boolean flag = true;

        while (flag) {

            String command = currentView.suggestInputCommand();
            com = Commands.valueOf(command.toUpperCase());

            switch (com) {
                case LIST:
                    currentView.drawListOfStudents(currentModel.getListOfStudents());
                    flag = currentView.suggestInputAnswerToAQuestion();
                    break;
                case DELETE:
                    long studentID = (long) currentView.suggestInputNumber();
                    boolean result = false;
                    for (iGetModel model : this.models) {
                        if (model.deleteStudentByID(studentID)) {
                            result = true;
                            break;
                        }
                    }
                    currentView.printDeleteInfo(result, studentID);
                    flag = currentView.suggestInputAnswerToAQuestion();
                    break;
                case EXIT:
                default:
                    flag = false;
                    currentView.exitProgram();
                    break;
            }
        }
    }
}
