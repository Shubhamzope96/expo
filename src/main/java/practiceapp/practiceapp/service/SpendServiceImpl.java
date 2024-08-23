package practiceapp.practiceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practiceapp.practiceapp.model.Group;
import practiceapp.practiceapp.model.Spend;
import practiceapp.practiceapp.model.SpendDistrubution;
import practiceapp.practiceapp.model.User;
import practiceapp.practiceapp.repository.GroupRepo;
import practiceapp.practiceapp.repository.SpendDistributionRepo;
import practiceapp.practiceapp.repository.SpendRepo;
import practiceapp.practiceapp.repository.UserRepo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SpendServiceImpl implements SpendService{
    @Autowired
    SpendRepo spendRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    GroupRepo groupRepo;

    @Autowired
    SpendDistributionRepo spendDistributionRepo;

    @Override
    public Spend addSpend(Spend spend, List<Long> userids) {
        try{
            spend.setDateCreated(new Date());
            spend.setDateUpdated(new Date());
            Optional<Group> group = groupRepo.findById(spend.getGroup().getId());
            System.out.println("greoup "+group);
            Optional<User> spentBy = userRepo.findById(spend.getUser().getId());
            System.out.println("spent by "+spentBy);
            spend.setGroup(group.get());
            System.out.println("spent "+spend);
            spend.setUser(spentBy.get());
            System.out.println("spent "+spend);
            Spend newSpend = spendRepo.save(spend);
            spendDistributionRepo.deleteAllByspendGroup(spend.getId(),spend.getGroup().getId());
            for(Long userid : userids){
                SpendDistrubution spendDistrubution = new SpendDistrubution();
                Optional<User> user = userRepo.findById(userid);
                spendDistrubution.setSpend(newSpend);
                spendDistrubution.setGroup(spend.getGroup());
                spendDistrubution.setUser(user.get());
                //Optional<SpendDistrubution> checkSpendDistribution = spendDistributionRepo.findBySpendGroupAndUserId(spend.getId(),spend.getGroup().getId(),spend.getUser().getId());

                spendDistributionRepo.save(spendDistrubution);


            }
            return newSpend;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Spend> getSpendList() {
        try{
            List<Spend> spendList = spendRepo.findAll();
            return spendList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Spend getSpend(Long spendId) {
        try{
            Optional<Spend> spend = spendRepo.findById(spendId);
            return spend.get();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Spend updateSpend(Spend spend) {
        try{
            spend.setDateUpdated(new Date());
            Spend updatedSpend = spendRepo.save(spend);
            return updatedSpend;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteSpend(Long spendId) {
        try{
            spendRepo.deleteById(spendId);
            spendDistributionRepo.deleteByspendId(spendId);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Spend> getSpendListForGroup(String groupId) {
        try{
            List<Spend> spends = spendRepo.findAllSpentsForGroup(groupId);
            return spends;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<SpendDistrubution> getSpendContributors(String spentId) {
        try{
            List<SpendDistrubution> spendDistrubutions = spendDistributionRepo.findBySpendId(spentId);
            return spendDistrubutions;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
