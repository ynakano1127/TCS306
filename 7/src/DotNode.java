public class DotNode extends Node{
    private Node left;
    private String right;

    public DotNode(int line, Node left, String right) {
        super(line);
        this.left = left;
        this.right = right;
    }

    @Override
    public Object eval(Env env) throws ParseException {
        Object evaledLeft = left.eval(env);

        if (evaledLeft instanceof QuartzClass) {
            QuartzClass qc = (QuartzClass) evaledLeft;
            if (right.equals("new")) {
                return qc.create(env);
            }
        }else if(evaledLeft instanceof QuartzObj){
            return (Function)((QuartzObj)evaledLeft).getInner().get(right);
        }
        System.out.println(evaledLeft);
        throw new ParseException("なにかがおかしい");
    }
}
