public class Stack {
    private int size;
    private int items[];
    private int top;
    public Stack(int size) {
        this.size = size;
        items = new int[this.size];
    }
    private boolean isFull() {
        return top == size - 1;
    }
    private  boolean isEmpty() {
        return  top == -1;
    }
    public void push(int element) {
        if (isFull()) {
            System.out.println("Стек заполнен");
        } else {
            System.out.println("Добавлен элемент" + element);
            items[++top] = element;
        }
    }
    public int pop() {
        int element;
        if (isEmpty()) {
            System.out.println("Стек пустой");
            return -1;
        }
        element = items[top--];
        System.out.println("Удалён элемент" + element);
        return element;
    }
    public int size() {
        return top-1;
    }
    public void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Очередь пустая!");
        } else {
            System.out.println("Элементы -> \n");
            for (i = top; i >= 0; i--) {
                System.out.println(items[i]);
            }
            System.out.println("\nИндекс ТОР = " + top);
        }
    }
}
