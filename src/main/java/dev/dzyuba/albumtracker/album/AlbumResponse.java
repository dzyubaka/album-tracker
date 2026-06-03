package dev.dzyuba.albumtracker.album;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AlbumResponse(
    Long id,
    String name,
    LocalDate released,
    LocalDateTime listened
) {
}
