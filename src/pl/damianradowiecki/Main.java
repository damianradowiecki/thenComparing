package pl.damianradowiecki;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Andrew", "Berry"));
        people.add(new Person("Patrick", "Berry"));
        people.add(new Person("Donna", "Ant"));
        people.add(new Person("Carmen", "Ant"));

        Comparator<Person> personComparator = Comparator.comparing(Person::getSurname)
                .thenComparing(Person::getName);

        printPeople("Before sorting:", people);
        people.sort(personComparator);
        printPeople("After sorting:", people);
    }

    private static void printPeople(String message, List<Person> people) {
        System.out.println(message);
        for (Person p :
                people) {
            System.out.println(p);
        }
    }

    static class Person {
        private final String name;
        private final String surname;

        public Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    '}';
        }
    }
}
