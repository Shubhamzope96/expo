package practiceapp.practiceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import practiceapp.practiceapp.model.Group;

import java.util.List;

public interface GroupRepo extends JpaRepository<Group,Long> {
    @Query(value = "select * from expo.expense_group where id in (select distinct(groupid) from expo.group_user where user=?)",nativeQuery = true)
    List<Group> findByUserId(String userid);
}
