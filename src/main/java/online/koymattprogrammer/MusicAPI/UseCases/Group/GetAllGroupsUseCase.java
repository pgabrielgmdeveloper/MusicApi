package online.koymattprogrammer.MusicAPI.UseCases.Group;

import lombok.RequiredArgsConstructor;
import online.koymattprogrammer.MusicAPI.Models.Group;
import online.koymattprogrammer.MusicAPI.Repository.GroupRepository;
import online.koymattprogrammer.MusicAPI.UseCases.interfaces.UseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllGroupsUseCase implements UseCase<String , List<Group>> {

    private final GroupRepository repository;

    @Override
    public List<Group> execute(String value) {
        return repository.findAllGetGroupByPartnerKey(value);
    }
}
