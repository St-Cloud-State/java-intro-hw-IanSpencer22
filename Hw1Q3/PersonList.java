import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class PersonList {
    private LinkedList<Person> list;

    public PersonList() {
        list = new LinkedList<>();
    }

    public void store(Scanner inputStream) {
        while (inputStream.hasNextLine()) {
            String line = inputStream.nextLine();
            String[] parts = line.split(",");
            if (parts.length == 3) {
                list.add(new Person(parts[0], parts[1], parts[2]));
            }
        }
    }

    public void display(PrintStream outputStream) {
        for (Person person : list) {
            outputStream.println(person);
        }
    }

    public int find(String sid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }
}