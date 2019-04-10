package TreeTable;

import UsrCtrl.User;

public class TreeColumn {

    private User usr;
    private TreeColumn leftById, rightById, leftByName, rightByName, leftBySalary, RightBySalary;

    public TreeColumn( User usr)
    {
        this.usr = usr;
    }

    public TreeColumn getLeftById() {
        return leftById;
    }

    public TreeColumn getLeftByName() {
        return leftByName;
    }

    public TreeColumn getLeftBySalary() {
        return leftBySalary;
    }

    public TreeColumn getRightById() {
        return rightById;
    }

    public TreeColumn getRightByName() {
        return rightByName;
    }

    public TreeColumn getRightBySalary() {
        return RightBySalary;
    }

    public User getUsr() {
        return usr;
    }

    public void setLeftById(TreeColumn leftById) {
        this.leftById = leftById;
    }

    public void setLeftByName(TreeColumn leftByName) {
        this.leftByName = leftByName;
    }

    public void setLeftBySalary(TreeColumn leftBySalary) {
        this.leftBySalary = leftBySalary;
    }

    public void setRightById(TreeColumn rightById) {
        this.rightById = rightById;
    }

    public void setRightByName(TreeColumn rightByName) {
        this.rightByName = rightByName;
    }

    public void setRightBySalary(TreeColumn rightBySalary) {
        RightBySalary = rightBySalary;
    }

    public void setUsr(User usr) {
        this.usr = usr;
    }
}
