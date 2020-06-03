public class MaxHeap { 
    private int[] Heap; 
    private int size; 
    private int maxsize; 
  
    public MaxHeap(int maxsize) 
    { 
        this.maxsize = maxsize; 
        this.size = 0; 
        Heap = new int[this.maxsize + 1]; 
        Heap[0] = Integer.MAX_VALUE; 
    } 
  
    private int parent(int pos) 
    { 
        return pos / 2; /*it is used to find the root node*/
    } 
  
    private int leftChild(int pos) 
    { 
        return (2 * pos); /*it is used to find the left node of the root node*/
    } 
    private int rightChild(int pos) 
    { 
        return (2 * pos) + 1; /*it is used to find the right node of the root node*/
    } 
  
    private boolean isLeaf(int pos) 
    { 
        if (pos >= (size / 2) && pos <= size) { 
            return true; 
        } 
        return false; 
    } 
  
    private void swap(int fpos, int spos) 
    { 
        int temp; 
        temp = Heap[fpos]; 
        Heap[fpos] = Heap[spos]; 
        Heap[spos] = temp; 
    } 
  
    private void maxHeapify(int pos) /*it is the sorting or heaping part*/
    { 
        if (isLeaf(pos)) 
            return; 
  
        if (Heap[pos] < Heap[leftChild(pos)] ||  
            Heap[pos] < Heap[rightChild(pos)]) { 
  
            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) { 
                swap(pos, leftChild(pos)); 
                maxHeapify(leftChild(pos)); 
            } 
            else { 
                swap(pos, rightChild(pos)); 
                maxHeapify(rightChild(pos)); 
            } 
        } 
    } 
  
    public void insert(int element) /*it is the insertion sort*/
    { 
        Heap[++size] = element;  
        int current = size; 
        while (Heap[current] > Heap[parent(current)]) { 
            swap(current, parent(current)); 
            current = parent(current); 
        } 
    } 
  
    public void print() 
    { 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + 
                      Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]); 
            System.out.println(); 
        } 
    } 
    public int extractMax() 
    { 
        int popped = Heap[1]; 
        Heap[1] = Heap[size--]; 
        maxHeapify(1); 
        return popped; 
    } 
  
    public static void main(String[] arg) 
    { 
        System.out.println("The Max Heap is "); 
        MaxHeap maxHeap = new MaxHeap(15); 
        maxHeap.insert(18);/*18=R*/
        maxHeap.insert(1);  /*1=A*/
        maxHeap.insert(13);/*13=M*/
        maxHeap.insert(25);/*25=Y*/
        maxHeap.insert(1);  /*1=A*/
        maxHeap.insert(4); /*4=D*/
        maxHeap.insert(8); /*8=H*/
        maxHeap.insert(1); /*1=A*/
        maxHeap.insert(14);/*14=N*/
        maxHeap.insert(21);/*21=U*/
        maxHeap.print(); 
        System.out.println("The max val is " + maxHeap.extractMax()); 
    } 
} 
