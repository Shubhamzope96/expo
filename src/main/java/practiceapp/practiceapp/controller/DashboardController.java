package practiceapp.practiceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practiceapp.practiceapp.service.DashboardService;

import java.util.HashMap;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin("*")
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @GetMapping("/get/group/{groupid}/all-user-spent")
    public ResponseEntity<HashMap<Object,Object>> getAllGroupUserSpendData(@PathVariable(name="groupid") Long groupId){
        return ResponseEntity.ok(dashboardService.getAllGroupUserSpendData(groupId));
    }

    @GetMapping("/get/group/{groupid}/all-user-charged")
    public ResponseEntity<HashMap<Object,Object>> getAllGroupUserChargedData(@PathVariable(name="groupid") Long groupId){
        return ResponseEntity.ok(dashboardService.getAllGroupUserChargedData(groupId));
    }
}
