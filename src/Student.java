public class Student extends UniversityMember {
    private String major;

    public Student(String name, int id, String major) {
        super(name, id);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String getDetails() {
        return "ID студента: " + id + ", Имя: " + name + ", специальность: " + major;
    }

    // Геттер для id
    public int getId() {
        return id;
    }
}