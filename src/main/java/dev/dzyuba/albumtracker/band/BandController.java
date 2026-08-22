package dev.dzyuba.albumtracker.band;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bands")
@RequiredArgsConstructor
public class BandController {
    private final BandService bandService;

    @GetMapping
    public List<BandResponse> list() {
        return bandService.findAll();
    }

    @GetMapping("/{bandId}")
    public BandResponse get(@PathVariable Long bandId) {
        return bandService.findById(bandId);
    }

    @PostMapping
    public BandResponse create(@RequestBody Band band) {
        return bandService.save(band);
    }
}
