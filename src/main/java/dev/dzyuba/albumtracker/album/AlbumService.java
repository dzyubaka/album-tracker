package dev.dzyuba.albumtracker.album;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumRepository albumRepository;

    public List<AlbumResponse> findByBandId(Long bandId) {
        return albumRepository.findByBandId(bandId).stream().map(a -> new AlbumResponse(a.getId(), a.getName())).toList();
    }
}
