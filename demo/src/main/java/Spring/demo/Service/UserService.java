package Spring.demo.Service;

import Spring.demo.Model.UserModel;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {

    UserModel createUser(UserModel user);
    UserModel updateUser(UserModel user);
    void deleteUser(UserModel user);
    List<UserModel> userList(UserModel user);
    UserModel getUser(UserModel user);
    UserModel findUserById(UserModel user);
}
