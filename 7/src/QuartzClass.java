import java.util.List;

public class QuartzClass {
    private List<Node> members;

    public QuartzClass(List<Node> members) {
        this.members = members;
    }

    public QuartzObj create(Env env) throws ParseException {
        LocalEnv e = new LocalEnv();
        for (int i = 0; i < members.size(); i++) {
            members.get(i).eval(e);
        }
        e.setOuter(env);
        return new QuartzObj(e);
    }

    public List<Node> getMembers() {
        return members;
    }
}
