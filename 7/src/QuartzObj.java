public class QuartzObj {
    private LocalEnv inner;

    public QuartzObj(LocalEnv inner) {
        this.inner = inner;
    }

    public Env getInner() {
        return inner;
    }
}
