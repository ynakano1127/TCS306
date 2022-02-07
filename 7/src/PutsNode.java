import java.util.ArrayList;

public class PutsNode extends Node {
    private Node param;
    
    public PutsNode(int line, Node param) {
        super(line);
        this.param = param;
    }

    @Override
    public Object eval(Env env) throws ParseException {
        Object val = param.eval(env);
        String message = val.toString();
        if(val instanceof QuartzObj){
            Function func = (Function) ((QuartzObj)val).getInner().get("to_s");
            message = (String) func.exec(new ArrayList<>());
        }
        System.out.println(message);
        return message;
    }

    @Override
    public String toString() {
        return "puts" + param;
    }
}
