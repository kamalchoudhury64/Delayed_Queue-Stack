// This is the implementation of delayed stack //
// The Upper bound for size is 20000            //


//This is the class Mystack which is implementing DelayedStack Interface //
public class MyStack<E> implements DelayedStack<E> {

    // Instance variables
    protected E dstack[];
    int push_num;
    int maxdelay;
    int pop_flag;
    int stack_size;
    int tempdelay;
    int count;

    // Constructor which is initialising the stack
    public MyStack(int delay) {  
        dstack = (E[]) new Object[5000000];
        this.push_num=delay;
        this.pop_flag=1;
        this.stack_size=0;
        this.maxdelay=delay;
        this.tempdelay=delay;
        this.count=0; 
    }  
    
    
    public int size(){
    return stack_size;        
    }     
              
    // Pushing in the stack 
    public void push(E obj){
        if(pop_flag==0){
            maxdelay=tempdelay;
            push_num=maxdelay;
        }
        dstack[stack_size]=obj;
        stack_size++;
        push_num--;
        if(push_num<=0){
            push_num=0;
    }
    if(push_num==0){
        count++;
    }
        pop_flag=1;
        
    }
        
    // popping from the stack
    public E pop(){
        if(stack_size==0){
            throw new IllegalStateException("Illegal State Exception:: Stack Is empty!!!\n");        
        }
        else if(push_num<=0){
            stack_size--;
            pop_flag=0;
            maxdelay=tempdelay;
            return dstack[stack_size];
        }
        else{
            return null;
        }
    }

    // Setting the delay to Maximum 
    public void setMaximumDelay(int max_delay){
    maxdelay=max_delay;
    tempdelay=maxdelay;
    if(pop_flag==0){
            maxdelay=tempdelay;
        }
    }


    // Getting the maximum current delay    
    public int getMaximumDelay(){
        if(pop_flag==0){
            maxdelay=tempdelay;
        }
        return maxdelay;
    }

    // Getting the delay
    public int getDelay(){
        return push_num;
    }

    // returns top of stack without removing it
    public E peek(){
        if(stack_size==0){
            throw new IllegalStateException("Illegal State Exception:: Stack Is empty!!!\n");        
        }
        else{
            return dstack[stack_size-1];
        }
    }
   
    // clears the whole stack if delay condition is passed
    public boolean clear(){
        if(push_num<=0){
            stack_size=0;
            pop_flag=0;
            return true;    
        }
        else{
            return false;    
        }
    }
    
    // contains or not
    public boolean contains(E elem){
        int i;
        for(i=0;i<stack_size;i++){
            if(elem.equals(dstack[i])){
                return true;
            }
        }
        return false;
    }
     
}
    
