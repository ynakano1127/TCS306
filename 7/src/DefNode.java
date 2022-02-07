import java.util.List;

public class DefNode extends Node {
    private String name;
    private List<String> paramas;
    private Node body;

    public DefNode(int line, String name, List<String> params, Node body){
        super(line);
        this.name = name;
        this.paramas = params;
        this.body = body;
    }

    public Object eval(Env env) throws ParseException {
        return env.put(name, (new Function(env, paramas, body)));
    }

    public String toString() {
        return "def" + name + "(" + paramas.toString().replaceAll("^.|.$", "") + ")" + body + " end";
    }
}