import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class UI
{
    Scanner interfaceScan = new Scanner(System.in);
    int userInput;
    Data data = new Data();
    Tournament tour = new Tournament();

    public void mainInterface()
    {

        System.out.println("MAIN INTERFACE");
        System.out.println("1.Team menu");
        System.out.println("2.Match menu");
        System.out.println("3.Tournament menu");
        System.out.println("4.Exit");
        userInput = interfaceScan.nextInt();

        switch (userInput)
        {
            case 1:
                teamMenu();
                break;
            case 2:
                matchMenu();
                break;
            case 3:
                tournamentMenu();
                break;

            case 4:
                System.exit(0);
            default:
                System.out.println("not a valid option");
        }

    }

    public void teamMenu()
    {
        System.out.println("TEAM MENU");
        System.out.println("1.Register team");
        System.out.println("2.Delete team");
        System.out.println("3.View all teams registered");
        System.out.println("4.Back to menu");
        userInput = interfaceScan.nextInt();

        switch (userInput)
        {
            case 1:
                data.registerTeam();
                mainInterface();
                break;
            case 2:
                data.deleteTeam();
                System.out.println(Main.teams);
                mainInterface();
                break;
            case 3:
                data.allTeams();
                mainInterface();
                break;
            case 4:
                mainInterface();
                break;
            default:
                System.out.println("Not a valid option");

        }
    }

    public void matchMenu()
    {
        System.out.println("MATCH MENU");
        System.out.println("1.Create Matches");
        System.out.println("2.Register match results");
        System.out.println("3.Back to menu");
        System.out.println("4.read test");
        userInput = interfaceScan.nextInt();

        switch (userInput)
        {
            case 1:
                if(Main.currentTeams.size() == 0) {
                    data.randomMatchUps(Main.teams, Main.matches);
                }
                else if(Main.currentTeams.size() == 8) {
                    data.randomMatchUps(Main.currentTeams, Main.quarterFinals);
                }
                else if(Main.currentTeams.size() == 4) {
                    data.randomMatchUps(Main.currentTeams, Main.semifinals);
                }
                else if(Main.currentTeams.size() == 2) {
                    data.randomMatchUps(Main.currentTeams, Main.Finals);
                }
                mainInterface();
                break;
            case 2:
                if(Main.currentTeams.size() == 0) {
                    System.out.println("Jeg har lavet hold i matches");
                    data.registerMatches(Main.matches);
                }
                else if(Main.currentTeams.size() == 8) {
                    System.out.println("Jeg har lavet hold i quaterfinals");
                    data.registerMatches(Main.quarterFinals);
                }
                else if(Main.currentTeams.size() == 4) {
                    data.registerMatches(Main.semifinals);
                }
                else if(Main.currentTeams.size() == 2){
                    data.registerMatches(Main.Finals);
                }
                mainInterface();
                break;
            case 3:
                mainInterface();
                break;
            case 4:
                Main.matches = Main.readMatchData("src/match.txt");
                System.out.println(Main.matches);
                break;
            default:
                System.out.println("Not a valid option");

        }

    }

    public void tournamentMenu()
    {
        System.out.println("TOURNAMENT MENU");
        System.out.println("1.Tournament placements");
        System.out.println("2.Tournament match schedule");
        System.out.println("3.Tournament simulation");
        System.out.println("4.Back to menu");
        userInput = interfaceScan.nextInt();

        switch (userInput)
        {
            case 1:
                tournamentPlacement();
                mainInterface();
                break;
            case 2:
                tour.tournamentSchedule();
                mainInterface();
                break;
            case 3:
                tour.tournamentSim();
                mainInterface();
                break;
            case 4:
                mainInterface();
                break;
            default:
                System.out.println("Not a valid option");

        }

    }




    public void tournamentPlacement()
    {
        System.out.println("Stats for Matches" + "\n");

        System.out.println("Gruppespil");
        System.out.println(Main.matches + "\n");
        System.out.println("QuarterFinals");
        System.out.println(Main.quarterFinals + "\n");
        System.out.println("SemiFinals");
        System.out.println(Main.semifinals + "\n");
        System.out.println("Final");
        System.out.println(Main.Finals + "\n");

    }

}

