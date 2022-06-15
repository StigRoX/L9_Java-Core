package core.directory;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    // Метод, возвращающий список уникальных курсов, на которые подписаны студенты
    static private List<Course> getUniqueCourses(List<Student> students) {
        return students.stream() // Получаем поток из списка пользователей
                .flatMap(student -> student.getAllCourses().stream()) // Объединяем все их списки курсов, преобразованные в потоки, в один поток.
                .distinct() // Фильтруем уникальные курсы
                .collect(Collectors.toList()); // Собираем в список и возвращаем
    }

    // Метод, возвращающий список трёх самых любопытных студентов по числу курсов
    static private List<Student> getCuriousStudents(List<Student> students) {
        return students.stream()
                // Сортируем поток, вычитая из числа курсов второго студента число курсов первого
                // Таким образом, они сортируются по убыванию числа курсов
                .sorted((a, b) -> b.getAllCourses().size() - a.getAllCourses().size())
                .limit(3) // Ограничиваем поток тремя элементами
                .collect(Collectors.toList()); // Собираем и возвращаем список
    }

    // Метод, возвращающий список студентов, посещающих конкретный курс
    static private List<Student> getAttendingStudents(List<Student> students, Course course) {
        return students.stream()
                .filter(student -> student.getAllCourses().contains(course)) // Фильтруем студентов по наличию курса среди посещаемых
                .collect(Collectors.toList()); // Собираем в список
    }

    public static void main(String args[]) {
        Student mike = new Student("Mike");
        Student alex = new Student("Alex");
        Student josh = new Student("Josh");
        Student mark = new Student("Mark");
        Student gregory = new Student("Gregory");
        Course biology = new Course("Biology");
        Course chemistry = new Course("Chemistry");
        Course math = new Course("Math");
        Course english = new Course("English");
        Course history = new Course("History");

        mark.addCourses(Arrays.asList(biology, chemistry));
        mike.addCourses(Arrays.asList(biology, math, english));
        josh.addCourses(Arrays.asList(math, chemistry));
        alex.addCourse(english);
        gregory.addCourses(Arrays.asList(chemistry, english, history));

        List<Student> students = Arrays.asList(gregory, mark, mike, josh, alex);

        System.out.println("Список уникальных курсов, посещаемых студентами:");
        System.out.println(getUniqueCourses(students));
        System.out.println("Список трёх самых любознательных студентов:");
        System.out.println(getCuriousStudents(students));
        System.out.println("Список студентов, посещающих курсы математики:");
        System.out.println(getAttendingStudents(students, math));
    }
}
