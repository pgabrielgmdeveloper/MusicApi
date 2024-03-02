package online.koymattprogrammer.MusicAPI.UseCases.Music;

import lombok.RequiredArgsConstructor;
import online.koymattprogrammer.MusicAPI.Models.Music;
import online.koymattprogrammer.MusicAPI.Repository.MusicRepository;
import online.koymattprogrammer.MusicAPI.UseCases.interfaces.UseCase;
import org.bson.types.ObjectId;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetMusicUseCase implements UseCase<ObjectId, Music> {

    private final MusicRepository repository;
    @Override
    public Music execute(ObjectId value) {
        return repository.findById(value).orElseGet(() -> Music.builder().build());
    }
}
