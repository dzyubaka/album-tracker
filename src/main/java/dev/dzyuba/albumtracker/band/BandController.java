package dev.dzyuba.albumtracker.band;

import dev.dzyuba.albumtracker.album.Album;
import dev.dzyuba.albumtracker.album.AlbumResponse;
import dev.dzyuba.albumtracker.album.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bands")
@RequiredArgsConstructor
public class BandController {
    private final BandService bandService;

    private final AlbumService albumService;

    @GetMapping
    public List<BandResponse> findAll() {
        return bandService.findAll();
    }

    @GetMapping("/{bandId}")
    public BandResponse band(@PathVariable Long bandId) {
        return bandService.findById(bandId);
    }

    @PostMapping
    public BandResponse save(@RequestBody Band band) {
        return bandService.save(band);
    }

    @GetMapping("/{bandId}/albums")
    public List<AlbumResponse> albums(@PathVariable Long bandId) {
        return albumService.findByBandId(bandId);
    }

    @PostMapping("/{bandId}/albums")
    public AlbumResponse albums(@PathVariable Long bandId, @RequestBody Album album) {
        return albumService.save(bandId, album);
    }

    @PutMapping("/{bandId}/albums/{albumId}")
    public AlbumResponse albums(@PathVariable Long bandId, @PathVariable Long albumId, @RequestBody Album album) {
        return albumService.update(bandId, albumId, album);
    }

    @DeleteMapping("/{bandId}/albums/{albumId}")
    public void albums(@PathVariable Long bandId, @PathVariable Long albumId) {
        albumService.deleteById(albumId);
    }
}
