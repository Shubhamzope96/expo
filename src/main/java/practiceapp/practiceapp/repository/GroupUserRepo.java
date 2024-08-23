package practiceapp.practiceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import practiceapp.practiceapp.model.GroupUser;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface GroupUserRepo extends JpaRepository<GroupUser,Long> {

    @Query(value = "SELECT * FROM expo.group_user where groupid=?",nativeQuery = true)
    List<GroupUser> findByGroupId(Long groupId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM expo.group_user where groupid=? and user=?",nativeQuery = true)
    void deleteUserFromGroup(Long groupId, Long userId);


    @Query(value = "SELECT * FROM expo.group_user where user=? and groupid=?",nativeQuery = true)
    Optional<GroupUser> findByGroupIdAndUserId(Long id, Long id1);
}
