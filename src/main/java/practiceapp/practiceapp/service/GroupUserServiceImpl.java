package practiceapp.practiceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practiceapp.practiceapp.model.Group;
import practiceapp.practiceapp.model.GroupUser;
import practiceapp.practiceapp.model.User;
import practiceapp.practiceapp.repository.GroupRepo;
import practiceapp.practiceapp.repository.GroupUserRepo;
import practiceapp.practiceapp.repository.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class GroupUserServiceImpl implements GroupUserService{
    @Autowired
    GroupUserRepo groupUserRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private GroupRepo groupRepo;

    @Override
    public List<GroupUser> getGroupUserList(Long groupId) {
        List<GroupUser> grpUsers = groupUserRepo.findByGroupId(groupId);
        return grpUsers;
    }

    @Override
    public void removeUserFromGroup(Long groupId, Long userId) {
        try{
            groupUserRepo.deleteUserFromGroup(groupId, userId);
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public GroupUser addNewGroupUser(GroupUser groupUser) {
        try {
            Optional<GroupUser> checkgrpUser = groupUserRepo.findByGroupIdAndUserId(groupUser.getUser().getId(), groupUser.getGroup().getId());

            System.out.println(" user "+ checkgrpUser);
            if(checkgrpUser.isEmpty()){
                System.out.println(" user is emoty");
                Optional<User> user = userRepo.findById(groupUser.getUser().getId());
                Optional<Group> group = groupRepo.findById(groupUser.getGroup().getId());
                groupUser.setUser(user.get());
                groupUser.setGroup(group.get());
                GroupUser newGroupuser = groupUserRepo.save(groupUser);
                return newGroupuser;
            }else {
                throw new Exception("User is already a Member of group");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
