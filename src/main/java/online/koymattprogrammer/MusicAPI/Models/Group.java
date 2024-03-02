package online.koymattprogrammer.MusicAPI.Models;

import com.mongodb.client.model.Collation;
import lombok.Builder;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class Group {

    @BsonId
    public ObjectId _id;
    public String name;
    public String partnerKey;


}
