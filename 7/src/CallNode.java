import java.util.List;
import java.util.ArrayList;

public class CallNode extends Node {
    private Node name;
    private List<Node> args;

    public CallNode(int line, Node name, List<Node> args) {
        super(line);
        this.name = name;
        this.args = args;
    }

    @Override
    public Object eval(Env env) throws ParseException {
        Object obj = name.eval(env);
        Function func;

        if (obj instanceof QuartzObj) {
            QuartzObj obj2 = (QuartzObj) obj;
            func = (Function) obj2.getInner().get("initialize");
            List<Object> vals = new ArrayList<Object>();
            for (Node arg : args) vals.add(arg.eval(env));
            func.exec(vals);
            return obj;
        } else if (obj instanceof Function) {
            func = (Function) obj;
        } else {
            throw new ParseException(obj + "は未定義の関数です" + name.where());
        }

        if (func.arity() != args.size())
            throw new ParseException(name + "は" + func.arity() + "引数の関数です" + where());

        List<Object> vals = new ArrayList<Object>();
        for (Node arg : args) vals.add(arg.eval(env));
        return func.exec(vals);
    }

    @Override
    public String toString() {
        return name + "(" + args.toString().replaceAll("^.|.$", "") + ")";
    }
}