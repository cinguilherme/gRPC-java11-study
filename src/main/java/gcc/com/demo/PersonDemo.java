package gcc.com.demo;

import gcc.com.models.person.Person;

public class PersonDemo {

    public static void main(String[] args) {

        Person p = Person.newBuilder()
                         .setName("Guilherme")
                         .setAge(34)
                         .build();

        System.out.println(p);

    }

}
