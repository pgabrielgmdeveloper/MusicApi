package online.koymattprogrammer.MusicAPI.UseCases.Partner;

import lombok.RequiredArgsConstructor;
import online.koymattprogrammer.MusicAPI.Models.Partner;
import online.koymattprogrammer.MusicAPI.Repository.PartnerRepository;
import online.koymattprogrammer.MusicAPI.UseCases.interfaces.UnitUseCase;
import online.koymattprogrammer.MusicAPI.UseCases.interfaces.UseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePartnerUseCase implements UnitUseCase<Partner> {

    private final PartnerRepository repository;

    @Override
    public void execute(Partner input) {
        repository.save(input);
    }
}
