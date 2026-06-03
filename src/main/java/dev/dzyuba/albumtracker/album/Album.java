package dev.dzyuba.albumtracker.album;

import dev.dzyuba.albumtracker.band.Band;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "band_id")
    private Band band;

    private String name;

    private LocalDate released;

    private LocalDateTime listened;
}
