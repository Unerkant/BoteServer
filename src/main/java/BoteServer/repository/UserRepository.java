package BoteServer.repository;

import BoteServer.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Den 15.06.2024
 */

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    //public User getUserByUsername(String username);

    Optional<User> findByUsernameOrEmail(String username, String email);
}
