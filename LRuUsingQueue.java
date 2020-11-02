import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class LRuUsingQueue{

    private Queue<Integer> queue;

    private HashSet<Integer> hashSet;

    private int CACHE_SIZE;

    LRuUsingQueue(int size){
        queue=new LinkedList<Integer>();
        hashSet=new HashSet<Integer>();
        CACHE_SIZE=size;
    }
    void enterToTheCache(int val){
        if(!hashSet.contains(val)){
            if(queue.size()==CACHE_SIZE){
                int removed=queue.remove();
                hashSet.remove(removed);
            }
           
        } else{
            queue.remove(val);
            hashSet.remove(val);

        }    
        queue.add(val);
        hashSet.add(val);
        
       // System.out.println("hashset: "+hashSet);

       // System.out.println("queue: "+queue);

    }

    void display(){
       Iterator<Integer> hashIt=hashSet.iterator();
       Iterator<Integer> queueIt=queue.iterator();
       
       while(hashIt.hasNext()){
           System.out.print(hashIt.next()+" ");
       }
       System.out.println("");
       System.out.print("queue key ordering: ");

       while(queueIt.hasNext()){
           System.out.print(queueIt.next()+" ");
       }
    }

    public static void main(String[] args) {
        System.out.println("Please enter the cache size: ");
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();

        LRuUsingQueue obj=new LRuUsingQueue(size);

        obj.enterToTheCache(1);
        obj.enterToTheCache(2);
        obj.enterToTheCache(3);
        obj.enterToTheCache(4);
        obj.enterToTheCache(5);
        obj.enterToTheCache(6);


        obj.enterToTheCache(1);
        obj.enterToTheCache(2);

        obj.enterToTheCache(11);


        obj.display();

        
    }
}