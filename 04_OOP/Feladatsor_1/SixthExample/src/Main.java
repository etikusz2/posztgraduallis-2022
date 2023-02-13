import Collection.StudentIterator;
import Collection.StudentList;
import Core.Student;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Laci ", 25, " Law");
        Student s2 = new Student("Gyuri ", 23, " Mathematics");

        StudentList sl = new StudentList(5);
        sl.addStudents(s1);
        sl.addStudents(s2);

        for (StudentIterator si = sl.getIterator(); si.hasMoreElements();) {
            System.out.println(si.nextElements());
        }

        StudentIterator si1 = sl.getIterator();
        while (si1.hasMoreElements()){
            System.out.println(si1.nextElements());
        }
    }
}