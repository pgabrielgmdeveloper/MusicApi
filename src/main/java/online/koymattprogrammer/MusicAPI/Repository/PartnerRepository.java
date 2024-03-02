package online.koymattprogrammer.MusicAPI.Repository;

import online.koymattprogrammer.MusicAPI.Models.Partner;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartnerRepository extends MongoRepository<Partner, ObjectId> {

    @Query("{'partnerKey': ?0}")
    Optional<Partner> findPartnerByPartner(String partner);


}
