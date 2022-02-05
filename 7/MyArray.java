import java.util.List;

public class MyArray {
    private  List<Object> list;

    public MyArray(List<Object> list){
        this.list = list;
    }

    public Object get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        String v = "[ ";
        for(Object value : list){
            v += value.toString();
            v += ", ";
        }
        v += "]";
        return v;
    }
}