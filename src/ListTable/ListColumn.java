package ListTable;

import UsrCtrl.User;

public class ListColumn {

    private User usr;
    private ListColumn nextById, nextByName, nextBySalary;

    public void setUsr(User usr) {
        this.usr = usr;
    }

    public User getUsr() {
        return usr;
    }

    public ListColumn getNextById() {
        return nextById;
    }

    public ListColumn getNextByName() {
        return nextByName;
    }

    public ListColumn getNextBySalary() {
        return nextBySalary;
    }

    public void setNextById(ListColumn nextById) {
        this.nextById = nextById;
    }

    public void setNextByName(ListColumn nextByName) {
        this.nextByName = nextByName;
    }

    public void setNextBySalary(ListColumn nextBySalary) {
        this.nextBySalary = nextBySalary;
    }
}
