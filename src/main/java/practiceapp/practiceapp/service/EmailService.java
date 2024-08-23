package practiceapp.practiceapp.service;

public interface EmailService {
    void sendEmail(String email);

    String getOtp(String email);
}
