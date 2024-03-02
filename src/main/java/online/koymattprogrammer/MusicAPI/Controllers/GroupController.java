package online.koymattprogrammer.MusicAPI.Controllers;

import lombok.RequiredArgsConstructor;
import online.koymattprogrammer.MusicAPI.Controllers.API.IGroupController;
import online.koymattprogrammer.MusicAPI.Dtos.Group.GroupInput;
import online.koymattprogrammer.MusicAPI.Dtos.Group.GroupResponse;
import online.koymattprogrammer.MusicAPI.Models.Group;
import online.koymattprogrammer.MusicAPI.Service.GroupService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class GroupController implements IGroupController {

    private final GroupService groupService;
    @Override
    public ResponseEntity<List<GroupResponse>> GetAllGroups(String partnerKey) {
        final var response = groupService
                .getAll(List.of(partnerKey))
                .stream()
                .map( g -> new GroupResponse(g.name,g.partnerKey,g._id.toString())).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<GroupResponse> GetGroup(String id) {
        final var group = groupService.get(new ObjectId(id));
        return ResponseEntity.ok(new GroupResponse(group.name,group.partnerKey,group._id.toString()));
    }

    @Override
    public ResponseEntity<Void> CreateGroup(GroupInput input, String partnerKey) {
        groupService.create(
                Group.builder()
                        .name(input.name())
                        .partnerKey(partnerKey)
                        .build()
        );
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
