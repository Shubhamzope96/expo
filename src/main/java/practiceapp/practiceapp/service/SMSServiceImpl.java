package practiceapp.practiceapp.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.SplittableRandom;

@Service
public class SMSServiceImpl implements SMSService{

    String Url = "https://www.fast2sms.com/dev/bulkV2";//"https://restapi.smscountry.com/v0.1/Accounts/authKey/SMSes/";//
    @Override
    public void sendOtp() {

        HashMap<Object, Object> map = new HashMap<Object, Object>();
        HashMap<String, Object> result = new HashMap<String, Object>();
        System.out.println(22);
        ResponseEntity<String> resultEntity = null;

        try {
            String entity="numbers:7851515";
            HttpHeaders headers = new HttpHeaders();
            System.out.println(28);
//            Client client = ClientBuilder.newClient();
//            Entity payload = Entity.json("{  \"Text\": \"sms from expenso\",  \"Number\": \"7757873246\",  \"SenderId\": \"expenso\",  \"DRNotifyUrl\": \"https://www.domainname.com/notifyurl\",  \"DRNotifyHttpMethod\": \"POST\",  \"Tool\": \"API\"}");
//
//            Response response = client.target("https://restapi.smscountry.com/v0.1/Accounts/authKey/SMSes/")
//                    .request(MediaType.APPLICATION_JSON_TYPE)
//                    .header("Authorization", "Basic d1dhcTNWU0Q0SEtHV3pqUWt6YUc6M2dmR09MMERveGlqUHVSTWFCSFROM2FFSTVJeVIyNHZXYjRyZFNvUw==")
//                    .post(payload);
//            System.out.println(response);

            headers.add("authorization", "xAaJ6PMbz4VEPq68CYU3sNSxY9vhp6w1Abl1T7xJl04q55MpuXhlf04qfskn");
//            headers.add("X-RapidAPI-Key" , "0c10c8dd66mshd0288f2753cd47cp18bccfjsn97eb1fd71ea3");
//            headers.add("X-RapidAPI-Host","d7-verify.p.rapidapi.com");
            headers.set("Content-Type", "application/x-www-form-urlencoded");

            //JSONPObject data = new JSONPObject("numbers","8390129629");
            System.out.println(34);
            String otp = generateOTP(4);
            String otpForcheck = otp;
            //String mobForCheck = data.getFunction("numbers");
            System.out.println(38);
            String message = "Your 4 digit OTP for mobile verification is : "+otp+".";

            HashMap<String,Object> data = new HashMap<String, Object>();
            data.put("Number","7757873246");
            data.put("route", "otp");
            data.put("variables_values", otp);
            data.put("language", "english");
            data.put("flash", 0);
            System.out.println(47    +"data  "+data);
            HttpEntity<String> requestheader = new HttpEntity<String>(data.toString(),headers);
            System.out.println(49 +" RH "+ requestheader);
            RestTemplate restTemplate = new RestTemplate();
            resultEntity = restTemplate.exchange(Url, HttpMethod.POST, requestheader,                    String.class);

            map.put("status", 1);
            map.put("resultEntity", resultEntity);
            System.out.println(54);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 0);
        }

        //return map;
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
