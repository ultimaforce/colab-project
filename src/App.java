import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Controller.Controller;
import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.Models.CommonModel;
import Model.Models.FileRepoModel;
import Model.Models.MappedModel;
import Model.People.Student;
import View.Views.ViewEng;
import View.Views.ViewRus;

public class App {
    public static void main(String[] args) throws Exception {
        // *******************************************
        // **** Students list for the first model ****
        // *******************************************
        Student s1 = new Student("Vladislav", "Elizarov", 27, (long)3366);
        Student s2 = new Student("Андрей", "Сидоров", 26, (long)3367);
        Student s3 = new Student("Иван", "Петров", 22, (long)3368);
        Student s4 = new Student("Игорь", "Иванов", 23, (long)3369);
        Student s5 = new Student("Даша", "Цветкова", 24, (long)3370);
        Student s6 = new Student("Лена", "Незабудкина", 21, (long)3371);
        Student s7 = new Student("Мирон", "Федоров", 25, (long)3372);
        Student s8 = new Student("Илья", "Газманов", 29, (long)3373);
        Student s9 = new Student("Настя", "Дроздова", 28, (long)3374);

        /** Add created students to list */
        List<Student> alpha = new ArrayList<>();
        alpha.add(s1);
        alpha.add(s2);
        alpha.add(s3);
        alpha.add(s4);
        alpha.add(s5);
        alpha.add(s6);
        alpha.add(s7);
        alpha.add(s8);
        alpha.add(s9);

        // *******************************************
        // **** Students list for the third model ****
        // *******************************************
        Student s10 = new Student("Виктория", "Золотарева", 34, (long)2001);
        Student s11 = new Student("Кирилл", "Алексеев", 33, (long)2002);
        Student s12 = new Student("Екатерина", "Гущина", 32, (long)2003);
        Student s13 = new Student("Милана", "Павлова", 31, (long)2004);
        Student s14 = new Student("Дмитрий", "Ларин", 32, (long)2005);
        Student s15 = new Student("Ольга", "Наумова", 35, (long)2006);
        Student s16 = new Student("Фатима", "Зубова", 29, (long)2007);
        Student s17 = new Student("Ксения", "Панова", 33, (long)2008);
        Student s18 = new Student("Арина", "Мальцева", 31, (long)2009);
        
        /** Add created students to map */
        Map<Long, Student> bravo = new HashMap<>();
        bravo.put(s10.getStudentID(), s10);
        bravo.put(s11.getStudentID(), s11);
        bravo.put(s12.getStudentID(), s12);
        bravo.put(s13.getStudentID(), s13);
        bravo.put(s14.getStudentID(), s14);
        bravo.put(s15.getStudentID(), s15);
        bravo.put(s16.getStudentID(), s16);
        bravo.put(s17.getStudentID(), s17);
        bravo.put(s18.getStudentID(), s18);

        /** Create models with students data */
        iGetModel cModel = new CommonModel("cModel", alpha);
        iGetModel fModel = new FileRepoModel("fModel","students-db.txt");
        iGetModel mModel = new MappedModel("mModel",bravo);
        List<iGetModel> models = new ArrayList<>();
        models.add(cModel);
        models.add(fModel);
        models.add(mModel);

        /** Create views with language setup */
        iGetView ruUI = new ViewRus();
        iGetView enUI = new ViewEng();
        List<iGetView> views = new ArrayList<>();
        views.add(ruUI);
        views.add(enUI);

        /** Create Controller */
        Controller thisIsAProfession = new Controller(models, views);
    }
}
