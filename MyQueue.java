// This is the implementation of delayed Queue //
// The Upper bound for size is 20000            //

//This is the class MyQueue which is implementing DelayedQueue Interface //
public class MyQueue<E> implements DelayedQueue<E> {

    // Instance variables
    protected E dQueue[];
    int push_num;
    int maxdelay;
    int dq_flag;
    int Queue_size;
    int tempdelay;
    int front;
    int back;
    
    //returns size		
    public int size(){
	return Queue_size;
    }
    // Constructor which is initialising the Queue
    public MyQueue(int delay) {  
        dQueue = (E[]) new Object[5000000];
        this.push_num=delay;
        this.dq_flag=1;
        this.Queue_size=0;
        this.maxdelay=delay;
        this.tempdelay=delay;
        this.front=-1;
        this.back=-1;  
    }  
    

    // Pushing in the Queue 
    public void enqueue(E obj){
        if(dq_flag==0){
            maxdelay=tempdelay;
            push_num=maxdelay;
        }
        if(front==back && front==-1){
            front=0;
            back=0;
        }
        else {
            back = (back+1)%5000000;
        }
        dQueue[back]=obj;
        Queue_size++;
        push_num--;
        if(push_num<=0)
            push_num=0;
        dq_flag=1;
    }
        
    // popping from the Queue
    public E dequeue(){
        if(Queue_size==0){
            throw new IllegalStateException("Illegal State Exception:: Queue Is empty!!!\n");        
        }
        else if(push_num<=0){
            Queue_size--;
            E ret = dQueue[front];
            if(front==back){
                front=-1;
                back=-1;
            }
            else{
        	front=(front+1)%5000000;
            }
            dq_flag=0;
            maxdelay=tempdelay;
            return ret;
        }
        else{
            return null;
        }
    }

    // Setting the delay to Maximum 
    public void setMaximumDelay(int max_delay){
        maxdelay=max_delay;
	tempdelay=max_delay;
        if(dq_flag==0){
            maxdelay=tempdelay;
        }
    }


    // Getting the maximum current delay    
    public int getMaximumDelay(){
        if(dq_flag==0){
            maxdelay=tempdelay;
        }
        return maxdelay;
    }

    // Getting the delay
    public int getDelay(){
        return push_num;
    }

    // returns front of the queue    
    public E peek(){
    if(Queue_size==0){
            throw new IllegalStateException("Illegal State Exception:: Queue Is empty!!!\n");        
        }
    else{
        return dQueue[front];    
    }    
    }//throws IllegalStateException;
    
    // clears the stack if delay condition satisfied
    public boolean clear(){
    int i;
    if(push_num<=0){
        front=-1;
        back=-1;
	Queue_size=0;
	dq_flag=0;
        return true;
    }
    return false;
    }    

    // Check if the element is contained in the queue or not
    public boolean contains(E elem){
    int i;
    for(i=front;i<=back;i=(i+1)%2000000){
        if(elem.equals(dQueue[i])){
            return true;
        }
    }
    return false;
    }         
}
    
