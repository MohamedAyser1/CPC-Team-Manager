import java.util.ArrayList;
import java.util.Scanner;

public class ProjectLauncher {
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Contestant> contestants = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean running = true;
        System.out.println("Welcome to the ECPC Team Manager!");

        while (running) {
            System.out.println("\n===========================");
            System.out.println("1. Create a new Contestant");
            System.out.println("2. Create a new Team");
            System.out.println("3. Add Contestant to a Team");
            System.out.println("4. Display all Teams");
            System.out.println("5. Exit");
            System.out.println("===========================");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createContestant();
                    break;
                case 2:
                    createTeam();
                    break;
                case 3:
                    addContestantToTeam();
                    break;
                case 4:
                    displayAllTeams();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting... Good luck with your CP training!");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private void createContestant() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Codeforces Handle: ");
        String handle = scanner.nextLine();

        System.out.print("Enter Rating: ");
        int rating = scanner.nextInt();
        scanner.nextLine();

        Contestant c = new Contestant(name, email, handle, rating);
        contestants.add(c);
        System.out.print("Enter Number Of Topics: ");
        int n = scanner.nextInt();
        for (int i=1;i<=n;i++){
            System.out.print("Enter Topic: " + i);
            c.addTopic(scanner.next());
        }
        System.out.println("Contestant '" + name + "' added successfully!");
    }

    private void createTeam() {
        System.out.print("Enter Team Name: ");
        String teamName = scanner.nextLine();

        Team t = new Team(teamName);
        teams.add(t);
        System.out.println("Team '" + teamName + "' created successfully!");
    }

    private void addContestantToTeam() {
        if (teams.isEmpty() || contestants.isEmpty()) {
            System.out.println("You need to create at least one team and one contestant first!");
            return;
        }

        System.out.println("\n--- Available Contestants ---");
        for (int i = 0; i < contestants.size(); i++) {
            System.out.println((i + 1) + ". " + contestants.get(i).getName() + " (" + contestants.get(i).getHandle() + ")");
        }
        System.out.print("Select Contestant Number: ");
        int contestantIndex = scanner.nextInt() - 1;

        System.out.println("\n--- Available Teams ---");
        for (int i = 0; i < teams.size(); i++) {
            System.out.println((i + 1) + ". " + teams.get(i).getTeamName());
        }
        System.out.print("Select Team Number: ");
        int teamIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (contestantIndex >= 0 && contestantIndex < contestants.size() && teamIndex >= 0 && teamIndex < teams.size()) {
            Contestant selectedContestant = contestants.get(contestantIndex);
            Team selectedTeam = teams.get(teamIndex);
            selectedTeam.addMember(selectedContestant);
        } else {
            System.out.println("Invalid selection!");
        }
    }

    private void displayAllTeams() {
        if (teams.isEmpty()) {
            System.out.println("No teams available.");
            return;
        }
        for (Team t : teams) {
            t.displayTeam();
        }
    }
}