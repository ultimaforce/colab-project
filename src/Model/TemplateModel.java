package Model;

import java.util.ArrayList;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.People.Student;

public abstract class TemplateModel implements iGetModel {
    /** Means a Model name */
    protected String modelType;
    /** List with data */
    protected List<Student> students;

    /**
     * Constructor - create new TemplateModel
     * 
     * @param modelType - as model name
     */
    public TemplateModel(String modelType) {
        this.modelType = modelType;
        this.students = new ArrayList<Student>();
    }

    /**
     * Function to get value of {@link TemplateModel#modelType}
     * 
     * @return String model type or name
     */
    public String getModelType() {
        return modelType;
    }

    /**
     * Method to set new value for {TemplateModel#modelType}
     * 
     * @param modelType - model name
     */
    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    /**
     * Function to get value of {@link TemplateModel#students}
     * 
     * @return List<Student> students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Method to set new value for {TemplateModel#students}
     * 
     * @param students - List<Student> students
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
