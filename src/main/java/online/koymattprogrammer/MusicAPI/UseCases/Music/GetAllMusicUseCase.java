package online.koymattprogrammer.MusicAPI.UseCases.Music;

import lombok.RequiredArgsConstructor;
import online.koymattprogrammer.MusicAPI.Models.Music;
import online.koymattprogrammer.MusicAPI.Repository.MusicRepository;
import online.koymattprogrammer.MusicAPI.UseCases.interfaces.UseCase;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllMusicUseCase implements UseCase<List<?>, List<Music>> {
    private final MusicRepository repository;
    @Override
    public List<Music> execute(List<?> value) {
        return repository.finAllByPartnerKeyAndGroup(new ObjectId(value.get(0).toString()), value.get(1).toString());
    }
}
