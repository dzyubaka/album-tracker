package dev.dzyuba.albumtracker.band;

import dev.dzyuba.albumtracker.album.Album;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "band")
    private List<Album> albums;
}
