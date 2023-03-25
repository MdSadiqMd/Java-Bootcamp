/*
For Example:Let us consider a situation that there are two students who are considered as two threads t1 and t2 and these students went to a bookshelf to take three books DSA,SQL and Spring and these students are given to thread scheduler and which thread assigned first will take each book simultaneously and
            put lock to it and after that student used the book the lock will be open and then the other student (thread) can access those books
If we haven't put synchronized keyword then when the thread went to sleep the execution would have changed to another thread (another student) as synchronize had put the lock the execution will remain in the same thread
*/
/*
What is Dead Lock ?
Now if we run the program the student1 will acquire Java Book and Student2 will acquire Spring book and student 1 will acquire SQL book and now the student 1 need spring book and student 2 need java book and as ****we are using synchronize keyword the
Books can't be Inter changed at a time so the execution will not go further this situation is called Dead Lock
Release the commented else and comment the present else block we can se the difference of not having the deadlock
The difference between the commented and uncommented else blocks is order of books taken
*/
class BookHub implements Runnable{
    String book1=new String ("java");
    String book2=new String ("SQL");
    String book3=new String ("Spring");
    public void run() {
        String Name=Thread.currentThread().getName();
        if(Name.equals("Student-1")){
            try{
                Thread.sleep(3000);
                synchronized(book1){
                    System.out.println("Student 1 Had Acquired"+" "+book1);
                    Thread.sleep(3000);
                    synchronized (book2){
                        System.out.println("Student 1 Had Acquired"+" "+book2);
                        Thread.sleep(3000);
                        synchronized (book3){
                            System.out.println("Student 1 Had Acquired"+" "+book3);
                            Thread.sleep(3000);
                        }
                    }
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        /*else{
            try{
                Thread.sleep(3000);
                synchronized(book1){
                    System.out.println("Student 2 Had Acquired"+" "+book1);
                    Thread.sleep(3000);
                    synchronized (book2){
                        System.out.println("Student 2 Had Acquired"+" "+book2);
                        Thread.sleep(3000);
                        synchronized (book3){
                            System.out.println("Student 2 Had Acquired"+" "+book3);
                            Thread.sleep(3000);
                        }
                    }
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }*/
        else{
            try{
                Thread.sleep(3000);
                synchronized(book3){
                    System.out.println("Student 2 Had Acquired"+" "+book3);
                    Thread.sleep(3000);
                    synchronized (book2){
                        System.out.println("Student 2 Had Acquired"+" "+book2);
                        Thread.sleep(3000);
                        synchronized (book1){
                            System.out.println("Student 2 Had Acquired"+" "+book1);
                            Thread.sleep(3000);
                        }
                    }
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
public class _59_Dead_Lock_in_MultiThreading {
    public static void main(String[] args) {
            BookHub lb=new BookHub();
            Thread t1=new Thread(lb);
            Thread t2=new Thread(lb);
            t1.setName("Student-1");
            t2.setName("Student-2");
            t1.start();
            t2.start();
    }
}
