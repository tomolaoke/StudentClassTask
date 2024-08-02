import java.util.Arrays;
import java.util.List;

enum Level {
    Level_One,
    Level_Two,
    Level_Three
}

class Human {
    String name;
    String role;

    Human(String name, String role) {
        this.name = name;
        this.role = role;
    }

    void printResponsibilities() {
        System.out.println("Default responsibilities for a human.");
    }
}

class Student extends Human {
    private boolean graduated;
    private boolean expelled;
    private Level level;

    Student(String name) {
        super(name, "Student");
        this.graduated = false;
        this.expelled = false;
        this.level = Level.Level_One;
    }

    Level getLevel() {
        return level;
    }

    boolean isGraduated() {
        return graduated;
    }

    boolean isExpelled() {
        return expelled;
    }

    void promote() {
        List<Level> levels = Arrays.asList(Level.values());
        int currentIndex = levels.indexOf(level);
        if (currentIndex < levels.size() - 1) {
            level = levels.get(currentIndex + 1);
        }
    }

    void demote() {
        List<Level> levels = Arrays.asList(Level.values());
        int currentIndex = levels.indexOf(level);
        if (currentIndex > 0) {
            level = levels.get(currentIndex - 1);
        }
    }

    void expel() {
        expelled = true;
    }

    void graduate() {
        graduated = true;
    }

    @Override
    void printResponsibilities() {
        System.out.println("Student responsibilities:");
        System.out.println("- Attend classes");
        System.out.println("- Complete assignments");
        System.out.println("- Participate in extracurricular activities");
        System.out.println("- Maintain good academic standing");
    }
}

public class Module6JavaIVAssignmentDay21 {
    public static void main(String[] args) {
        Student student = new Student("John Doe");
        System.out.println("Name: " + student.name);
        System.out.println("Role: " + student.role);
        System.out.println("Level: " + student.getLevel());
        System.out.println("Graduated: " + student.isGraduated());
        System.out.println("Expelled: " + student.isExpelled());

        student.printResponsibilities(); // Call printResponsibilities() method

        student.promote();
        System.out.println("\nAfter promotion:");
        System.out.println("Level: " + student.getLevel());

        student.demote(); // Call demote() method
        System.out.println("\nAfter demotion:");
        System.out.println("Level: " + student.getLevel());

        student.expel(); // Call expel() method
        System.out.println("\nAfter expulsion:");
        System.out.println("Expelled: " + student.isExpelled());

        student.graduate();
        System.out.println("\nAfter graduation:");
        System.out.println("Graduated: " + student.isGraduated());
    }
}
