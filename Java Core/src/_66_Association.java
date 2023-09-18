// Define a class representing a Student
class Student {
    private String name;
    public Student(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

// Define a class representing a Course
class Course {
    private String courseName;
    public Course(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseName() {
        return courseName;
    }
}

// Aggregation: Student has a reference to Course
class StudentAggregation {
    private String name;
    private Course course; // Student has-a Course

    public StudentAggregation(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }
}

// Composition: Student is composed of Course
class StudentComposition {
    private String name;
    private Course course; // Student is composed of Course
    public StudentComposition(String name, String courseName) {
        this.name = name;
        this.course = new Course(courseName); // Creating a Course object as part of StudentComposition
    }
    public String getName() {
        return name;
    }
    public Course getCourse() {
        return course;
    }
}

public class _66_Association {
    public static void main(String[] args) {
        // Create instances of Student and Course
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        // Create associations (enroll students in courses)
        StudentAggregation studentAggregation = new StudentAggregation("Charlie", new Course("Physics"));
        StudentComposition studentComposition = new StudentComposition("David", "Chemistry");
        // Access and display information using associations
        System.out.println(studentAggregation.getName() + " is enrolled in " + studentAggregation.getCourse().getCourseName());
        // Access and display information using composition
        System.out.println(studentComposition.getName() + " is enrolled in " + studentComposition.getCourse().getCourseName());
    }
}
