package Model.Models;

import java.util.List;

import Model.TemplateModel;
import Model.People.Student;

public class CommonModel extends TemplateModel {

    /**
     * Constructor - create new CommonModel
     * 
     * @param modelType - model name
     * @param list      - List<Student> students
     */
    public CommonModel(String modelType, List<Student> list) {
        super(modelType);
        super.students = list;
    }

    @Override
    public List<Student> getListOfStudents() {
        return super.getStudents();
    }

    @Override
    public void addStudentToRepo(Student student) {
        super.students.add(student);
    }

    @Override
    public boolean deleteStudentByID(long studentID) {
        for (int i = 0; i < super.students.size(); i++) {
            if (super.students.get(i).getStudentID() == studentID) {
                super.students.remove(i);
                return true;
            }
        }
        return false;
    }
}
