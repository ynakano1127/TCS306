public class BinExprNode extends Node {
    private Node left;
    private String op;
    private Node right;

    public BinExprNode(int line, Node left, String op, Node right) {
        super(line);
        this.left = left;
        this.op = op;
        this.right = right;
    }

    @Override
    public Object eval(Env env) throws ParseException {
        Object lval = left.eval(env);
        Object rval = right.eval(env);
        if (lval instanceof Integer && rval instanceof Integer) {
            switch (op) {
                case "+":
                    return (int) left.eval(env) + (int) right.eval(env);
                case "-":
                    return (int) left.eval(env) - (int) right.eval(env);
                case "*":
                    return (int) left.eval(env) * (int) right.eval(env);
                case "/":
                    return (int) left.eval(env) / (int) right.eval(env);
                case "%":
                    return (int) left.eval(env) % (int) right.eval(env);
                case ">":
                    return (int) left.eval(env) > (int) right.eval(env) ? 1 : 0;
                case "<":
                    return (int) left.eval(env) < (int) right.eval(env) ? 1 : 0;
                case ">=":
                    return (int) left.eval(env) >= (int) right.eval(env) ? 1 : 0;
                case "<=":
                    return (int) left.eval(env) <= (int) right.eval(env) ? 1 : 0;
                case "==":
                    return (int) left.eval(env) == (int) right.eval(env) ? 1 : 0;
                case "!=":
                    return (int) left.eval(env) != (int) right.eval(env) ? 1 : 0;
                case "&&":
                    return ((int) left.eval(env) != 0) && ((int) right.eval(env) != 0) ? 1 : 0;
                case "||":
                    return ((int) left.eval(env) != 0) || ((int) right.eval(env) != 0) ? 1 : 0;
                default:
                    throw new ParseException(op + "は未定義のオーペレーターです" + where());
            }
        }

        if (lval instanceof MyArray && rval instanceof MyArray) {
            switch (op) {
                case "+":
                    return MyArray.plus((MyArray)lval, (MyArray)rval);
                case "-":
                    return MyArray.minus((MyArray)lval, (MyArray)rval);
                case "*":
                    return MyArray.and((MyArray)lval, (MyArray)rval);
            }
        }

        String lstr = lval.toString();
        String rstr = rval.toString();
        if(op.equals("+"))
            return lstr+rstr;
        throw  new ParseException("文字列に対する" + op + "は未定義のオペレータです" + where());
    }

    @Override
    public String toString() {
        return "(" + left + " " + op + " " + right + ")";
    }
}
