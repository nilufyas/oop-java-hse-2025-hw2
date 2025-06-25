public abstract class UniversityMember implements Person {
    protected String name;
    protected int id;

    public UniversityMember(String name, int id) {
        this.name = name;
        this.id   = id;
    }

    /** Возвращает идентификатор участника (студента или профессора). */
    public int getId() {
        return id;
    }

    @Override
    public abstract String getDetails();
}