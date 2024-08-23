package practiceapp.practiceapp.model;

import javax.persistence.*;

@Entity
@Table(name="group_user")
public class GroupUser {
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

    public GroupUser() {
    }

    public GroupUser(Long id, User user, Group group) {
        this.id = id;
        this.user = user;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Group getGroup() {
        return group;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
