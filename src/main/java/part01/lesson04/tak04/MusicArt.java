package part01.lesson04.tak04;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicArt {

    private int numbSongs;
    private String typeGenre;
    private List albums;
    private float payCheck;


}
