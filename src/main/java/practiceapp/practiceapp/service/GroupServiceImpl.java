package practiceapp.practiceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practiceapp.practiceapp.model.Group;
import practiceapp.practiceapp.model.GroupUser;
import practiceapp.practiceapp.model.User;
import practiceapp.practiceapp.repository.GroupRepo;
import practiceapp.practiceapp.repository.GroupUserRepo;
import practiceapp.practiceapp.repository.UserRepo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService{
    @Autowired
    GroupRepo groupRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    GroupUserRepo groupUserRepo;

    @Override
    public Group createGroup(Group group) {
        try{
            group.setDateCreated(new Date());
            group.setDateUpdated(new Date());
            Optional<User> user = userRepo.findById(group.getGroupOwner().getId());
            group.setGroupOwner(user.get());
           Group newGroup =groupRepo.save(group);
            GroupUser  groupUser = new GroupUser();
            groupUser.setUser(group.getGroupOwner());
            groupUser.setGroup(newGroup);
            groupUserRepo.save(groupUser);
           return newGroup;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Group> getGroupList() {
        try{
            return groupRepo.findAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Group getGroup(Long groupId) {
        try{
            Optional<Group> group = groupRepo.findById(groupId);
            return group.get();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String deleteGroup(Long groupId) {
        try{
            groupRepo.deleteById(groupId);
            return "group deleted successfully";
        }catch(Exception e){
            e.printStackTrace();
            return "something went wrong";
        }
    }

    @Override
    public Group updateGroup(Group group) {
        try{
            Optional<Group> oldGrpInfo = groupRepo.findById(group.getId());
            oldGrpInfo.get().setGroupName(group.getGroupName());
            oldGrpInfo.get().setGroupDescription(group.getGroupDescription());
            oldGrpInfo.get().setDateUpdated(new Date());
            Group updatedGroup = groupRepo.save(oldGrpInfo.get());
            return updatedGroup;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String addUsersToGroup(List<User> users, Group group) {
        try{
            for(User user:users){
                GroupUser groupUser = new GroupUser();
                groupUser.setGroup(group);
                groupUser.setUser(user);
                groupUserRepo.save(groupUser);
            }
            return "All users added successfully";
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Group> getGroupList(String userid) {
        try{
            return groupRepo.findByUserId(userid);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
