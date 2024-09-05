import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class MyMain {

    public static void main(String[] args) {
        LinkedList<Person> personList = new LinkedList<>();

        // Create a data file with data for a few person objects
        try (PrintWriter writer = new PrintWriter(new File("persons.txt"))) {
            writer.println("John,Doe,1");
            writer.println("Jane,Smith,2");
            writer.println("Alice,Johnson,3");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Store data from file to linked list
        try (Scanner inputStream = new Scanner(new File("persons.txt"))) {
            store(inputStream, personList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Display data from linked list
        display(System.out, personList);

        // Invoke find method a few times
        System.out.println("Index of person with ID 2: " + find("2", personList));
        System.out.println("Index of person with ID 4: " + find("4", personList));

        // Additional test: Create another data file with different person objects
        try (PrintWriter writer = new PrintWriter(new File("persons2.txt"))) {
            writer.println("Bob,Brown,4");
            writer.println("Charlie,White,5");
            writer.println("David,Black,6");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Store data from the second file to the linked list
        try (Scanner inputStream = new Scanner(new File("persons2.txt"))) {
            store(inputStream, personList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Display data from linked list again
        display(System.out, personList);

        // Invoke find method a few more times
        System.out.println("Index of person with ID 5: " + find("5", personList));
        System.out.println("Index of person with ID 6: " + find("6", personList));
    }

    public static void store(Scanner inputStream, LinkedList<Person> list) {
        while (inputStream.hasNextLine()) {
            String line = inputStream.nextLine();
            String[] parts = line.split(",");
            if (parts.length == 3) {
                list.add(new Person(parts[0], parts[1], parts[2]));
            }
        }
    }

    public static void display(PrintStream outputStream, LinkedList<Person> list) {
        for (Person person : list) {
            outputStream.println(person);
        }
    }

    public static int find(String sid, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }
}