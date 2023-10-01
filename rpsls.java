import java.util.*;
class rpsls{
    public static void main(String[] args){
        String[] action = {"Rock", "Paper", "Scissor", "Lizard", "Spock"};
        Scanner ob = new Scanner(System.in);
        int player;
        int cpu;
        while(true){
            System.out.print("User input : ");
            int choice = find(ob.nextLine(), action);
            while(true){
                if(choice>action.length){
                    System.out.println("Choice unavailable");
                    System.out.println("Try Again");
                    choice = find(ob.nextLine(), action);
                }
                else{
                    player = choice;
                    break;
                }
            }
            System.out.print("Computer input : ");
            cpu = (new Random()).nextInt(5);
            System.out.println(action[cpu]);

            int win = logic(player, cpu);
            if(win==3)
                System.out.println("TIE");
            else if(win==2)
                System.out.println("Player LOST");
            else if(win==1)
                System.out.println("Player WON");
            else
                System.out.println("Unexpected Error");

            System.out.println("Play Again? (y/n)");
            if(ob.nextLine().equalsIgnoreCase("n"))
                break;
        }
    }

    private static int logic(int player, int cpu){
        if(player==cpu)
            return 3;
        else{
            switch (player){
                case 0: return (cpu==2 || cpu==3)?1:2;
                case 1: return (cpu==0 || cpu==4)?1:2;
                case 2: return (cpu==1 || cpu==3)?1:2;
                case 3: return (cpu==1 || cpu==4)?1:2;
                case 4: return (cpu==0 || cpu==2)?1:2;
                default: return 999;
            }
        }

    }

    private static int find(String s, String[] action){
        for(int i=0; i<action.length; i++){
            if(action[i].equalsIgnoreCase(s))
                return i;
        }
        return 999;
    }
}