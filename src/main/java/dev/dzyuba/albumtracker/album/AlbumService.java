package dev.dzyuba.albumtracker.album;

import dev.dzyuba.albumtracker.band.BandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final BandRepository bandRepository;

    private final AlbumRepository albumRepository;

    public List<AlbumResponse> findByBandId(Long bandId) {
        return albumRepository.findByBandId(bandId).stream().map(a -> new AlbumResponse(a.getId(), a.getName(), a.getListened())).toList();
    }

    public AlbumResponse save(Long bandId, Album album) {
        album.setBand(bandRepository.findById(bandId).orElseThrow());
        album = albumRepository.save(album);
        return new AlbumResponse(album.getId(), album.getName(), album.getListened());
    }

    public void deleteById(Long albumId) {
        albumRepository.deleteById(albumId);
    }
}
