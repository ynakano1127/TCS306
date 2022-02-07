public class EnvNode extends Node {
    public EnvNode(int line) {
        super(line);
    }

    void showLocalEnv(Env env) {
        if (env instanceof LocalEnv) {
            LocalEnv le = (LocalEnv) env;
            System.out.println("^^^^^^^^^^^^^OUTER^^^^^^^^^^^^^^");
            showLocalEnv(le.getOuter());
            System.out.println("vvvvvvvvvvvvOUTERvvvvvvvvvvvvvvv");
        }
        if (env != null)
            for (String key : env.keySet()) {
                System.out.println(key + " : " + env.get(key).toString());
            }
    }

    @Override
    public Object eval(Env env) throws ParseException {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        showLocalEnv(env);
        System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvv");
        return (Object) 0;
    }

    @Override
    public String toString() {
        return "env at " + line();
    }
}
