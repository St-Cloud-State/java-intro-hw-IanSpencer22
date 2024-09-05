public class Person {
    private String firstName;
    private String lastName;
    private String id;

    // Constructor
    public Person(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    // Accessor methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    // toString method
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}