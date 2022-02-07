public class NegExprNode extends Node{

    private Node node;

    public NegExprNode(int line,Node node) {
        super(line);
        this.node = node;
    }

    @Override
    public Object eval(Env env) throws ParseException {
        return -1 * (int)node.eval(env);
    }

    @Override
    public String toString() {
        return "(-" + node.toString()+")";
    }
}
