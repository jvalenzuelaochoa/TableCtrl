package TreeTable;

import UsrCtrl.User;
import org.junit.Test;

import javax.swing.event.TreeWillExpandListener;
import java.util.HashMap;

public class TreeTable {

    private HashMap<User.userAttributes, TreeColumn> root;

    public TreeTable()
    {
        root = new HashMap<User.userAttributes, TreeColumn>();
        for(User.userAttributes att: User.userAttributes.values())
        {
            root.put(att, null);
        }
    }

    public TreeColumn getRoot(User.userAttributes att)
    {
        return root.get(att);
    }

    public void setRoot(User.userAttributes att, TreeColumn root) {
        this.root.replace(att,root);
    }

    public void addUser(User newUser)
    {
        TreeColumn newColumn = new TreeColumn(newUser);

        for(User.userAttributes att: User.userAttributes.values())
        {
            if (root.get(att) == null)
            {
                root.replace(att, newColumn);
            }
            else
            {
                TreeColumn traverser = root.get(att);
                TreeColumn parent = null;
                boolean newLocationIsLeft = false;
                while(traverser != null)
                {
                    if(traverser.getUsr().attributeIsGreater(att, newUser))
                    {
                        parent = traverser;
                        traverser = traverser.getLeft(att);
                        newLocationIsLeft = true;
                    }
                    else
                    {
                        parent = traverser;
                        traverser = traverser.getRight(att);
                        newLocationIsLeft = false;
                    }
                }
                newColumn.setParent(att, parent);
                if(newLocationIsLeft)
                {
                    parent.setLeft(att,newColumn);
                }
                else
                    {
                        parent.setRight(att, newColumn);
                    }

            }
        }
    }

    public void displayByAttribute(User.userAttributes att)
    {
        System.out.println("Tree sorted by: " + att.toString());
        print("", true, att, root.get(att));
        System.out.println("\n");
    }

    private void print(String prefix, boolean isTail, User.userAttributes att, TreeColumn traverser) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + traverser.getUsr().toString());
        if (traverser.getLeft(att) != null)
        {
            print(prefix + (isTail ? "   <" : "│  <"), traverser.getRight(att) == null, att, traverser.getLeft(att));
        }

        if (traverser.getRight(att) != null)
        {
            //In binary trees, the right child will always be the tail.
            print(prefix + (isTail ? "   >" : "│  >"), true, att, traverser.getRight(att));
        }

    }

    @Test
    public void notSoQuickTest()
    {
        TreeTable sampleTbl = new TreeTable();
        sampleTbl.addUser( new User(1, "Jesus", 3500));
        sampleTbl.addUser( new User(2, "Pedro", 3500));
        sampleTbl.addUser( new User(6, "Ochoa", 3500));
        sampleTbl.addUser( new User(5, "Valenzuela", 3500));
        sampleTbl.addUser( new User(3, "Mentira", 3500));
        sampleTbl.addUser( new User(4, "Javier", 3500));
        sampleTbl.displayByAttribute(User.userAttributes.ID);
        sampleTbl.displayByAttribute(User.userAttributes.NAME);
        sampleTbl.displayByAttribute(User.userAttributes.SALARY);
    }

}
