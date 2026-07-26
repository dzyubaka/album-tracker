package dev.dzyuba.albumtracker.band;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BandService {
    private final BandRepository bandRepository;

    public List<BandResponse> findAll() {
        return bandRepository.findAll(Sort.by("name")).stream().map(BandResponse::from).toList();
    }

    public BandResponse save(Band band) {
        return BandResponse.from(bandRepository.save(band));
    }
}
