package online.koymattprogrammer.MusicAPI.Service;

import lombok.RequiredArgsConstructor;
import online.koymattprogrammer.MusicAPI.Models.Music;
import online.koymattprogrammer.MusicAPI.Models.Partner;
import online.koymattprogrammer.MusicAPI.Service.interfaces.IDeleteService;
import online.koymattprogrammer.MusicAPI.Service.interfaces.IService;
import online.koymattprogrammer.MusicAPI.UseCases.Music.CreateMusicUseCase;
import online.koymattprogrammer.MusicAPI.UseCases.Music.DeleteMusicUseCase;
import online.koymattprogrammer.MusicAPI.UseCases.Music.GetAllMusicUseCase;
import online.koymattprogrammer.MusicAPI.UseCases.Music.GetMusicUseCase;
import online.koymattprogrammer.MusicAPI.UseCases.Partner.CreatePartnerUseCase;
import online.koymattprogrammer.MusicAPI.UseCases.Partner.GetPartnerUseCase;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService implements IService<Music>, IDeleteService {

    private final CreateMusicUseCase createMusicUseCase;
    private final DeleteMusicUseCase deleteMusicUseCase;
    private final GetAllMusicUseCase getAllMusicUseCase;
    private final GetMusicUseCase getMusicUseCase;
    private final GetPartnerUseCase getPartnerUseCase;
    private final CreatePartnerUseCase createPartnerUseCase;
    @Override
    public void create(Music value) {
        final var partner = getPartnerUseCase.execute(value.partnerKey);
        if (!partner.partnerKey.equals(value.partnerKey)){
            //TODO BUSCAR NA API DE PARTNERS E SALVAR
            final var partnerCreate = Partner
                    .builder()
                    .partnerId("Id parnter")
                    .partnerKey("adjaf-lot-saobraz")
                    .name("Assembleia de deus lotamento sao braz")
                    .build();
            createPartnerUseCase.execute(partnerCreate);
            value.partnerKey = partnerCreate.partnerKey;
        }
        createMusicUseCase.execute(value);
    }
    @Override
    public Music get(ObjectId id) {
        return getMusicUseCase.execute(id);
    }
    @Override
    public List<Music> getAll(List<?> parameters) {
        return getAllMusicUseCase.execute(parameters);
    }
    @Override
    public void delete(ObjectId id) {
        final var music = getMusicUseCase.execute(id);
        if (music._id == id) {
            deleteMusicUseCase.execute(id);
        }
    }
}
