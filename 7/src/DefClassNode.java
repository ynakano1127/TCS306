import java.util.List;

public class DefClassNode extends Node{
    private String name;
    private List<Node> members;
    private Node iNode;

    public DefClassNode(int line, String name, List<Node> members, Node iNode) {
        super(line);
        this.name = name;
        this.members = members;
        this.iNode = iNode;
    }

    @Override
    public Object eval(Env env) throws ParseException {
        if(iNode!=null && iNode.eval(env) instanceof QuartzClass) {
            QuartzClass c = (QuartzClass) iNode.eval(env);
            List<Node> ms = c.getMembers();
            for(int i=0;i<ms.size();i++)
                members.add(i, ms.get(i));
        }

        return env.put(name, new QuartzClass(members));
    }
}
