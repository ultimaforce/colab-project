package Model;

public abstract class Person {
    /** Field name */
    protected String firstName;
    /** Field surename */
    protected String lastName;
    /** Field age */
    protected int age;

    /**
     * Constructor - create new Person
     * 
     * @param firstName - name
     * @param lastName  - surename
     * @param age       - y.o.
     */
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * Function to get value of {@link Person#firstName}
     * 
     * @return String Person name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method to set new value for {@link Person#firstName}
     * 
     * @param firstName - name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Function to get value of {@link Person#lastName}
     * 
     * @return String Person surename
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method to set new value for {@link Person#lastName}
     * 
     * @param lastName - surename
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Function to get value of {@link Person#age}
     * 
     * @return int Person age
     */
    public int getAge() {
        return age;
    }

    /**
     * Method to set new value for {@link Person#age}
     * 
     * @param age - y.o.
     */
    public void setAge(int age) {
        this.age = age;
    }

}
