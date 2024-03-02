package online.koymattprogrammer.MusicAPI.UseCases.Music;

import lombok.RequiredArgsConstructor;
import online.koymattprogrammer.MusicAPI.Models.Music;
import online.koymattprogrammer.MusicAPI.Repository.MusicRepository;
import online.koymattprogrammer.MusicAPI.UseCases.interfaces.UnitUseCase;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteMusicUseCase implements UnitUseCase<ObjectId> {

    private final MusicRepository repository;
    @Override
    public void execute(ObjectId input) {
        repository.deleteById(input);
    }
}
