package UsrCtrl;

import java.util.Objects;

public class User {

    public enum userAttributes
    {
        ID, NAME, SALARY;
    }

    private Integer id;
    private String name;
    private Integer salary;

    public User(Integer id, String name, Integer salary)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;

    }

    public Object GetElement(userAttributes elementName)
    {
        switch (elementName)
        {
            case ID:
            {
                return getId();
            }
            case NAME:
            {
                return  getName();
            }
            case SALARY:
            {
                return getSalary();
            }
        }
        return null;
    }

    public void setElement(userAttributes elementName, Object element )
    {
        switch (elementName)
        {
            case ID:
            {
                if (!(element instanceof Integer))
                {
                    throw new IllegalArgumentException ("Element type mismatch");
                }
                else
                {
                    setId((Integer)element);
                }
            }
            case NAME:
            {
                if (!(element instanceof String))
                {
                    throw new IllegalArgumentException ("Element type mismatch");
                }
                else
                {
                    setName((String)element);
                }
            }
            case SALARY:
            {
                if (!(element instanceof Integer))
                {
                    throw new IllegalArgumentException ("Element type mismatch");
                }
                else
                {
                    setSalary((Integer)element);
                }
            }
        }
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ID: " + id.toString() + "; NAME: " + name + "; SALARY: " + salary.toString();
    }

    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return salary.equals(user.salary) &&
                Objects.equals(name, user.name) &&
                id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, salary);
    }
}
