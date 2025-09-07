// Student.java
public class Student1 {
    // Fields (instance variables)
    private int id;
    private String name;
    private int age;
    private String course;

    // Constructor
    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Getter methods (accessors)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    // Setter methods (mutators)
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // Method to display student info
    public void displayInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Name      : " + name);
        System.out.println("Age       : " + age);
        System.out.println("Course    : " + course);
        System.out.println("----------------------------");
    }

    // Main method to test class
    public static void main(String[] args) {
        // Object instantiation
        Student s1 = new Student(101, "Snehal", 20, "Computer Science");
        Student s2 = new Student(102, "Rahul", 21, "Mechanical Engineering");

        // Display student details
        s1.displayInfo();
        s2.displayInfo();

        // Updating values using setters
        s1.setAge(22);
        s1.setCourse("Data Science");

        System.out.println("After updating Snehal's details:");
        s1.displayInfo();
    }
}
