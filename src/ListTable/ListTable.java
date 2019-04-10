package ListTable;

public class ListTable {
    private ListColumn headById, headByName, headBySalary;
    private ListColumn tailById, tailByName, tailBySalary;

    public ListTable()
    {
      headById = null;
      headByName = null;
      headBySalary = null;
      tailById = null;
      tailByName = null;
      tailBySalary = null;
    }

    public ListColumn getHeadById() {
        return headById;
    }

    public void setHeadById(ListColumn headById) {
        this.headById = headById;
    }

    public ListColumn getHeadByName() {
        return headByName;
    }

    public void setHeadByName(ListColumn headByName) {
        this.headByName = headByName;
    }

    public ListColumn getHeadBySalary() {
        return headBySalary;
    }

    public void setHeadBySalary(ListColumn headBySalary) {
        this.headBySalary = headBySalary;
    }

    public ListColumn getTailById() {
        return tailById;
    }

    public void setTailById(ListColumn tailById) {
        this.tailById = tailById;
    }

    public ListColumn getTailByName() {
        return tailByName;
    }

    public void setTailByName(ListColumn tailByName) {
        this.tailByName = tailByName;
    }

    public ListColumn getTailBySalary() {
        return tailBySalary;
    }

    public void setTailBySalary(ListColumn tailBySalary) {
        this.tailBySalary = tailBySalary;
    }
}
