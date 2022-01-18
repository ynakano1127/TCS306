public class PosExprNode extends Node{

    private Node node;

    public PosExprNode(int line,Node node) {
        super(line);
        this.node = node;
    }

    @Override
    public int eval(Env env) throws ParseException {
        return node.eval(env);
    }

    @Override
    public String toString() {
        return "(+" + node.toString()+")";
    }
}
