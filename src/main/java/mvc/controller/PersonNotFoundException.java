package mvc.controller;

public class PersonNotFoundException extends Exception {

   /**
    * 
    */
   private static final long serialVersionUID = -3118449380461572878L;

   public PersonNotFoundException(String name) {
     super(name);
   }

}
