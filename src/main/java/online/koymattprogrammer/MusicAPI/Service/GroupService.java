package online.koymattprogrammer.MusicAPI.Service;

import lombok.RequiredArgsConstructor;
import online.koymattprogrammer.MusicAPI.Models.Group;
import online.koymattprogrammer.MusicAPI.Models.Partner;
import online.koymattprogrammer.MusicAPI.Service.interfaces.IService;
import online.koymattprogrammer.MusicAPI.UseCases.Group.CreatGroupUseCase;
import online.koymattprogrammer.MusicAPI.UseCases.Group.GetAllGroupsUseCase;
import online.koymattprogrammer.MusicAPI.UseCases.Group.GetGroupUseCase;
import online.koymattprogrammer.MusicAPI.UseCases.Partner.CreatePartnerUseCase;
import online.koymattprogrammer.MusicAPI.UseCases.Partner.GetPartnerUseCase;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService implements IService<Group> {

    private final CreatGroupUseCase creatGroupUseCase;
    private final GetAllGroupsUseCase  getAllGroupsUseCase;
    private final GetGroupUseCase getGroupUseCase;
    private final GetPartnerUseCase getPartnerUseCase;
    private final CreatePartnerUseCase createPartnerUseCase;

    @Override
    public void create(Group value) {
        final var partner = getPartnerUseCase.execute(value.partnerKey);
        if (partner.partnerKey == null) {
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
        creatGroupUseCase.execute(value);
    }

    @Override
    public Group get(ObjectId id) {
        return getGroupUseCase.execute(id);
    }

    @Override
    public List<Group> getAll(List<?> parameters) {
        return getAllGroupsUseCase.execute(parameters.get(0).toString());
    }

}
