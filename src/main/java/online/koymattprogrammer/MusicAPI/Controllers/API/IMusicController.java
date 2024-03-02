package online.koymattprogrammer.MusicAPI.Controllers.API;
import online.koymattprogrammer.MusicAPI.Dtos.Music.MusicInput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/music")
public interface IMusicController {

    @PostMapping
    ResponseEntity<Void> CreateMusic(@RequestBody MusicInput input, @RequestParam(name = "partnerKey") String partnerKey);


}
