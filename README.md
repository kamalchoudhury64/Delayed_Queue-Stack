# Here Delayed Queue and Delayed Stack are new type of data structures whose description is given below
# Part 1 – Delayed Stack 
A stack is a data structure where the element removed is always the most recently added out of the
remaining elements. See: Stack (abstract data type) - Wikipedia. The two main operations are push(E)
which adds an element and pop() which removes an element.
A DelayedStack works like a normal stack except has a restriction ('delay condition') that prohibits
elements from being removed until a certain number of push operations have occurred. Once the
required number of push operations occur, any number of elements may be removed, however the
moment another element is added, the delay condition comes back into force.
Your task is to create a class called MyStack that implements the generic DelayedStack interface according
to the specification written in the docstrings for each method. Your class should be able to be instantiated
with
DelayedStack<...> s = new MyStack<...>(9);
where the ... can be replaced by any object, and the int parameter for the constructor represents the max
delay value (ie. number of push operations that must occur before pop operations can start to occur).
If the max delay value is changed, the change does not take effect until the next time the delay is reset to
the maximum (ie. when push occurs after a sequence of pop operations).
For this task you may not import anything from the java standard library, or external libraries.

# Examples (1)
DelayedStack<String> s = new MyStack<String>(4); //delay condition of 4
s.push(“first element”);
s.push(“something else”);
s.pop(); //return value is null, because so far only 2 elements have
been pushed
s.push(“third”);
s.push(“fourth”);
s.pop(); //return value is “fourth”
s.push(“another one”);
s.pop() //return value is null again, because the delay condition has
been reset
s.push(“2”);
s.push(“3”);
s.push(“4”);
s.pop(); // return value is “4”
s.pop(); // return value is “3”
s.pop(); s.pop(); s.pop(); s.pop();
//return values are “2”, “another one”, “third”, “something else”
  
# Examples (2)
DelayedStack<String> s = new MyStack<String>(0); //delay condition of 0
means that there is never a restriction. Same with negative values, or
1.
s.push(“hello”);
s.pop(); //returns “hello”
s.setMaximumDelay(2);
s.getMaximumDelay(); //return value is 2
s.pop(); //IllegalStateException is thrown, the stack is empty
s.push(“X”);
s.push(“a”);
s.push(“b”);
s.push(“c”);
s.pop(); //return value is “c”
s.pop(); //return value is “b”
s.setMaximumDelay(4);
s.getDelay(); //return value is 0.
s.pop(); //return value is “a” – delay is not set until the next push
s.push(“Y”); s.push(“Z”);
s.setMaximumDelay(-1);
s.getDelay(); //return value is 2 – delay is not set yet
s.push(“An”);
s.getDelay(); //return value is 1
s.pop(); //return value is null
s.push(“AX”);
s.getDelay(); //return value is 0
s.pop(); //return value is “AX”
  
# Part 2 – Delayed Queue 
A queue is a data structure where the element removed is always the oldest element (the one which has
been waiting the longest) out of the remaining elements, ie. the one which was added the least recently.
See: Queue (abstract data type) - Wikipedia. The two main operations are enqueue(E) which adds an
element and dequeue() which removes an element.
A DelayedQueue works like a normal queue except has a restriction ('delay condition') that prohibits
elements from being removed until a certain number of enqueue operations have occurred. Once the
required number of enqueue operations occur, any number of elements may be removed, however the
moment another element is added, the delay condition comes back into force.
Your task is to create a class called MyQueue that implements the generic DelayedQueue interface
according to the specification written in the docstrings for each method. Your class should be able to be
instantiated with
DelayedQueue<...> s = new MyQueue<...>(7);
where the ... can be replaced by any object, and the int parameter for the constructor represents the max
delay value (ie. number of enqueue operations that must occur before dequeue operations can start to
occur).
If the max delay value is changed, the change does not take effect until the next time the delay is reset to
the maximum (ie. when enqueue occurs after a sequence of dequeue operations).
For this task you may not import anything from the java standard library, or external libraries. 
 INFO1113
Page 4 of 6
# Examples (1)
DelayedQueue<String> s = new MyQueue<String>(4); //delay condition of 4
s.enqueue(“first element”);
s.enqueue(“something else”);
s.dequeue(); //return value is null, because so far only 2 elements
have been pushed
s.enqueue(“third”);
s.enqueue(“fourth”);
s.dequeue(); //return value is “first element”
s.enqueue(“another one”);
s.dequeue() //return value is null again, because the delay condition
has been reset
s.enqueue(“2”);
s.enqueue(“3”);
s.enqueue(“4”);
s.dequeue(); // return value is “something else”
s.dequeue(); // return value is “third”
s.dequeue(); s.dequeue(); s.dequeue(); s.dequeue();
//return values are “fourth”, “another one”, “2”, “3”

# Examples (2)
DelayedQueue<String> s = new MyQueue<String>(0); //delay condition of 0
means that there is never a restriction. Same with negative values, or
1.
s.enqueue(“hello”);
s.dequeue(); //returns “hello”
s.setMaximumDelay(2);
s.getMaximumDelay(); //return value is 2
s.dequeue(); //IllegalStateException is thrown, the queue is
empty
s.enqueue(“X”);
s.enqueue(“a”);
s.enqueue(“b”);
s.enqueue(“c”);
s.dequeue(); //return value is “X”
s.dequeue(); //return value is “a”
s.setMaximumDelay(4);
s.getDelay(); //return value is 0.
s.dequeue(); //return value is “b” – delay is not set until the next
push
s.enqueue(“Y”); s.enqueue(“Z”);
s.setMaximumDelay(-1);
s.getDelay(); //return value is 2 – delay is not set yet
s.enqueue(“An”);
s.getDelay(); //return value is 1
s.dequeue(); //return value is null
s.enqueue(“AX”);
s.getDelay(); //return value is 0
s.dequeue(); //return value is “c” 
