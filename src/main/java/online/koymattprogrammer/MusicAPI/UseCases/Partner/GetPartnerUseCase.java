package online.koymattprogrammer.MusicAPI.UseCases.Partner;

import lombok.RequiredArgsConstructor;
import online.koymattprogrammer.MusicAPI.Models.Partner;
import online.koymattprogrammer.MusicAPI.Repository.PartnerRepository;
import online.koymattprogrammer.MusicAPI.UseCases.interfaces.UseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPartnerUseCase implements UseCase<String, Partner> {

    private final PartnerRepository repository;
    @Override
    public Partner execute(String value) {
        return repository.findPartnerByPartner(value).orElseGet(() -> Partner.builder().build());
    }
}
