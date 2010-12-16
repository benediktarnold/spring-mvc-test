package mvc.model;

public class Person {
   private String name;

   public Person(String name) {
      super();
      this.setName(name);
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }
}
