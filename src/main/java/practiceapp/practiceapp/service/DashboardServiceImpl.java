package practiceapp.practiceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practiceapp.practiceapp.model.GroupUser;
import practiceapp.practiceapp.repository.GroupUserRepo;
import practiceapp.practiceapp.repository.SpendRepo;

import java.util.HashMap;
import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService{
    @Autowired
    SpendRepo spendRepo;

    @Autowired
    GroupUserRepo groupUserRepo;



    @Override
    public HashMap<Object, Object> getAllGroupUserSpendData(Long groupId) {
        try{
            HashMap<Object, Object> res = new HashMap<Object,Object>();
            List<GroupUser> groupUsers = groupUserRepo.findByGroupId(groupId);
            for(GroupUser groupUser : groupUsers){
                Double sum = spendRepo.findSumOFSpentByUserInGroup(groupId,groupUser.getUser().getId());
                res.put(groupUser.getUser().getFirstName()+" "+groupUser.getUser().getLastName(),sum);
            }
            return res;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HashMap<Object, Object> getAllGroupUserChargedData(Long groupId) {
        try{
            HashMap<Object, Object> res = new HashMap<Object,Object>();
            List<GroupUser> groupUsers = groupUserRepo.findByGroupId(groupId);
            for(GroupUser groupUser : groupUsers){
                Double sum = spendRepo.findSumOFChargedForUserInGroup(groupId,groupUser.getUser().getId());
                res.put(groupUser.getUser().getFirstName()+" "+groupUser.getUser().getLastName(),sum);
            }
            return res;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
