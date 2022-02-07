public class ForNode extends Node {
    private String indexName;
    private Node arrayNode;
    private Node block;

    public ForNode(int line, String indexName, Node arrayNode, Node block) {
        super(line);
        this.indexName = indexName;
        this.arrayNode = arrayNode;
        this.block = block;
    }

    @Override
    public Object eval(Env env) throws ParseException {
        Object obj = arrayNode.eval(env);
        if(!(obj instanceof MyArray))
            throw new ParseException(obj + "は配列ではありません" + where());

        if(!(block instanceof BlockNode))
            throw new ParseException(block + "は適切なブロックではありません" + where());

        MyArray array = (MyArray) obj;
        Object result = 0;
        for(int i=0;i<array.size();i++){
            env.put(indexName, array.get(i));
            result = block.eval(env);
        }
        env.remove(indexName);
        return result;
    }

    @Override
    public String toString() {
        return "for " + indexName + " in " + arrayNode + " do " + block + " end";
    }
}