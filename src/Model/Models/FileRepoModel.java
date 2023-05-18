package Model.Models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import Model.TemplateModel;
import Model.People.Student;

public class FileRepoModel extends TemplateModel {

    private String dbFileName;
    private String pathFile;

    /**
     * Constructor - create new FileRepoModel
     * 
     * @param modelType  - model name
     * @param sourceFile - db file name with extension
     */
    public FileRepoModel(String modelType, String sourceFile) {
        super(modelType);
        this.dbFileName = sourceFile;
        this.pathFile = findOrCreateDBFile(sourceFile);
        readDataFromFile();
    }

    /**
     * Check for file or create new
     * 
     * @param sourceFile - db file name with extension
     * @return String file path
     */
    private String findOrCreateDBFile(String sourceFile) {
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat("\\src\\" + sourceFile);
        // System.out.println(pathFile);
        try {
            File file = new File(pathFile);
            if (file.createNewFile()) {
                System.out.printf("DB > %s was created!\n", sourceFile);
            } else {
                System.out.printf("DB > %s existed!\n", sourceFile);
            }
        } catch (Exception e) {
            System.out.println("DB > BOOM!");
            System.out.println(e.getMessage());
        }
        return pathFile;
    }

    /**
     * Method read db file and fill local storage with data
     */
    private void readDataFromFile() {
        try {
            File file = new File(this.pathFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader buffReader = new BufferedReader(fileReader);
            String line = buffReader.readLine();
            while (line != null) {
                String[] param = line.split(" ");
                Student student = new Student(
                        param[2], // name
                        param[1], // surename
                        Integer.parseInt(param[3]), // age
                        Long.parseLong(param[0]) // uniq id
                );
                /** Add this student to file repo */
                super.students.add(student);
                line = buffReader.readLine();
            }
        } catch (Exception e) {
            System.out.println("DB > BOOM!");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method takes data from {@link TemplateModel#students}
     * and writes it to the db file
     */
    private void saveDataToFile() {
        try {
            File file = new File(this.pathFile);
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter buffWriter = new BufferedWriter(fileWriter);
            for (Student student : super.students) {
                String line = String.format("%d %s %s %d", student.getStudentID(), student.getLastName(),
                        student.getFirstName(), student.getAge());
                buffWriter.newLine();
                fileWriter.write(line);
            }
            System.out.printf("DB > %s Saved!\n", this.dbFileName);
        } catch (Exception e) {
            System.out.println("DB > BOOM!");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Student> getListOfStudents() {
        return super.students;
    }

    @Override
    public void addStudentToRepo(Student student) {
        super.students.add(student);
        saveDataToFile();
    }

    @Override
    public boolean deleteStudentByID(long studentID) {
        for (int i = 0; i < super.students.size(); i++) {
            if (super.students.get(i).getStudentID() == studentID) {
                super.students.remove(i);
                /** Save data in file */
                saveDataToFile();
                return true;
            }
        }
        return false;
    }
}
