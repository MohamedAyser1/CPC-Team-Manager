import java.util.ArrayList;

 class Contestant extends Person   {
    private String handle;
    private int rating;
    private ArrayList<String> topics=new ArrayList<String>();

    Contestant(String name, String email,String handle,int rating) {
         super(name, email);
         this.handle=handle;
         this.rating=rating;
     }

     void addTopic(String topic){
        topics.add(topic);
     }

     String getHandle() {
         return handle;
     }

    int getTopicCount() {
         return topics.size();
     }

     int getRating(){
         return rating;
     }

     void setRating(int rating) {
         if (rating >= 0) {
             this.rating = rating;
         }
     }

     @Override
     void displayInfo() {
         super.displayInfo();
         System.out.println("Contestant Handel Is " + handle);
         System.out.println("Contestant Rating Is " + rating);
         for (var topic : topics) {
             System.out.print(topic + " ");
         }
          System.out.println();
         }
     }

