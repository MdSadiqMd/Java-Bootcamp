/*
Getters and Setters --> this is just writing the methods name to start with Set and Get so that the other programmer can understand
**Setters should compulsory Return type should be void and compulsory should have an argument
**Getters should compulsory Return type should be **not be void as we are taking data and compulsory should **not have an argument but in cases of arrays we may have arguments
 */
class Myemployee{
    private int id;        //we use this to prevent change of the attributes
    private String name;   //here we can only assess this attribute using getters and setters

    //constructors
    public Myemployee(){
        id=45;
        name="constructor";
    }

    public void setId(int id) {  //setter
        this.id = id;
    }

    public int getId() {  //getter
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class _30_AccessModifiers_getters_setters {
    public static void main(String[] args) {
        Myemployee sadiq=new Myemployee();
        //calling setters
        sadiq.setId(21);
        sadiq.setName( "Md.sadiq");
        //printing using getters
        System.out.println(sadiq.getId());
        System.out.println(sadiq.getName());
    }
}
