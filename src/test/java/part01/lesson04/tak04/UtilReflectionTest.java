package part01.lesson04.tak04;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UtilReflectionTest {

    @org.junit.jupiter.api.Test
    public  void cleanupObjectSetValue() throws NoSuchFieldException, IllegalAccessException {
        MusicRef musicRef= new MusicRef(2,"Jack","Pop","RapList");
        UtilReflection utilReflection=new UtilReflection();
        Set<String> stringSet=new HashSet<>();
        stringSet.add("name");
        Set<String>stringsSet=new HashSet<>();
        stringsSet.add("typeGenre");
        utilReflection.cleanup(musicRef,stringSet,stringsSet);
        assertEquals(musicRef.getName(),("Jack"));
        assertEquals(musicRef.getTypeGenre(),("Pop"));

    }
    @Test
    public void cleanupMapSetValue() {
        UtilReflection utilReflection= new UtilReflection();
        Map<Integer,MusicRef> musicRefMap=new HashMap();
        musicRefMap.put(3,new MusicRef(6,"Nick","Rock","jaz"));
        musicRefMap.put(4,new MusicRef(7,"Rob","Rap","blues"));
        assertEquals(musicRefMap.get(4).getTypeGenre(),("Rap"));
        assertEquals(musicRefMap.get(3).getName(),("Nick"));

    }
}
