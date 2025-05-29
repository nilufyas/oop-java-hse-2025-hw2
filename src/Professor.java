public class Professor extends UniversityMember {
    private String department;

    public Professor(String name, int id, String department) {
        super(name, id);
        this.department = department;
    }

    @Override
    public String getDetails() {
        return "ID преподавателя: " + id + ", Имя: " + name + ", кафедра: " + department;
    }
}
