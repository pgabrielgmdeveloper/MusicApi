package online.koymattprogrammer.MusicAPI.Models;
import lombok.Builder;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
public class Music  {

    @BsonId
    public ObjectId _id;
    public String name;
    public String URI;
    public String letter;
    public ObjectId groupId;
    public String partnerKey;

}
