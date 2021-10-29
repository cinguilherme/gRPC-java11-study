package gcc.com.protobuf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Int32Value;
import com.google.protobuf.InvalidProtocolBufferException;
import gcc.com.json.JPerson;
import gcc.com.models.Address;
import gcc.com.models.Car;
import gcc.com.models.Person;

import java.util.List;

public class PerformanceTest {

    public static void main(String[] args) {

        //json
        JPerson jp = new JPerson();
        jp.setAge(34);
        jp.setName("Fred JSON");
        ObjectMapper mapper = new ObjectMapper();
        Runnable runnableJson = () -> {
            byte[] bytes = new byte[0];
            try {
                bytes = mapper.writeValueAsBytes(jp);
                System.out.println("JSON byteArray size: " + bytes.length);
                JPerson jPerson = mapper.readValue(bytes, JPerson.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Person.Builder person_proto = Person.newBuilder()
                .setAge(Int32Value.newBuilder()
                                .setValue(34)
                                .build())
                .setName("Person PROTO");

        Person p = person_proto.build();

        //protobuf
        Runnable runnableProto = () -> {
            byte[] bytes = p.toByteArray();
            System.out.println("PROTO byteArray size: " + bytes.length);
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

        for (int i = 0; i < 1; i++) {
            runnableTest.run();
        }

        long end = System.currentTimeMillis();

        System.out.println(name + " => Completed 1.000.000 encoding and decoding in :" + (end - start) + "ms");
    }

}
