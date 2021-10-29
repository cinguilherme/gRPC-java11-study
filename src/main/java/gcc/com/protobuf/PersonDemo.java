package gcc.com.protobuf;


import gcc.com.models.Person;

public class PersonDemo {

    public static void main(String[] args) {

        Person p = Person.newBuilder()
                .setAge(34)
                .setName("Guilherme")
                .build();


        System.out.println(p);

    }

}
