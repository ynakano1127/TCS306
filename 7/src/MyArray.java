import java.util.List;
import java.util.ArrayList;

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

    static public MyArray plus(MyArray left, MyArray right){
        ArrayList<Object> list = new ArrayList<Object>();
        for(int i=0;i<left.size();i++){
            list.add(left.get(i));
        }
        for(int i=0;i<right.size();i++){
            list.add(right.get(i));
        }
        return new MyArray(list);
    }

    static public MyArray minus(MyArray left, MyArray right){
        ArrayList<Object> list1 = new ArrayList<Object>();
        ArrayList<Object> list2 = new ArrayList<Object>();
        for(int i=0;i<left.size();i++){
            list1.add(left.get(i));
        }
        for(int i=0;i<right.size();i++){
            list2.add(right.get(i));
        }
        list1.removeAll(list2);
        return new MyArray(list1);
    }

    static public MyArray and(MyArray left, MyArray right){
        ArrayList<Object> list = new ArrayList<Object>();

        for(int i=0;i<left.size();i++){
            for(int j=0;j<right.size();j++){
                if(left.get(i) == right.get(j))
                    list.add(left.get(i));
            }
        }
        return new MyArray(list);
    }
}