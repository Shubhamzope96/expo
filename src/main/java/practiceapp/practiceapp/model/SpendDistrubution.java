package practiceapp.practiceapp.model;

import javax.persistence.*;

@Entity
@Table(name="spend_distribution")
public class SpendDistrubution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne()
    @JoinColumn(name = "user", referencedColumnName = "id")
    User user;

    @OneToOne()
    @JoinColumn(name = "groupid", referencedColumnName = "id")
    Group group;

    @OneToOne()
    @JoinColumn(name = "spendid", referencedColumnName = "id")
    Spend spend;

    public SpendDistrubution() {
    }

    public SpendDistrubution(Long id, User user, Group group, Spend spend) {
        this.id = id;
        this.user = user;
        this.group = group;
        this.spend = spend;
    }

    public Long getId() {
        return id;
    }

    public Spend getSpend() {
        return spend;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSpend(Spend spend) {
        this.spend = spend;
    }

    public User getUser() {
        return user;
    }

    public Group getGroup() {
        return group;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
