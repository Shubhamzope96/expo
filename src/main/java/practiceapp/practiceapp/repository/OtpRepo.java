package practiceapp.practiceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import practiceapp.practiceapp.model.OtpModule;

import javax.transaction.Transactional;
import java.util.Optional;

public interface OtpRepo extends JpaRepository<OtpModule,Long> {
    @Query(value = "select * from expo.otp_table where email=?1",nativeQuery = true)
    Optional<OtpModule> findOtpByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "delete from expo.otp_table where email=?1",nativeQuery = true)
    void deleteByEmail(String email);
}
