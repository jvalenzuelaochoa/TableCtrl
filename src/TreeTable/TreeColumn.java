package TreeTable;

import UsrCtrl.User;

import java.util.HashMap;

public class TreeColumn {

    private User usr;
    HashMap<User.userAttributes, TreeColumn> left;
    HashMap<User.userAttributes, TreeColumn> right;
    HashMap<User.userAttributes, TreeColumn> parent;

    public TreeColumn( User usr)
    {
        this.usr = usr;

        left = new HashMap<User.userAttributes, TreeColumn>();
        right = new HashMap<User.userAttributes, TreeColumn>();
        parent = new HashMap<User.userAttributes, TreeColumn>();
        for(User.userAttributes att: User.userAttributes.values())
        {
            left.put(att, null);
            right.put(att, null);
            parent.put(att, null);
        }
    }

    public TreeColumn getLeft(User.userAttributes att)
    {
        return left.get(att);
    }

    public TreeColumn getRight(User.userAttributes att)
    {
        return right.get(att);
    }

    public TreeColumn getParent(User.userAttributes att)
    {
        return parent.get(att);
    }

    public User getUsr() {
        return usr;
    }

    public void setLeft(User.userAttributes att, TreeColumn newLeft)
    {
        this.left.replace(att, newLeft);
    }

    public void setRight(User.userAttributes att, TreeColumn newRight)
    {
        this.right.replace(att, newRight);
    }

    public void setParent(User.userAttributes att, TreeColumn newParent)
    {
        this.parent.replace(att, newParent);
    }

    public void setUsr(User usr) {
        this.usr = usr;
    }
}
