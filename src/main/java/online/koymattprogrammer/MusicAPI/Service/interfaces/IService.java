package online.koymattprogrammer.MusicAPI.Service.interfaces;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public interface IService<T>  {

    void create(T value);

    T get(ObjectId id);

    List<T> getAll(List<?> parameters);



}
