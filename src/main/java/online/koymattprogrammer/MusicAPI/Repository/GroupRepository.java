package online.koymattprogrammer.MusicAPI.Repository;

import online.koymattprogrammer.MusicAPI.Models.Group;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends MongoRepository<Group, ObjectId> {

    @Query("{'partnerKey': ?0}")
    List<Group> findAllGetGroupByPartnerKey(String partnerKey);

}
