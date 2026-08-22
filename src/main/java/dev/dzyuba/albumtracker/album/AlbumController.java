package dev.dzyuba.albumtracker.album;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bands/{bandId}/albums")
@RequiredArgsConstructor
public class AlbumController {
    private final AlbumService albumService;

    @GetMapping
    public List<AlbumResponse> list(@PathVariable Long bandId) {
        return albumService.findByBandId(bandId);
    }

    @PostMapping
    public AlbumResponse create(@PathVariable Long bandId, @RequestBody Album album) {
        return albumService.save(bandId, album);
    }

    @PutMapping("/{albumId}")
    public AlbumResponse update(@PathVariable Long bandId, @PathVariable Long albumId, @RequestBody Album album) {
        return albumService.update(bandId, albumId, album);
    }

    @DeleteMapping("/{albumId}")
    public void delete(@PathVariable Long bandId, @PathVariable Long albumId) {
        albumService.deleteById(albumId);
    }
}
