package UsrCtrl;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private int salary;

    public User(int id, String name, int salary)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;

    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return salary == user.salary &&
                Objects.equals(name, user.name) &&
                id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, salary);
    }
}
