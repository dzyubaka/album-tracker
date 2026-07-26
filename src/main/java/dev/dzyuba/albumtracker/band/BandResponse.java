package dev.dzyuba.albumtracker.band;

public record BandResponse(
        Long id,
        String name
) {
    static BandResponse from(Band entity) {
        return new BandResponse(entity.getId(), entity.getName());
    }
}
