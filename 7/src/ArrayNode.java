import java.util.List;
import java.util.ArrayList;

public class ArrayNode extends Node{
    private List<Node> values;

    public ArrayNode(int line, List<Node> values){
        super(line);
        this.values = values;
    }

    public Object eval(Env env) throws ParseException {
        ArrayList<Object> list = new ArrayList<>();
        for(Node n : values)
            list.add(n.eval(env));
        return new MyArray(list);
    }

    public String toString() {
        return "[" + values.toString().replaceAll("^.|.$", "") + "]";
    }
}