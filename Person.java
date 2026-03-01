abstract class Person {
   private String name;
   private String email;
   Person(String name,String email){
       this.email=email;
       this.name=name;
   }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

   void displayInfo(){
       System.out.println("Contestant Name Is " + name);
       System.out.println("Contestant Email Is " + email);
   }
}
