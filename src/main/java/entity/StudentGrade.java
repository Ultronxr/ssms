package entity;

public class StudentGrade {
    String schoolYear;
    String semester;
    String courseId;
    String courseName;
    String category;
    double credit;
    int score;
    String teacher;
    String studentId;
    String studentName;
    String sex;
    String studentType;
    String institute;
    String Major;
    String grade;
    String studentClass;
    public StudentGrade(){}
    public StudentGrade(String schoolYear, String semester, String courseId, String courseName, String category, double credit, int score, String teacher, String studentId, String studentName, String sex, String studentType, String institute, String major, String grade, String studentClass) {
        this.schoolYear = schoolYear;
        this.semester = semester;
        this.courseId = courseId;
        this.courseName = courseName;
        this.category = category;
        this.credit = credit;
        this.score = score;
            this.teacher = teacher;
        this.studentId = studentId;
        this.studentName = studentName;
        this.sex = sex;
        this.studentType = studentType;
        this.institute = institute;
        Major = major;
        this.grade = grade;
        this.studentClass = studentClass;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
}
