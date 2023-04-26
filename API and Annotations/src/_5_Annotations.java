/*
Annotation will maintain Information of the code (metadata)
Here if we not write @Override the Extended class will not Print as Compiler don't know that the class is Overridden
Annotation is a type of metadata that can be added to a class,method,field,parameter to provide additional information about the element
Annotations are used by the compiler,runtime and other tools to generate code,perform runtime checks, and provide documentation and other information
 */

//@Deprecated --> This shows that other methods in the code are present don't use this class
class plane{
    public void flies(){
        System.out.println("Plane Flies");
    }
}
class cargo extends plane{
    @Override
    public void flies(){
        System.out.println("cargo Flying");
    }
}
public class _5_Annotations {
    public static void main(String[] args) {
        plane cp=new cargo();
        cp.flies();
    }
}
