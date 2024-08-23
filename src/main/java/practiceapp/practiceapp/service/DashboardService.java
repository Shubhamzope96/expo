package practiceapp.practiceapp.service;

import java.util.HashMap;

public interface DashboardService {
    HashMap<Object, Object> getAllGroupUserSpendData(Long groupId);

    HashMap<Object,Object> getAllGroupUserChargedData(Long groupId);
}
