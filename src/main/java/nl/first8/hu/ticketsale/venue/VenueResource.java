package nl.first8.hu.ticketsale.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by njvan on 31-Aug-17.
 */

@RestController
@RequestMapping("/concert")
@Transactional
public class VenueResource {
    private final VenueRepository repository;

    @Autowired
    public VenueResource(VenueRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/search")
    public ResponseEntity<List<Concert>> getById(@RequestParam(value="artist", required=false) String artist, @RequestParam(value="genre", required=false) String genre, @RequestParam(value="location", required=false) String location) {
        List<Concert> result = new ArrayList<>();
        if(artist != null){
            result = repository.findConcertByArtist(artist);
        } else if(genre != null){
            result = repository.findConcertByGenre(genre);
        } else if(location != null){
            result = repository.findConcertByLocation(location);
        }
        return ResponseEntity.ok(result);
    }
}
