// Base class (Parent)
class
 {
    protected String name;
    protected int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Common method
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age : " + age);
    }
}

// Derived class (Child 1)
class Student extends Person {
    private String course;

    public Student(String name, int age, String course) {
        super(name, age);  // reusing Person constructor
        this.course = course;
    }

    public void displayStudent() {
        super.displayInfo();  // reusing Person method
        System.out.println("Course: " + course);
        System.out.println("----------------------");
    }
}

// Derived class (Child 2)
class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void displayTeacher() {
        super.displayInfo();
        System.out.println("Subject: " + subject);
        System.out.println("----------------------");
    }
}

// Main class
public class OOPReusabilityDemo {
    public static void main(String[] args) {
        // Create objects
        Student s1 = new Student("Snehal", 20, "Computer Science");
        Teacher t1 = new Teacher("Rahul Sir", 35, "Mathematics");

        // Display info
        s1.displayStudent();
        t1.displayTeacher();
    }
}
