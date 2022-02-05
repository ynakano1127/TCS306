public class EnvNode extends Node {
    public EnvNode(int line) {
        super(line);
    }

    @Override
    public Object eval(Env env) throws ParseException {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        for(String key : env.keySet()){
            System.out.println(key + " : " + env.get(key).toString());
        }
        System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvv");
        return (Object) 0;
    }

    @Override
    public String toString() {
        return "env at " + line();
    }
}
