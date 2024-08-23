package practiceapp.practiceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practiceapp.practiceapp.model.Group;
import practiceapp.practiceapp.model.User;
import practiceapp.practiceapp.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("/group")
@CrossOrigin("*")
public class GroupController {

    @Autowired
    GroupService groupService;

    @PostMapping("/add")
    public ResponseEntity<Group> addGroup(@RequestBody Group group){
        return ResponseEntity.ok(groupService.createGroup(group));
    }

    @PutMapping("/update")
    public ResponseEntity<Group> updateGroup(@RequestBody Group group){
        return ResponseEntity.ok(groupService.updateGroup(group));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Group>> getGroupList(){
        return ResponseEntity.ok(groupService.getGroupList());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Group> getGroup(@PathVariable (name="id") Long groupId){
        return ResponseEntity.ok(groupService.getGroup(groupId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGroup(@RequestParam (name="id") Long groupId){
        return ResponseEntity.ok(groupService.deleteGroup(groupId));
    }

    @PostMapping("/add/{group}/users/{userList}")
    public ResponseEntity<String> addUsersToGroup(@RequestParam(name="userList") List<User> users, @RequestParam (name="group") Group group){
        return ResponseEntity.ok(groupService.addUsersToGroup(users, group));
    }

    @GetMapping("/user-group/get/{userid}")
    public ResponseEntity<List<Group>> getUserGroupList(@PathVariable ("userid") String userid){
        return ResponseEntity.ok(groupService.getGroupList(userid));
    }

}
