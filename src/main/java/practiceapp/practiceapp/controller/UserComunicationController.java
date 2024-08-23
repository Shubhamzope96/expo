package practiceapp.practiceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practiceapp.practiceapp.service.EmailService;
import practiceapp.practiceapp.service.SMSService;

@RestController
@RequestMapping("/notify")
@CrossOrigin("*")
public class UserComunicationController {
    @Autowired
    SMSService smsService;

    @Autowired
    EmailService emailService;
    @PostMapping("/sms")
    public void sendOtp(){
        smsService.sendOtp();
    }

    @PostMapping("/mail")
    public void sendEmail(@RequestBody String email){
        emailService.sendEmail(email);
    }
    @GetMapping("/getmailotp/{email}")
    public String getOtp(@PathVariable String email){
        return emailService.getOtp(email);
    }
}
