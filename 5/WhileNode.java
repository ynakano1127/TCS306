public class WhileNode extends Node {
    private Node cond;
    private Node block;

    public WhileNode(int line, Node cond, Node block) {
        super(line);
        this.cond = cond;
        this.block = block;
    }

    @Override
    public int eval(Env env) throws ParseException {
        int result = 0;
        while(cond.eval(env) != 0) {
            result = block.eval(env);
        }
        return result;
    }

    @Override
    public String toString() {
        return "while " + cond + " do " + block + " end";
    }
}