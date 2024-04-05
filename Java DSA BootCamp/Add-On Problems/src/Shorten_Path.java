import java.util.Objects;
import java.util.Stack;

public class Shorten_Path {
    // Shorten Path --> https://youtu.be/nLxW-e3JRu4?si=Z2oP_HNDWJ2usfhe
    public static String shortenPath(String path){
        boolean isRelativePath=!path.startsWith("/");
        String[] tokens=path.split("/");
        Stack<String> stack=new Stack<>();
        for(String token:tokens){
            if(Objects.equals(token,"..")){
                if(!stack.isEmpty()&& Objects.equals(stack.peek(),"..")) stack.pop();
                else stack.push(token);
            } else if(!Objects.equals(token,".")&&!token.isEmpty()) stack.push(token);
        }
        if(stack.size()==0) return isRelativePath?".":"/";
        else return (isRelativePath?"/":"")+String.join("/",stack);
    }
    public static void main(String[] args) {
        String path="../foo/../..";
        System.out.println(shortenPath(path));
    }
}
