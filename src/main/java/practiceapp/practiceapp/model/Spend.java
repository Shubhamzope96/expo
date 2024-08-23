package practiceapp.practiceapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="spend")
public class Spend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    Double amount = 0.0;


    @OneToOne()
    @JoinColumn(name = "user", referencedColumnName = "id")
    User User;

    @OneToOne()
    @JoinColumn(name = "groupid", referencedColumnName = "id")
    Group group;

    String description;

    Date spentDate;

    Date dateCreated;

    Date dateUpdated;

    int totalContributors;

    boolean isDeleted=false;

    public Spend() {
    }

    public Spend(Long id, Double amount, practiceapp.practiceapp.model.User user, Group group, String description, Date spentDate, Date dateCreated, Date dateUpdated, int totalContributors, boolean isDeleted) {
        this.id = id;
        this.amount = amount;
        User = user;
        this.group = group;
        this.description = description;
        this.spentDate = spentDate;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.totalContributors = totalContributors;
        this.isDeleted = isDeleted;
    }

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public practiceapp.practiceapp.model.User getUser() {
        return User;
    }

    public Group getGroup() {
        return group;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setUser(practiceapp.practiceapp.model.User user) {
        User = user;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Date getSpentDate() {
        return spentDate;
    }

    public void setSpentDate(Date spentDate) {
        this.spentDate = spentDate;
    }

    public int getTotalContributors() {
        return totalContributors;
    }

    public void setTotalContributors(int totalContributors) {
        this.totalContributors = totalContributors;
    }
}
