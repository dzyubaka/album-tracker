package dev.dzyuba.albumtracker.album;

import java.time.LocalDateTime;

public record AlbumResponse(
    Long id,
    String name,
    LocalDateTime listened
) {
}
