package practiceapp.practiceapp.service;

import practiceapp.practiceapp.model.Spend;
import practiceapp.practiceapp.model.SpendDistrubution;

import java.util.List;

public interface SpendService {

    Spend addSpend(Spend spend, List<Long> userids);

    List<Spend> getSpendList();

    Spend getSpend(Long spendId);

    Spend updateSpend(Spend spend);

    void deleteSpend(Long spendId);

    List<Spend> getSpendListForGroup(String groupId);

    List<SpendDistrubution> getSpendContributors(String spentId);
}
