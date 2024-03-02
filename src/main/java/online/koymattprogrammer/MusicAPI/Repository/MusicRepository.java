package online.koymattprogrammer.MusicAPI.Repository;

import online.koymattprogrammer.MusicAPI.Models.Music;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends MongoRepository<Music, ObjectId> {

    @Query("{'group' : ?0, 'partnerKey' : ?1}")
    List<Music> finAllByPartnerKeyAndGroup(ObjectId group, String partnerKey);

}
