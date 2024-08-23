package practiceapp.practiceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import practiceapp.practiceapp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query(value = "SELECT * FROM expo.user where EMAIL LIKE %?%",nativeQuery = true)
    Optional<List<User>> searchUserByUsername(String username);
}
