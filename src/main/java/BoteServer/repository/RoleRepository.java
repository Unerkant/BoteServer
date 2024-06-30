package BoteServer.repository;

import BoteServer.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Den 28.06.2024
 */

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    Optional<Role> findByAuthority(String authority);
}
