package dev.dzyuba.albumtracker.band;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BandService {
    private final BandRepository bandRepository;

    public List<BandResponse> findAll() {
        return bandRepository.findAll().stream().map(b -> new BandResponse(b.getId(), b.getName())).toList();
    }
}
