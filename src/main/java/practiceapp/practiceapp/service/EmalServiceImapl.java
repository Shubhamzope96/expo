package practiceapp.practiceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import practiceapp.practiceapp.model.OtpModule;
import practiceapp.practiceapp.repository.OtpRepo;

import java.util.*;

@Service
public class EmalServiceImapl implements EmailService{

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    OtpRepo otpRepo;

    @Override
    public void sendEmail(String email) {
        OtpModule otp = new OtpModule();
        String newOtp = generateOTP(4);
        otp.setOtp(newOtp);
        otp.setEmail(email);
        otp.setDateCreated(new Date());
        Calendar date = Calendar.getInstance();
        System.out.println("Current Date and TIme : " + date.getTime());
        long timeInSecs = date.getTimeInMillis();
        Date afterAdding3Mins = new Date(timeInSecs + (3 * 60 * 1000));
        System.out.println("After adding 10 mins : " + afterAdding3Mins);
        otp.setValidTill(afterAdding3Mins);
        try{
            otpRepo.deleteByEmail(email);
        }catch(Exception e){
            e.printStackTrace();
        }

        OtpModule otpModule = otpRepo.save(otp);

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setFrom("shubhamzope2596@gmail.com");
        msg.setSubject("User Validation");
        msg.setText("Hello User \n Your Otp for email validation is "+newOtp+".\n Please enter the same in our application to validate yourself.");

        javaMailSender.send(msg);
    }

    @Override
    public String getOtp(String email) {
        Optional<OtpModule> otp = otpRepo.findOtpByEmail(email);
        if(otp.get().getValidTill().getTime()>=new Date().getTime()){
            return otp.get().getOtp();
        }
        return "";
    }

    private static String generateOTP(int length) {
        StringBuilder generatedOTP = new StringBuilder();
        SplittableRandom splittableRandom = new SplittableRandom();

        for (int i = 0; i < length; i++) {

            int randomNumber = splittableRandom.nextInt(0, 9);
            generatedOTP.append(randomNumber);
        }
        return generatedOTP.toString();
    }
}
