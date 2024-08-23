package practiceapp.practiceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import practiceapp.practiceapp.model.Role;
import practiceapp.practiceapp.model.User;
import practiceapp.practiceapp.repository.RoleRepo;
import practiceapp.practiceapp.repository.UserRepo;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public User addNewUser(User user) {
        try{
            user.setDateAdded(new Date());
            user.setDateUpdated(new Date());
            Role role = roleRepo.getRoleById(2L);
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
            Optional<User> checkUser = userRepo.findByEmail(user.getEmail());
            if(checkUser.isPresent()){
                throw new Exception("User with email "+user.getEmail()+" already registered");
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User newUser = userRepo.save(user);
            return newUser;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List <User> getUserList() {
        List <User> userList = userRepo.findAll();
        return userList;
    }

    @Override
    public User getUser(Long userId) {
        try{
            Optional<User> user = userRepo.findById(userId);
            sendOtp();
            return user.get();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String deleteUser(Long userId) {
        try{
            userRepo.deleteById(userId);
            return "User "+userId+" deleted successfully.";
        }catch(Exception e){
            e.printStackTrace();
            return "Something went wrong";
        }
    }

    @Override
    public User updateUser(User user) {
        try{
            user.setDateUpdated(new Date());
            Role role = roleRepo.getRoleById(2L);
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
            Optional<User> oldUser = userRepo.findById((long) user.getId());
            user.setDateAdded(oldUser.get().getDateAdded());
            System.out.println("reached here");
            User updatedUser = userRepo.save(user);
            return updatedUser;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> searchUserByUsername(String username) {

        Optional<List<User>> userList = userRepo.searchUserByUsername(username);
        return userList.get();
    }

    String Url = "https://www.fast2sms.com/dev/bulkV2";
    public void sendOtp() {

        HashMap<Object, Object> map = new HashMap<Object, Object>();
        HashMap<String, Object> result = new HashMap<String, Object>();
        System.out.println(22);
        ResponseEntity<String> resultEntity = null;

        try {
            String entity="numbers:7851515";
            HttpHeaders headers = new HttpHeaders();
            System.out.println(28);
            headers.add("authorization", "v1pedaj7hUKbtxgorw8Q5Lf0AzFBXPTJq3ZCmDcHOsM2nESuNy34BKQZ9hzo27YTiMwEUFskxGXINefp");

            headers.set("Content-Type", "application/json");

            //JSONPObject data = new JSONPObject("numbers","8390129629");
            System.out.println(34);
            String otp = generateOTP(4);
            String otpForcheck = otp;
            //String mobForCheck = data.getFunction("numbers");
            System.out.println(38);
            String message = "Your 4 digit OTP for mobile verification is : "+otp+".";

            HashMap<String,Object> data = new HashMap<String, Object>();
            data.put("numbers","8390129629");
            data.put("route", "otp");
            data.put("message", message);
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
