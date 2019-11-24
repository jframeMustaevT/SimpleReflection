package part01.lesson04.tak04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UtilReflectionTest {
    MusicArt musicArt;
    Set<String>fieldsToCleanup;
    Set<String>fieldsToOutput;
    Map map;
    private List albums;

    @BeforeEach
    void impose() {
        List<MusicRef>musicRefList= new ArrayList<MusicRef>()
        {{
            add(new MusicRef("Rap",23));
             add(new MusicRef("Rock",32));
        }};

        musicArt=new MusicArt(
                2334,"Antony",albums,3245f);
        fieldsToCleanup=new HashSet<String>()
        {{
            add("nubSongs");
            add("typeGenre");
            add("albums");
            add("payCheck");
        }};
        fieldsToOutput=new HashSet<String>()
        {{
            add("albums");
            add("payCheck");
            add("nubSongs");
            add("typeGenre");

        }};
        map=new HashMap()
        {{
            put("albums","SunVerdom");
            put("payCheck", "2000$");
            put("nubSongs","23456");
            put("typeGenre","jazz");

        }};

}

    @Test
    void cleanup() throws NoSuchFieldException, IllegalAccessException {
        UtilReflection.cleanup(musicArt,fieldsToCleanup,fieldsToOutput);
        assertNull(musicArt.getTypeGenre());
        assertEquals(0,musicArt.getNumbSongs());
        assertNull(musicArt.getAlbums());
        assertEquals(0,musicArt.getPayCheck());

        UtilReflection.cleanup(map,fieldsToCleanup,fieldsToOutput);
        assertNull(map.get("albums"));
        assertNull(map.get("payCheck"));
        assertNull(map.get("nubSongs"));
        assertNull(map.get("typeGenre"));
    }
}