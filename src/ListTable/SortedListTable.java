package ListTable;

import UsrCtrl.User;

import java.util.HashMap;

public class SortedListTable extends ListTable {

    public SortedListTable()
    {
        super();
    }

    public void addUser(User newUser)
    {
        //TODO: validate user input
        ListColumn newColumn = new ListColumn();
        newColumn.setUsr(newUser);

        if (head.get(User.userAttributes.ID)==null)
        {
            for(User.userAttributes att: User.userAttributes.values())
            {
                head.replace(att, newColumn);
                tail.replace(att, newColumn);
            }
        }
        else
        {
            for(User.userAttributes att: User.userAttributes.values())
            {
                tail.get(att).setNext(att,newColumn);
                tail.replace(att, newColumn);
            }
        }

    }
}
