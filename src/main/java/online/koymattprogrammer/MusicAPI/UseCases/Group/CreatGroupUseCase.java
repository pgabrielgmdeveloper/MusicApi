package online.koymattprogrammer.MusicAPI.UseCases.Group;

import lombok.RequiredArgsConstructor;
import online.koymattprogrammer.MusicAPI.Models.Group;
import online.koymattprogrammer.MusicAPI.Repository.GroupRepository;
import online.koymattprogrammer.MusicAPI.UseCases.interfaces.UnitUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatGroupUseCase implements UnitUseCase<Group> {

    private final GroupRepository repository;

    @Override
    public void execute(Group input) {
            repository.save(input);
    }

}
