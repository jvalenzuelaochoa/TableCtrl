package ListTable;

import UsrCtrl.User;

import java.util.HashMap;

public class ListColumn {

    private User usr;
    //TODO: consider adding previous.
    HashMap<User.userAttributes, ListColumn> next;
    HashMap<User.userAttributes, ListColumn> previous;

    public ListColumn()
    {
        usr = null;
        next = new HashMap<User.userAttributes, ListColumn>();
        previous = new HashMap<User.userAttributes, ListColumn>();
        for(User.userAttributes att: User.userAttributes.values())
        {
            next.put(att, null);
            previous.put(att, null);
        }
    }

    public void setUsr(User usr) {
        this.usr = usr;
    }

    public User getUsr() {
        return usr;
    }

    public ListColumn getNext(User.userAttributes att)
    {
        return next.get(att);
    }

    public ListColumn getPrevious(User.userAttributes att)
    {
        return previous.get(att);
    }

    public void setPrevious(User.userAttributes att, ListColumn prevColumn)
    {
        this.previous.replace(att, prevColumn);
    }

    public void setNext(User.userAttributes att, ListColumn nextColumn)
    {
        this.next.replace(att, nextColumn);
    }
}
