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
    public int compareTo(Student s2) {
        int greater = 0;
        int lesser = 0;

        if(s2.getMarksList().size() == this.getMarksList().size()){
            for (int i = 0; i < this.getMarksList().size(); i++) {
                int m1 = this.getMarksList().get(i);
                int m2 = s2.getMarksList().get(i);

                if(m1 > m2)
                    greater++;
                else if(m1 < m2)
                    lesser++;
                else
                    return 0;

                if(greater > 0 && lesser > 0)
                    return 0;
            }

            if(greater == this.marksList.size())
                return 1;

            if(lesser == this.marksList.size())
                return -1;
        }
        return 0;
    }
}
