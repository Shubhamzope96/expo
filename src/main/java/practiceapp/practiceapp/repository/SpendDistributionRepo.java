package practiceapp.practiceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import practiceapp.practiceapp.model.SpendDistrubution;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface SpendDistributionRepo extends JpaRepository<SpendDistrubution,Long> {
    @Query(value = "SELECT * FROM expo.spend_distribution where spendid = ?",nativeQuery = true)
    List<SpendDistrubution> findBySpendId(String spentId);

    @Query(value = "SELECT * FROM expo.spend_distribution where spendid = ?1 and groupid=?2 and user=?3",nativeQuery = true)
    Optional<SpendDistrubution> findBySpendGroupAndUserId(Long id, Long id1, Long id2);

    @Modifying
    @Transactional
    @Query(value = "delete FROM expo.spend_distribution where spendid = ?1 and groupid=?2",nativeQuery = true)
    void deleteAllByspendGroup(Long id, Long id1);

    @Modifying
    @Transactional
    @Query(value = "delete FROM expo.spend_distribution where spendid = ?1",nativeQuery = true)
    void deleteByspendId(Long spendId);
}
