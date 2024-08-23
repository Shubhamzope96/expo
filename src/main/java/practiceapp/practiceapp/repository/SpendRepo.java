package practiceapp.practiceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import practiceapp.practiceapp.model.Spend;

import java.util.List;

public interface SpendRepo extends JpaRepository<Spend,Long> {
    @Query(value = "select * from expo.spend where groupid=?",nativeQuery = true)
    List<Spend> findAllSpentsForGroup(String groupId);

    @Query(value = "select IFNULL(sum(amount), 0) from expo.spend where user=?2 and groupid=?1",nativeQuery = true)
    Double findSumOFSpentByUserInGroup(Long groupId, Long id);

    @Query(value = "select sum(amount/total_contributors) from expo.spend where id in (select spendid from expo.spend_distribution where user = ?2 and groupid = ?1)",nativeQuery = true)
    Double findSumOFChargedForUserInGroup(Long groupId, Long id);

    //@Query(value = "select sum(amount/total_contributors) from expo.spend where id in (select spendid from expo.spend_distribution where user = ?2 and groupid = ?1)",nativeQuery = true)
}
