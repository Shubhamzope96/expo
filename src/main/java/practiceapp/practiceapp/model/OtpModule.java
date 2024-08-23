package practiceapp.practiceapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="otp_table")
public class OtpModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    String otp;



    String email;

    Date dateCreated;

    Date validTill;

    Boolean isActive = true;

    public OtpModule() {
    }

    public OtpModule(Long id,String otp, String email, Date dateCreated, Date validTill, Boolean isActive) {
        this.id = id;
        this.email = email;
        this.dateCreated = dateCreated;
        this.validTill = validTill;
        this.isActive = isActive;
        this.otp = otp;
    }

    public Long getId() {
        return id;
    }



    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getValidTill() {
        return validTill;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setValidTill(Date validTill) {
        this.validTill = validTill;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
