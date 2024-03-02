package online.koymattprogrammer.MusicAPI.UseCases.Music;

import lombok.RequiredArgsConstructor;
import online.koymattprogrammer.MusicAPI.Models.Music;
import online.koymattprogrammer.MusicAPI.Repository.MusicRepository;
import online.koymattprogrammer.MusicAPI.UseCases.interfaces.UnitUseCase;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateMusicUseCase implements UnitUseCase<Music> {

    private final MusicRepository repository;
    @Override
    public void execute(Music input) {
        repository.save(input);
    }
}
