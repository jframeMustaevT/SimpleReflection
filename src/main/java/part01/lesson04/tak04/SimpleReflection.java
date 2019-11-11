package part01.lesson04.tak04;

public class SimpleReflection {
    public static void main(String[] args) {

        MusicReflection musicReflection1 = new MusicReflection();
        MusicReflection musicReflection2 = new MusicReflection(1,"Music");
        UltilsReflection.cleanup(musicReflection1,musicReflection2);
        System.out.println(musicReflection2);


    }
}