package online.koymattprogrammer.MusicAPI.Models;

import lombok.Builder;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
@Builder
public class Partner {

    @BsonId
    public ObjectId _id;
    public String name;
    public String partnerKey;
    public String partnerId;
}
