public class LocalEnv extends Env {
    private Env outer = null;

    public Env getOuter() {
        return outer;
    }

    public void setOuter(Env outer){
        this.outer = outer;
    }

    @Override
    public boolean containsKey(Object name) {
        if(super.containsKey(name)) return true;
        if(outer == null) return false;
        return outer.containsKey(name);
    }

    @Override
    public Object get(Object name){
        if(super.containsKey(name)) return super.get(name);
        if(outer == null) return null;
        return outer.get(name);
    }

    @Override
    public Object put(String name, Object val){
        if(super.containsKey(name) || outer == null) return super.put(name, val);
        if(outer.containsKey(name)) return outer.put(name, val);
        return super.put(name, val);
    }
}