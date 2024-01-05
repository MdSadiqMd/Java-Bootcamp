public class Design_a_Browser_History {
    static class Node{
        String data;
        Node prev;
        Node next;
        public Node(String data){
            this.data=data;
            this.prev=null;
            this.next=null;
        }
    }
    static class Browser{
        Node currentPage;
        public Browser(String homePage){
            currentPage=new Node(homePage);
        }
        void visit(String url){
            Node newNode=new Node(url);
            currentPage.next=newNode;
            newNode.prev=currentPage;
            currentPage=newNode;
        }
        String back(int steps){
            while(steps>0){
                if(currentPage.prev!=null){
                    currentPage=currentPage.prev;
                } else {
                    break;
                }
                steps=steps-1;
            }
            return currentPage.data;
        }
        String forward(int steps){
            while(steps>0){
                if(currentPage.next!=null){
                    currentPage=currentPage.next;
                } else {
                    break;
                }
                steps=steps-1;
            }
            return currentPage.data;
        }
    }
    public static void main(String[] args) {
        Browser browser = new Browser("www.homepage.com");

        browser.visit("www.google.com");
        browser.visit("www.wikipedia.org");
        browser.visit("www.github.com");
        System.out.println("Backward 1 step: " + browser.back(1));
        System.out.println("Backward 2 steps: " + browser.back(2));
        System.out.println("Forward 1 step: " + browser.forward(1));
        System.out.println("Forward 2 steps: " + browser.forward(2));
        System.out.println("Backward 5 steps: " + browser.back(5));
        System.out.println("Forward 5 steps: " + browser.forward(5));
    }
}
