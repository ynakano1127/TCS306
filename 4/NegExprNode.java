public class NegExprNode extends Node{

    private Node node;

    public NegExprNode(int line,Node node) {
        super(line);
        this.node = node;
    }

    @Override
    public int eval(Env env) throws ParseException {
        return -1 * node.eval(env);
    }

    @Override
    public String toString() {
        return "(-" + node.toString()+")";
    }
}
