package part01.lesson04.tak04;

public class MusicReflection {
    private Integer id;
    private String name;

    public MusicReflection() {
    }

    public MusicReflection(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MusicReflection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
