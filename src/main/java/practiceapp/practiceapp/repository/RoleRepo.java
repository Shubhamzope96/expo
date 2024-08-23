package practiceapp.practiceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import practiceapp.practiceapp.model.Role;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Long> {
    @Query(value ="SELECT * FROM expo.role where id=?1",nativeQuery = true)
    Role getRoleById(long l);
}
