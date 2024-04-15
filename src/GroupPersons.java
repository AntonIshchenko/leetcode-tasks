import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

///Given a list of firms, provide their employees that are older than 30 grouped by a combination of first letter of their name and their age.
//
//
//        Firm1
//        John 35
//        Bob 40
//
//        Firm2
//        Jill 40
//        Brian 25
//
//        Firm3
//        Jessy 35
//        Betty 25
//
//        {J, 35} -> {John, Jessy}
//        {J, 40} -> {Jill}
//        {B, 40} -> {Bob}
//        {B, 25} -> {Betty, Brian} // younger than 30 so not returned

public class GroupPersons {

    public class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }


    public class Firm {
        private List<Person> employees;

        public Firm(List<Person> employees) {
            this.employees = employees;
        }

        public List<Person> getEmployees() {
            return employees;
        }
    }

    public Map<Pair<Character, Integer>, List<String>> groupAndFilterEmployees(List<Firm> firms) {
        List<Person> persons = new ArrayList<>();

        for (Firm firm : firms) {
            persons.addAll(firm.getEmployees());
        }
        List<Person> collect = persons.stream().filter(person -> person.getAge() >= 30).sorted(Comparator.comparingInt(Person::getAge)).collect(Collectors.toList());

        Map<Integer, List<String>> mapByAge = new HashMap<>();

        for (Person person : collect) {
            List<String> names = new ArrayList<>();
            List<String> strings = mapByAge.get(person.getAge());
            if (strings != null) {
                names.addAll(strings);
            }
            names.add(person.getName());
            mapByAge.put(person.getAge(), names);
        }

        Set<Integer> ages = mapByAge.keySet();

        Map<Pair<Character, Integer>, List<String>> resultMap = new HashMap();
        for (Integer age : ages) {
            List<String> strings = mapByAge.get(age);
            Collections.sort(strings);
            Map<Character, List<String>> letterNameMap = new HashMap<>();
            for (String name : strings) {
                Character letter = name.toCharArray()[0];
                List<String> strings1 = letterNameMap.get(letter);
                List<String> names = new ArrayList<>();
                if (strings1 != null) {
                    names.addAll(strings1);
                }
                names.add(name);
            }

            Set<Character> letters = letterNameMap.keySet();

            for (Character letter :letters) {
                Pair<Character, Integer> letterAgePair = new Pair<>(letter, age);
                resultMap.put(letterAgePair, letterNameMap.get(letter));
            }

        }


//        collect.forEach(person -> mapByAge.put(person.getName(), ));


//        firms.stream().map(Firm::getEmployees).flatMap()
        return resultMap;
    }
}
