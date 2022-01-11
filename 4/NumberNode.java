public class NumberNode extends Node{
    private int num;
    
    NumberNode(int line, int num){
        super(line);
        this.num = num;
    }

    @Override
    public int eval(Env env) throws ParseException {
        return num;
    }

    @Override
    public String toString() {
        return Integer.toString(num);
    }
}
