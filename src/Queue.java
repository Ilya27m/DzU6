public class Queue {
    int size;
    int item[];
    int front, rear;
    public Queue(int size) {
        this.size = size;
        item = new int[this.size];
        front = -1;
        rear = -1;
    }
    private boolean isFull() {
        if (front == 0 && rear == size - 1) {
            return true;
        }
        return false;
    }
    private boolean isEmpty() {
        if (front == -1) {
            return true;
        }
        return false;
    }
    public void enQueue (int element) {
        if (isFull()) {
            System.out.println("Очередь заполнена");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            item[rear] = element;
            quickSort(item, front, rear);
            System.out.println("Добавлен элемент " + element);
        }
    }
    public int deQueue() {
        int element;
        if (isEmpty()) {
            System.out.println("Очередь пустая");
            return  (-1);
        } else {
            element = item[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            System.out.println("Удалён элемент " + element);
            return element;
        }
    }
    public void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Очередь пустая");
        } else {
            System.out.println("\nИндекс FRONT " + front);
            System.out.println("Элементы -> ");
            for (i = front; i <= rear; i++) {
                System.out.println(item[i] + " ");
            }
            System.out.println("\nИндекс REAR " + rear);
        }
    }
    public static void quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + leftBorder) / 2];
        do {
            while (source[leftMarker] > pivot) {
                leftMarker++;
            }
            while (source[rightMarker] > pivot) {
                rightMarker++;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);
        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }
}
