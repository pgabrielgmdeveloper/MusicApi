package online.koymattprogrammer.MusicAPI.UseCases.Group;

import lombok.RequiredArgsConstructor;
import online.koymattprogrammer.MusicAPI.Models.Group;
import online.koymattprogrammer.MusicAPI.Repository.GroupRepository;
import online.koymattprogrammer.MusicAPI.UseCases.interfaces.UseCase;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetGroupUseCase implements UseCase<ObjectId, Group> {

    private  final GroupRepository repository;

    @Override
    public Group execute(ObjectId input) {
        return repository.findById(input).orElseGet(() -> Group.builder().build());
    }
}
