package gcc.com.protobuf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;

import gcc.com.json.JPerson;
import gcc.com.models.person.Person;

import java.io.IOException;
import java.util.List;

public class PerformanceTest {

    public static void main(String[] args) {

        //json
        JPerson jp = new JPerson();
        jp.setAge(34);
        jp.setName("Fred JSON");
        List<Integer> favoriteNums = new java.util.ArrayList<>();
        favoriteNums.add(1);
        favoriteNums.add(4);
        favoriteNums.add(6);
        favoriteNums.add(7);
        jp.setFavoriteNums(favoriteNums);
        List<String> favoriteNums2 = new java.util.ArrayList<>();
        favoriteNums2.add("String");
        favoriteNums2.add("String");
        favoriteNums2.add("String");
        favoriteNums2.add("String");
        jp.setTags(favoriteNums2);
        ObjectMapper mapper = new ObjectMapper();
        Runnable runnableJson = () -> {
            byte[] bytes = new byte[0];
            try {
                bytes = mapper.writeValueAsBytes(jp);
                JPerson jPerson = mapper.readValue(bytes, JPerson.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Person.Builder person_proto = Person.newBuilder()
                .setAge(34)
                .setName("Person PROTO");
        person_proto.addTags("Frame");
        person_proto.addTags("Frame");
        person_proto.addTags("Gene");
        person_proto.addFavoriteNumbers(7);
        person_proto.addFavoriteNumbers(14);
        Person p = person_proto.build();

        System.out.println(p);
        //protobuf
        Runnable runnableProto = () -> {
            byte[] bytes = p.toByteArray();
            try {
                Person sam = Person.parseFrom(bytes);
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        };

        runPerformanceTest(runnableJson, "JSON");
        runPerformanceTest(runnableProto, "PROTO");

    }

    public static void runPerformanceTest(Runnable runnableTest, String name) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < 2_000_000; i++) {
            runnableTest.run();
        }

        long end = System.currentTimeMillis();

        System.out.println(name + " => Completed 1.000.000 encoding and decoding in :" + (end - start) + "ms");
    }

}
