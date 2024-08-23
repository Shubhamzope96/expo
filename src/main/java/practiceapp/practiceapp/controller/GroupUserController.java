package practiceapp.practiceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practiceapp.practiceapp.model.GroupUser;
import practiceapp.practiceapp.service.GroupUserService;

import java.util.List;

@RestController
@RequestMapping("/group-user")
@CrossOrigin("*")
public class GroupUserController {

    @Autowired
    GroupUserService groupUserService;

    @PostMapping("/add")
    public ResponseEntity<GroupUser> addNewGroupUser(@RequestBody GroupUser groupUser){
        return ResponseEntity.ok(groupUserService.addNewGroupUser(groupUser));
    }

    @GetMapping("/group/{groupId}")
    public ResponseEntity<List<GroupUser>> getGroupUserList(@PathVariable("groupId") Long groupId){
        return ResponseEntity.ok(groupUserService.getGroupUserList(groupId));
    }

    @DeleteMapping("/group/{groupId}/remove/{id}")
    public void removeUserFromGroup(@PathVariable("groupId") Long groupId, @PathVariable ("id") Long userId){
         groupUserService.removeUserFromGroup(groupId, userId);
    }
}
