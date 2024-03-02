package online.koymattprogrammer.MusicAPI.Controllers.API;

import online.koymattprogrammer.MusicAPI.Dtos.Group.GroupInput;
import online.koymattprogrammer.MusicAPI.Dtos.Group.GroupResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/group")
public interface IGroupController {
    @PostMapping
    ResponseEntity<Void> CreateGroup(@RequestBody GroupInput input, @RequestParam(name = "partnerKey") String partnerKey);


    @GetMapping
    ResponseEntity<List<GroupResponse>> GetAllGroups(@RequestParam(name = "partnerKey") String partnerKey);

    @GetMapping("{id}")
    ResponseEntity<GroupResponse> GetGroup(@PathVariable String id);

}
