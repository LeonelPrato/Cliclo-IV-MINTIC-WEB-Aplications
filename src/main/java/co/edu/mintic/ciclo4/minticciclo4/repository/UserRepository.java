package co.edu.mintic.ciclo4.minticciclo4.repository;

import co.edu.mintic.ciclo4.minticciclo4.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT * FROM users WHERE email LIKE ?1", nativeQuery = true)
    User getUserByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM users WHERE email LIKE ?1 AND password LIKE ?2", nativeQuery = true)
    User getUserByEmailAAndPassword(@Param("email") String email, @Param("password") String password);
}
