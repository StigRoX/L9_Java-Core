package core.directory;

public class Course {
    private String name;
    public Course(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public String toString() {
        return getName();
    }
}
