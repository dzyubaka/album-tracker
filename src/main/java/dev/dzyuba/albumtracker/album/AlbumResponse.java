package dev.dzyuba.albumtracker.album;

public record AlbumResponse(
    Long id,
    String name,
    boolean listened
) {
}
