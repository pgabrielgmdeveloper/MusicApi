package online.koymattprogrammer.MusicAPI.Controllers;

import lombok.RequiredArgsConstructor;
import online.koymattprogrammer.MusicAPI.Controllers.API.IMusicController;
import online.koymattprogrammer.MusicAPI.Dtos.Music.MusicInput;
import online.koymattprogrammer.MusicAPI.Models.Music;
import online.koymattprogrammer.MusicAPI.Service.interfaces.IService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MusicController implements IMusicController {

    private final IService<Music> service;

    public ResponseEntity<Void> CreateMusic(MusicInput input, String partnerKey) {
        service
                .create(
                        Music.builder()
                                .URI(input.URI())
                                .name(input.name())
                                .letter(input.letter())
                                .partnerKey(partnerKey)
                                .groupId(new ObjectId(input.groupId()))
                                .build()
                );
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
