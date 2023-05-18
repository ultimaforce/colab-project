package Model.Models;

import java.util.List;
import java.util.Map;

import Model.TemplateModel;
import Model.People.Student;

public class MappedModel extends TemplateModel {

    /** Local storage is Map<Key, Value> */
    private Map<Long, Student> students;

    /**
     * Constructor - create new MappedModel
     * 
     * @param modelType - model name
     * @param students  - List<Student> students
     */
    public MappedModel(String modelType, Map<Long, Student> students) {
        super(modelType);
        this.students = students;
    }

    @Override
    public void addStudentToRepo(Student student) {
        this.students.put(student.getStudentID(), student);
    }

    @Override
    public List<Student> getListOfStudents() {
        /** Remove all elements from the list */
        super.students.clear();
        for (Map.Entry<Long, Student> student : this.students.entrySet()) {
            super.students.add(student.getValue());
        }
        return super.students;
    }

    @Override
    public boolean deleteStudentByID(long studentID) {
        if (this.students.containsKey(studentID)) {
            this.students.remove(studentID);
            return true;
        }
        return false;
    }
}
