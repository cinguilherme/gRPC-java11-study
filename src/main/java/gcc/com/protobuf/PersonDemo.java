package gcc.com.protobuf;


import com.google.protobuf.Int32Value;
import gcc.com.models.Person;

public class PersonDemo {

    public static void main(String[] args) {

        Person p = Person.newBuilder()
                .setAge(Int32Value.newBuilder()
                                .setValue(32)
                                .build())
                .setName("Guilherme")
                .build();


        System.out.println(p);

    }

}
