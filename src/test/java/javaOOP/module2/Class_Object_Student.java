package javaOOP.module2;

public class Class_Object_Student {
    private int studentID;
    private String studentname;
    private Float knowledgePoint;
    private Float practicePoint;

    private int getStudentID() {
        return studentID;
    }

    private void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    private String getStudentname() {
        return studentname;
    }

    private void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    private Float getKnowledgePoint() {
        return knowledgePoint;
    }

    private void setKnowledgePoint(Float knowledgePoint) {
        this.knowledgePoint = knowledgePoint;
    }

    private Float getPracticePoint() {
        return practicePoint;
    }

    private void setPracticePoint(Float practicePoint) {
        this.practicePoint = practicePoint;
    }

    private Float getAveragePoint() {
        return (this.knowledgePoint + this.practicePoint * 2) / 3;
    }

    private void showStudentInfor() {
        System.out.println("Student ID = " + getStudentID());
        System.out.println("Student name = " + getStudentname());
        System.out.println("Student knowledge point = " + getKnowledgePoint());
        System.out.println("Student practice point = " + getPracticePoint());
        System.out.println("Average point = " + getAveragePoint());
    }

    public static void main(String[] args) {
        Class_Object_Student fristStudent = new Class_Object_Student();
        fristStudent.setStudentID(2005101);
        fristStudent.setStudentname("Bui Thi Thanh Hang");
        fristStudent.setKnowledgePoint(8.8f);
        fristStudent.setPracticePoint(7.5f);
        fristStudent.showStudentInfor();

        Class_Object_Student secondStudent = new Class_Object_Student();
        secondStudent.setStudentID(2005102);
        secondStudent.setStudentname("Nguyen Van Hai");
        secondStudent.setKnowledgePoint(5.8f);
        secondStudent.setPracticePoint(5.5f);
        secondStudent.showStudentInfor();
    }
}
