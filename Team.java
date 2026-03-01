import java.util.ArrayList;
public class Team {
    private String teamName;

    private ArrayList<Contestant> members=new ArrayList<Contestant>();
    Team(String teamName){
        this.teamName=teamName;

    }
String getTeamName(){return teamName;}

 int getMemberCount() {return members.size();}

    void addMember(Contestant c){
        if(members.size()<3){
            members.add(c);
        }
    }

   void displayTeam(){
       System.out.println("\n--- Team Information ---");
        System.out.println("Team Name Is " + teamName);
        for (var c:members) {
            c.displayInfo();
            System.out.println("------------------------------");
        }
    }

}
