package practiceapp.practiceapp.service;

import practiceapp.practiceapp.model.GroupUser;

import java.util.List;

public interface GroupUserService {
    List<GroupUser> getGroupUserList(Long groupId);

    void removeUserFromGroup(Long groupId, Long userId);

    GroupUser addNewGroupUser(GroupUser groupUser);
}
