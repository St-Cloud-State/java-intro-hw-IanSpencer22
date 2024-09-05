import java.io.*;
import java.util.Scanner;

public class MyMain {

    public static void main(String[] args) {
        PersonList personList = new PersonList();

        // Create a data file with data for a few person objects
        try (PrintWriter writer = new PrintWriter(new File("persons.txt"))) {
            writer.println("John,Doe,1");
            writer.println("Jane,Smith,2");
            writer.println("Alice,Johnson,3");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Store data from file to person list
        try (Scanner inputStream = new Scanner(new File("persons.txt"))) {
            personList.store(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Display data from person list
        personList.display(System.out);

        // Invoke find method a few times
        System.out.println("Index of person with ID 2: " + personList.find("2"));
        System.out.println("Index of person with ID 4: " + personList.find("4"));

        // Additional test: Create another data file with different person objects
        try (PrintWriter writer = new PrintWriter(new File("persons2.txt"))) {
            writer.println("Bob,Brown,4");
            writer.println("Charlie,White,5");
            writer.println("David,Black,6");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Store data from the second file to the person list
        try (Scanner inputStream = new Scanner(new File("persons2.txt"))) {
            personList.store(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Display data from person list again
        personList.display(System.out);

        // Invoke find method a few more times
        System.out.println("Index of person with ID 5: " + personList.find("5"));
        System.out.println("Index of person with ID 6: " + personList.find("6"));
    }
}