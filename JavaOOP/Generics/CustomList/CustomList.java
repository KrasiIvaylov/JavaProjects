package CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> values;

    public CustomList(){
        this.values = new ArrayList<>();
    }
    public void add(T element){
        this.values.add(element);
    }
    public T remove(int index){
        if (index < 0 || index >= this.values.size()){
            throw  new IndexOutOfBoundsException("Invalid index!");
        }
       return this.values.remove(index);
    }
    public boolean contains(T element){
       return this.values.contains(element);
    }
    public void swap(int index1, int index2){
        validateIndexes(index1, index2);
        Collections.swap(this.values, index1, index2);
    }
    private void validateIndexes(int index1, int index2){
        if (index1 < 0 || index1 >= this.values.size()){
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index2 < 0 || index2 >= this.values.size()){
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }
    public int countGreaterThan (T element){
        return  (int) this.values.stream().filter(e -> e.compareTo(element) > 0).count();
    }
    public T getMax(){
       // return Collections.max(this.values);
       if (this.values.isEmpty()){
            throw new IllegalStateException("Empty list!");
        }
       T max = this.values.get(0);
        for (int i = 1; i < this.values.size(); i++) {
            T current = this.values.get(i);
            if (current.compareTo(max) >  0 ){
                max = current;
            }
        }
        return max;
    }
    public T getMin(){
        // return Collections.min(this.values);
        if (this.values.isEmpty()){
            throw new IllegalStateException("Empty list!");
        }
        T min = this.values.get(0);
        for (int i = 1; i < this.values.size(); i++) {
            T current = this.values.get(i);
            if (current.compareTo(min) < 0 ){
                min = current;
            }
        }
        return min;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (T element : this.values){
            sb.append(element).append(System.lineSeparator());
        }
        return sb.toString();
    }

}
