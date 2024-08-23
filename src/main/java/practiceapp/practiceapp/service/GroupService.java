package practiceapp.practiceapp.service;

import practiceapp.practiceapp.model.Group;
import practiceapp.practiceapp.model.User;

import java.util.List;

public interface GroupService {
    Group createGroup(Group group);

    List<Group> getGroupList();

    Group getGroup(Long groupId);

    String deleteGroup(Long groupId);

    Group updateGroup(Group group);

    String addUsersToGroup(List<User> users, Group group);

    List<Group> getGroupList(String userid);
}
