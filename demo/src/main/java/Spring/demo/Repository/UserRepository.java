package Spring.demo.Repository;

import Spring.demo.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findUserByEmailAndPassword(String email, String password);
}
