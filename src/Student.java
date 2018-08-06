import java.util.List;

public class Student implements Comparable<Student>{
    private String studentId;
    private List<Integer> marksList;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public List<Integer> getMarksList() {
        return marksList;
    }

    public void setMarksList(List<Integer> marksList) {
        this.marksList = marksList;
    }

    public Student(String studentId, List<Integer> marksList) {
        this.studentId = studentId;
        this.marksList = marksList;
    }


    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
