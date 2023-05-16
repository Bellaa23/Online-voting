package Spring.demo.Service;

import Spring.demo.Model.UserModel;
import Spring.demo.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImplementation implements UserService{

    @Autowired
    UserRepository userService;
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public UserModel createUser(UserModel user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("bellaisimbi23@gmail.com");
        message.setTo(user.getEmail());
        message.setText("You have successfully Signed Up !!");
        message.setSubject("Confirmation Email");

        mailSender.send(message);
        return userService.save(user);
    }


    @Override
    public UserModel updateUser(UserModel user) {
        UserModel users = findUserById((user));
        if(users!=null){
            users.setId(user.getId());
            users.setEmail(user.getEmail());
            users.setPassword(user.getPassword());
            return userService.save(users);
        }else {
         return createUser(user);
        }
    }

    @Override
    public void deleteUser(UserModel user) {
        userService.deleteAll();
    }


    @Override
    public List<UserModel> userList(UserModel user) {
//        return userService.findAll();
        return userService.findAll();
    }

    @Override
    public UserModel getUser(UserModel user) {
        return userService.findUserByEmailAndPassword(user.getEmail(),user.getPassword()).orElse(null);
    }

    @Override
    public UserModel findUserById(UserModel user) {
        return userService.findById(user.getId()).get();
    }
}
