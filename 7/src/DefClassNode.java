import java.util.List;

public class DefClassNode extends Node{
    private String name;
    private List<Node> members;

    public DefClassNode(int line, String name, List<Node> members) {
        super(line);
        this.name = name;
        this.members = members;
    }

    @Override
    public Object eval(Env env) throws ParseException {
        return env.put(name, new QuartzClass(members));
    }
}
