import java.util.ArrayList;
import java.util.List;

public abstract class MyList {
    public List<Item> list;

// MYLIST METHODS _______________________________________________________
    public MyList() {
        list = new ArrayList<>();
    }

    public int size() {
        return list.size();
    }

    public void add(Item item) {
        list.add(item);
    }

    public void remove(int index) {
        if(index<0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Item doesn't exist");
        }
        else {
            list.remove(index);
        }
    }

// ABSTRACT METHODS _______________________________________________________
    abstract public Item getItem(int index);
    abstract public void printList();
    abstract public void edit(String[] args);
    abstract public void read(String filename);
    abstract public void write(String filename);
}
