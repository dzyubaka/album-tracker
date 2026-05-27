package dev.dzyuba.albumtracker.band;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bands")
@RequiredArgsConstructor
public class BandController {
    private final BandRepository bandRepository;

    @GetMapping
    public List<Band> findAll() {
        return bandRepository.findAll();
    }
}
