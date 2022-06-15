package core.directory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Student {
    private String name;
    private List<Course> courses;

    public Student(String name){
        this.name = name;
        this.courses = new ArrayList<Course>();
    }

    public String getName() {
        return this.name;
    }
    public String toString() {
        return getName();
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void addCourses(Collection<Course> courses) {
        this.courses.addAll(courses);
    }

    public List<Course> getAllCourses() {
        return this.courses;
    }
}
