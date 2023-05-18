package Model.People;

import Model.Person;

public class Student extends Person implements Comparable<Student> {
    /** Student ID */
    private long studentID;

    /**
     * Constructor - create new Student
     * 
     * @param firstName - name
     * @param lastName  - surename
     * @param age       - y.o.
     * @param studentID - uniq id
     */
    public Student(String firstName, String lastName, int age, long studentID) {
        super(firstName, lastName, age);
        this.studentID = studentID;
    }

    /**
     * Function to get value of {@link Student#studentID}
     * 
     * @return long uniq Student ID
     */
    public long getStudentID() {
        return studentID;
    }

    @Override
    public String toString() {
        return String.format("{\"id\": %d, \"type\": \"%s\", \"name\": \"%s\", \"surename\": \"%s\", \"age\": %d}",
                studentID, "Student", firstName, lastName, age);
    }

    /**
     * Compare Students by Person age
     * first: 21
     * second: 25
     * third: 27
     */
    @Override
    public int compareTo(Student o) {
        if (super.getAge() == o.getAge()) {
            if (this.studentID == o.studentID) {
                return 0;
            } else if (this.studentID < o.studentID) {
                return -1;
            }
            return 1;
        }
        if (super.getAge() < o.getAge()) {
            return -1;
        }
        return 1;
    }
}
