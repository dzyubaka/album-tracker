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

    @GetMapping("/{id}/albums")
    public List<AlbumResponse> albums(@PathVariable Long id) {
        return albumService.findByBandId(id);
    }

    @PostMapping("/{id}/albums")
    public AlbumResponse albums(@PathVariable Long id, @RequestBody Album album) {
        return albumService.save(id, album);
    }
}
