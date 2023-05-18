package Controller.Interfaces;

import java.util.List;
import Model.People.Student;

public interface iGetModel {

    /**
     * Add object Student to local storage
     * 
     * @param student - Student object
     */
    void addStudentToRepo(Student student);

    /**
     * Get formatted students list
     * 
     * @return List<Student> students
     */
    List<Student> getListOfStudents();

    /**
     * Get model desctiption
     * 
     * @return String model name
     */
    String getModelType();

    /**
     * Delete Student from models in models list by uniq id
     * 
     * @param studentID - uniq student id
     * @return boolean success to delete student
     */
    boolean deleteStudentByID(long studentID);
}