import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();
        List<Student> students = studentDAO.getAll();

        printStudent(students);


    }

    static void printStudent(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.toString());
        }

    }

    static Student requestStudent() {
        Scanner scanner = new Scanner(System.in);

        // --- insert new product ---
        System.out.print("Introduzca el nocontrol: ");
        String nocontrol = scanner.nextLine();

        System.out.print("Introduzca el nombre completo: ");
        String fullname = scanner.nextLine();

        System.out.print("Introduzca la carrera: ");
        String career = scanner.nextLine();

        System.out.print("Introduzca la CURP: ");
        String curp = scanner.nextLine();

        System.out.print("Introduzca el grado actual: ");
        Integer currentGrade = Integer.parseInt(scanner.nextLine());

        Student student = new Student(nocontrol, fullname,career, curp, currentGrade);
        scanner.close();
        return student;
    }
}