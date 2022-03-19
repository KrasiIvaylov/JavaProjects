package Collection;

import java.util.Iterator;
import java.util.List;

public class ListIterator implements Iterable<String> {
    private List<String> data;
    private int index;

    public ListIterator(List<String> data){
        this.data = data;
        this.setIndex(index);
    }

    private void setIndex(int index){
        if (this.data.size() == 0){
            this.index = -1;
        }else{
            this.index = 0;
        }
    }

    public boolean move(){
        if(this.index < this.data.size() - 1){
            this.index++;
            return true;
        }

        return false;
    }

    public String print(){
        if(this.index != -1){
            return this.data.get(this.index);
        }
        return "Invalid Operation!";
    }

    public boolean hasNext(){
        return this.index < this.data.size() - 1;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index <= data.size() - 1;
            }

            @Override
            public String next() {
                return data.get(this.index++);
            }
        };
    }
}