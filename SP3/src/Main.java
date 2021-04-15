import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static  UI ui;
    public static ArrayList<Team> teams = new ArrayList<>();
    public static ArrayList<Match> matches = new ArrayList<>();
    public static ArrayList<Team> currentTeams = new ArrayList<>();
    public static ArrayList<Match> quarterFinals = new ArrayList<>();
    public static ArrayList<Match> Finals = new ArrayList<>();
    public static ArrayList<Match> semifinals = new ArrayList<>();
    public static void main(String[] args){


        continueTournament();
        ui = new UI();
        ui.mainInterface();
        Main.matches.get(0).getTeam1Goals();
//        saveMatchData();

    }

    public static void continueTournament() {
        if (teams.size() == 0) {
            promptNewTour();
        }
    }

    public static void promptNewTour() {
        String input = getUserInput("Would you like to continue from last session Y/n: " + "\n").trim();
        if (input.equalsIgnoreCase("y") || input.equals("")) {
            teams = readTeamData("src/CurrentTeams.txt");
            if(currentTeams.size() == 0) {
                matches = readMatchData("src/match.txt");
            }
            else if(currentTeams.size() == 8) {
                quarterFinals = readMatchData("src/match.txt");
            }
            else if(currentTeams.size() == 4) {
            semifinals =readMatchData("src/match.txt");
            }
            else if(currentTeams.size() == 2)
            {
                Finals = readMatchData("src/match.txt");
            }

        }else{
            teams = readTeamData("src/Teams.txt");
        }
    }

    public static String getUserInput(String msg){
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static ArrayList<Team> readTeamData(String file) {
        ArrayList<Team> teamList = new ArrayList<>();
        Scanner scanner = null;
        File fr = new File(file);
        try {

            scanner = new Scanner(fr);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (scanner != null)
        {
            while(scanner.hasNextLine())
            {
                String teamName = scanner.nextLine();
                teamList.add(new Team(teamName));
            }
        }

        return teamList;
    }

    public static String getGameDataFromSession()
    {
        StringBuilder gameData = new StringBuilder();
        for (Team t : Main.currentTeams)
        {
            String teamData = String.format(t.getTeamName()+"\n");
            gameData.append(teamData);
        }
        return gameData.toString();
    }

    public static String getMatchDataFromSession()
    {
        StringBuilder gameData = new StringBuilder();
        for (Match m : Main.matches)
        {
            String matchData = String.format(m.getTeam1() + ":" + m.getTeam2() +":"+m.getTeam1Goals()+":"+m.getTeam2Goals()+"\n");
            gameData.append(matchData);
        }
        return gameData.toString();
    }

    public static void saveCurrentTeamData() {
        FileWriter writer = null;
        try {
            writer = new FileWriter("src/CurrentTeams.txt");
            writer.write(getGameDataFromSession());
        } catch (IOException e) {
            System.out.println("Couldn't instantiate the FileWriter in saveCurrentTeamData()");
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (NullPointerException | IOException e) {
                System.out.println("Couldn't close the FileWriter in saveCurrentTeamData()");
                e.printStackTrace();
            }
        }
    }

    public static void saveMatchData() {
        FileWriter writer = null;
        try {
            writer = new FileWriter("src/match.txt");
            writer.write(getMatchDataFromSession());
        } catch (IOException e) {
            System.out.println("Couldn't instantiate the FileWriter in saveMatchData()");
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (NullPointerException | IOException e) {
                System.out.println("Couldn't close the FileWriter in saveMatchData()");
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Match> readMatchData(String file) {
        ArrayList<Match> matchList = new ArrayList<>();
        Scanner scanner = null;
        File fr = new File(file);
        try {

            scanner = new Scanner(fr);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (scanner != null) {
            while (scanner.hasNextLine()) {
                Team team1 = new Team("teamName");
                Team team2 = new Team("teamName");

                String[] colonSeperatedValues = scanner.nextLine().split(":");
                team1.setTeamName(colonSeperatedValues[0]);
                team2.setTeamName(colonSeperatedValues[1]);

                int i =0;
                while(i < currentTeams.size()) {
                    if (currentTeams.get(i).equals(team1.getTeamName()))
                    {
                        team1 = currentTeams.get(i);
                    }
                    if (currentTeams.get(i).equals(team2.getTeamName()))
                    {
                        team2 = currentTeams.get(i);
                    }
                    i++;
                }

                int team1Goal = Integer.parseInt(colonSeperatedValues[2]);
                int team2Goal = Integer.parseInt(colonSeperatedValues[3]);
                matchList.add(new Match(team1,team2,team1Goal,team2Goal));
            }
        }

        return matchList;
    }

}
