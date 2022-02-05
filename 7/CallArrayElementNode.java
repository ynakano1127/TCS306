import java.util.List;
import java.util.ArrayList;

public class CallArrayElementNode extends Node{
    private Node name;
    private Node indexNode;

    public CallArrayElementNode(int line, Node name, Node indexNode){
        super(line);
        this.name = name;
        this.indexNode = indexNode;
    }

    @Override
    public Object eval(Env env) throws ParseException {
        Object obj = name.eval(env);
        if(!(obj instanceof MyArray))
            throw new ParseException(obj + "は未定義の配列です" + name.where());

        Object i = indexNode.eval(env);
        if(!(i instanceof Integer))
            throw new ParseException(i + "数値ではありません" + name.where());

        MyArray a = (MyArray) obj;
        int index = (Integer) i;

        if(index < 0)
            throw new ParseException("インデックスは0以上の値でなければなりません at " + where());
        if(index >= a.size())
            throw new ParseException(name + "は要素数"+ a.size() + "の配列です at" + where());

        return a.get(index);
    }

    @Override
    public String toString() {
        return name + "[" + indexNode.toString() + "]";
    }
}