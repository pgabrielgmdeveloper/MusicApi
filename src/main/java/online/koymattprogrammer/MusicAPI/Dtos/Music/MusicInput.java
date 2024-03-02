package online.koymattprogrammer.MusicAPI.Dtos.Music;

import online.koymattprogrammer.MusicAPI.Models.Partner;
import org.bson.types.ObjectId;

public record MusicInput(String name, String letter, String URI, String groupId) {

}
