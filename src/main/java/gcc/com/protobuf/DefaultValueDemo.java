package gcc.com.protobuf;

import gcc.com.models.Address;
import gcc.com.models.Person;

public class DefaultValueDemo {

    public static void main(String[] args) {

        Person p = Person.newBuilder()
                .setAddress(Address.newBuilder()
                                    .setStreet("Rua Almirante tamandaré")
                                    .setZipcode("51030090"))
                .build();

        System.out.println(p);

        System.out.println("Has address? " + p.hasAddress());

    }

}
