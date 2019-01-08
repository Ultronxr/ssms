package entity;

public class Student {
    String id;
    String name;
    int age;
    String sex;
    String institute;
    String major;
    String studentClass;
    String birthday;
    String startTime;
    String grade;
    double credit;
    String source;
    String nationality;
    String type;
    String politicalStatus;
    double gpa;
    String status;
    public Student(String id, String name, int age, String sex, String institute, String major, String studentClass, String birthday, String startTime,String grade, double credit,String status,String source, String nationality, String type, String politicalStatus, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.institute = institute;
        this.major = major;
        this.studentClass = studentClass;
        this.birthday = birthday;
        this.startTime = startTime;
        this.grade = grade;
        this.credit = credit;
        this.source = source;
        this.nationality = nationality;
        this.type = type;
        this.politicalStatus = politicalStatus;
        this.gpa = gpa;
        this.status=status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Student(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String toString(){
        return "{\"id:\""+id
                +",\"name\":"+name
                +",\"age\":"+age
                +",\"sex\":"+sex
                +",\"institute\":"+institute
                +",\"major\":"+major
                +",\"studentClass\":"+studentClass
                +",\"birthday\":"+birthday
                +",\"startTime\":"+startTime
                +",\"grade\":"+grade
                +",\"credit\":"+credit
                +",\"source\":"+source
                +",\"nationality\":"+nationality
                +",\"type\":"+type
                +",\"politicalStatus\":"+politicalStatus
                +",\"gpa\":"+gpa
                +"}";
    }
}
