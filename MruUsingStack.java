
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class MruUsingStack{

    private Stack<Integer> stack;

    private HashSet<Integer> hashSet;

    private int CACHE_SIZE;

    MruUsingStack(int size){
        stack=new Stack<Integer>();
        hashSet=new HashSet<Integer>();
        CACHE_SIZE=size;
    }
    void enterToTheCache(int val){
        if(!hashSet.contains(val)){
            if(stack.size()==CACHE_SIZE){
                int removed=stack.pop();
                hashSet.remove(removed);
            }
           
        } else{
            stack.remove(val);
            hashSet.remove(val);

        }    
        stack.push(val);
        hashSet.add(val);
        
       // System.out.println("hashset: "+hashSet);

       // System.out.println("queue: "+queue);

    }

    void display(){
       Iterator<Integer> hashIt=hashSet.iterator();
       Iterator<Integer> stackIt=stack.iterator();
       
       while(hashIt.hasNext()){
           System.out.print(hashIt.next()+" ");
       }
       System.out.println("");
       System.out.print("stack key ordering: ");

       while(stackIt.hasNext()){
           System.out.print(stackIt.next()+" ");
       }
    }

    public static void main(String[] args) {
        System.out.println("Please enter the cache size: ");
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();

        MruUsingStack obj=new MruUsingStack(size);

        obj.enterToTheCache(1);
        obj.enterToTheCache(2);
        obj.enterToTheCache(3);
        obj.enterToTheCache(4);
        obj.enterToTheCache(5);
        obj.enterToTheCache(6);


        //obj.enterToTheCache(1);
        //obj.enterToTheCache(2);

        obj.enterToTheCache(11);

        obj.enterToTheCache(1);


        obj.display();

        
    }
}