package practiceapp.practiceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practiceapp.practiceapp.model.Spend;
import practiceapp.practiceapp.model.SpendDistrubution;
import practiceapp.practiceapp.service.SpendService;

import java.util.List;

@RestController
@RequestMapping("/spent")
@CrossOrigin("*")
public class SpendController {

    @Autowired
    SpendService spendService;
    @PostMapping("/add/{contributors}")
    public ResponseEntity<Spend> addSpend(@RequestBody Spend spend, @PathVariable ("contributors") List<Long> userIds){
        return ResponseEntity.ok(spendService.addSpend(spend,userIds));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Spend>> getSpendList(){
        return ResponseEntity.ok(spendService.getSpendList());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Spend> getSpend(@RequestParam (name="id") Long spendId){
        return ResponseEntity.ok(spendService.getSpend(spendId));
    }

    @PutMapping("/update")
    public ResponseEntity<Spend> updateSpend(@RequestBody Spend spend){
        return ResponseEntity.ok(spendService.updateSpend(spend));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSpend(@PathVariable (name="id") Long spendId){
        spendService.deleteSpend(spendId);
    }
    @GetMapping("/get/allGroupSpent/{groupid}")
    public ResponseEntity<List<Spend>> getSpendListForGroup(@PathVariable (name="groupid") String groupId){
        return ResponseEntity.ok(spendService.getSpendListForGroup(groupId));
    }

    @GetMapping("/spent-contributors/{spentid}")
    public ResponseEntity<List<SpendDistrubution>> getSpendContributors(@PathVariable (name="spentid") String spentId){
        return ResponseEntity.ok(spendService.getSpendContributors(spentId));
    }

}
