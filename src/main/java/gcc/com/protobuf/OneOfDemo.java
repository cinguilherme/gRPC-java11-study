package gcc.com.protobuf;

import gcc.com.models.Credentials;
import gcc.com.models.EmailCredentials;
import gcc.com.models.PhoneOTP;

public class OneOfDemo {

    public static void main(String[] args) {

        EmailCredentials emailCredentials = EmailCredentials.newBuilder()
                .setEmail("noone@nowhere.com")
                .setPassword("password")
                .build();

        PhoneOTP phoneCreds = PhoneOTP.newBuilder()
                .setCode(123456)
                .setNumber(84578475)
                .build();

        //last one set on builder goes!
        Credentials creds = Credentials.newBuilder()
                .setPhoneMode(phoneCreds)
                .setEmailMode(emailCredentials)
                .build();

        loggin(creds);

    }

    private static void loggin(Credentials credentials) {

        switch (credentials.getModeCase()) {
            case EMAILMODE:
                System.out.println("Email Mode Detected");
                break;
            case PHONEMODE:
                System.out.println("Phone Mode Detected");
                break;
        }

        System.out.println(credentials);
    }
}
