package dev.dzyuba.albumtracker.album;

import dev.dzyuba.albumtracker.band.BandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final BandRepository bandRepository;

    private final AlbumRepository albumRepository;

    public List<AlbumResponse> findByBandId(Long bandId) {
        return albumRepository.findByBandIdOrderByReleased(bandId).stream().map(AlbumResponse::from).toList();
    }

    public AlbumResponse save(Long bandId, Album album) {
        album.setBand(bandRepository.findById(bandId).orElseThrow());
        return AlbumResponse.from(albumRepository.save(album));
    }

    public void deleteById(Long albumId) {
        albumRepository.deleteById(albumId);
    }

    public AlbumResponse update(Long bandId, Long albumId, Album album) {
        Album oldAlbum = bandRepository.findById(bandId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                .getAlbums()
                .stream()
                .filter(a -> a.getId().equals(albumId))
                .findAny()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        oldAlbum.setName(album.getName());
        oldAlbum.setReleased(album.getReleased());
        oldAlbum.setListened(album.getListened());
        return AlbumResponse.from(albumRepository.save(oldAlbum));
    }
}
