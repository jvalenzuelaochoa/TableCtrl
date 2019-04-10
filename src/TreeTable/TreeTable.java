package TreeTable;

import UsrCtrl.User;

public class TreeTable {

    private TreeColumn rootById, rootByName, rootBySalary;

    public TreeTable()
    {
      rootById = null;
      rootByName = null;
      rootBySalary = null;
    }

    public TreeColumn getRootById() {
        return rootById;
    }

    public void setRootById(TreeColumn rootById) {
        this.rootById = rootById;
    }

    public TreeColumn getRootByName() {
        return rootByName;
    }

    public void setRootByName(TreeColumn rootByName) {
        this.rootByName = rootByName;
    }

    public TreeColumn getRootBySalary() {
        return rootBySalary;
    }

    public void setRootBySalary(TreeColumn rootBySalary) {
        this.rootBySalary = rootBySalary;
    }

    public void displayByAttribute(User.userAttributes att)
    {

    }

}
