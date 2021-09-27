package ListIterator;

import java.util.List;

public class ListIterator {
    private List<String> data;
    private int index;

    public ListIterator(List<String> data) {
        this.data = data;
        this.setIndex(index);
    }

    private void setIndex(int index) {
        if (this.data.size() == 0) {
            this.index = -1;
        } else {
            this.index = 0;
        }
    }

    public boolean move() {
        if (this.index < this.data.size() - 1) {
            this.index++;
            return true;
        }

        return false;
    }

    public String print() {
        if (this.index != -1) {
            return this.data.get(this.index);
        }
        return "Invalid Operation!";
    }

    public boolean hasNext() {
        return this.index < this.data.size() - 1;
    }
}