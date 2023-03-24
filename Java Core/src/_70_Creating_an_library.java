class library{
    String[] books;
    int no_of_books;
    library(){   //creating an constructor
        this.books=new String[100];  //keeping 100 books in library
        this.no_of_books=0;
        System.out.println(books+"has been added");
    }

    void addbook(String book){  //function which used to add books
        this.books[no_of_books]=book;
        no_of_books++;
    }

    void showavailablebooks(){  //this is used to show avaliable books
        System.out.println(" available books are:");
        for (String book:this.books){
            if(book==null){
                continue;
            }
            System.out.println("-- "+ book);
        }
    }

    void issuebook(){  //this is used to show issued books
        for (int i=0;i<this.books.length ;i++){
            if(this.books[i].equals(books)){
                System.out.println(" this book has been issued");
                this.books=null;
                return;
            }
            System.out.println("* "+ books);
        }
        System.out.println("this book doesn't exist"); //this returns if the asked book is not present
    }

    void returnbook(){  //this is used to return book as same as again adding book
        addbook(String.valueOf(books));
    }
}

public class _70_Creating_an_library {
    public static void main(String[] args) {
        library centrallibrary=new library();
        centrallibrary.addbook("the almanck of naval ravikant");
        centrallibrary.addbook("think and grow rich");
        centrallibrary.addbook("do epic shit"); //we can add upto 100 books
        centrallibrary.showavailablebooks();
        centrallibrary.returnbook();
    }
}
