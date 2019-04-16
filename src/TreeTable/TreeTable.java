package TreeTable;

import UsrCtrl.User;
import org.junit.Test;

import java.util.HashMap;

public class TreeTable {

    //TODO: Implement balancing method.

    private HashMap<User.userAttributes, TreeRow> root;

    public TreeTable()
    {
        root = new HashMap<User.userAttributes, TreeRow>();
        for(User.userAttributes att: User.userAttributes.values())
        {
            root.put(att, null);
        }
    }

    public TreeRow getRoot(User.userAttributes att)
    {
        return root.get(att);
    }

    public void setRoot(User.userAttributes att, TreeRow root) {
        this.root.replace(att,root);
    }

    public void addUser(User newUser)
    {
        TreeRow newRow = new TreeRow(newUser);

        for(User.userAttributes att: User.userAttributes.values())
        {
            if (root.get(att) == null)
            {
                root.replace(att, newRow);
            }
            else
            {
                TreeRow traverser = root.get(att);
                TreeRow parent = null;
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
                newRow.setParent(att, parent);
                if(newLocationIsLeft)
                {
                    parent.setLeft(att,newRow);
                }
                else
                    {
                        parent.setRight(att, newRow);
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

    private void print(String prefix, boolean isTail, User.userAttributes att, TreeRow traverser) {
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
