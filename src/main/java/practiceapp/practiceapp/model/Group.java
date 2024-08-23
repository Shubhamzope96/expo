package practiceapp.practiceapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="expense_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    String groupName;

    String groupDescription;

    Date dateCreated;

    Date dateUpdated;

    Boolean isActive = true;

    Boolean isDeleted = false;

    @OneToOne()
    @JoinColumn(name = "groupOwner", referencedColumnName = "id")
    User groupOwner;

//    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
//    @JoinTable(name="group_users",
//            joinColumns = @JoinColumn(name="user", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name="group",referencedColumnName = "id")
//    )
//    Set<User> users;

    public Group() {
    }

    public Group(Long id, String groupName, String groupDescription, Date dateCreated, Date dateUpdated, Boolean isActive, Boolean isDeleted, User groupOwner) {
        this.id = id;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.groupOwner = groupOwner;
        //this.users = users;
    }

    public Long getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public Boolean getActive() {
        return isActive;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public User getGroupOwner() {
        return groupOwner;
    }

//    public Set<User> getUsers() {
//        return users;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public void setGroupOwner(User groupOwner) {
        this.groupOwner = groupOwner;
    }

//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
}
