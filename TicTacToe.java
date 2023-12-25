import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("   TIC TAC TOE GAME   ");
        System.out.println("Choose how you wish to play by pressing valid keys as describes below");
        System.out.println(" Enter 1 for Multiplayer");
        System.out.println(" Enter 2 for playing against COmputer");
        System.out.println(" Enter 0 for quitting the game and resetting the board");

        // take input from the user
        int mode = scan.nextInt();
        // initialize the new board
        BoardSetup board = new BoardSetup();

        if(mode == 0){
            System.out.println(" Game Over !!");
            System.exit(0);
        }

        while(mode != 0){
            if(mode == 1){
                System.out.println(" Player 1 input is X and Player 2 input is O");
                System.out.println(" Player 1 moves first");
                board.print();

                int pos;
                int count = 0;

                //while nobody wins the game or a draw happens
                while(board.Win() == 0){
                    if(count % 2 == 0 ){
                        //even count means player 1 enters its move
                        System.out.println("Player 1 choose a pos in board to move");
                        pos = scan.nextInt();

                        //if invalid position is entered ask for a new valid position
                        while((pos < 1 || pos > 9) || board.Check(pos) == 0){
                            System.out.println("Invalid position is entered");
                            System.out.println("Player 1 please enter a valid unoccupied position between 1 and 9");
                            pos = scan.nextInt();
                        }
                        //when valid is entered, update the board
                        board.Update(pos, 1);
                    } else{
                        // if odd count then player 2 moves
                        System.out.println("Player 2 choose a pos in board to move");
                        pos = scan.nextInt();

                        //if invalid position is entered ask for a new valid position
                        while((pos < 1 || pos > 9) || board.Check(pos) == 0){
                            System.out.println("Invalid position is entered");
                            System.out.println("Player 2 please enter a valid unoccupied position between 1 and 9");
                            pos = scan.nextInt();
                        }
                        //when valid is entered, update the board
                        board.Update(pos, -1);
                    }
                    //display the board after each move
                    board.display();
                    count++;

                    //check the win and draw condition after each move
                    if(board.Win() == 1){
                        System.out.println("Congratulations !! Player 1 has won !!");
                        break;
                    } else if(board.Win() == -1){
                        System.out.println("Congratulations !! Player 2 has won !!");
                        break;
                    }

                    if(count == 9){
                        // all moves are over, draw case
                        System.out.println("Ohh! Its a Draw ! Better luck next time !");
                        break;
                    }
                }
                board.clear();
                System.out.println("Want another Multiplayer game press Y (Case Sensitive)");
                System.out.println("Want to exit the game then press Q");

                char another = scan.next().charAt(0);
                if(another == 'Y'){
                    continue;
                } else if(another == 'Q'){
                    System.out.println(" Game Over !!");
                    System.exit(0);
                }
            }
            else if(mode == 2){
                System.out.println("Player is X, Computer is O");
                board.print();

                int pos, count = 0;
                while(board.Win() == 0){
                    //while nobody wins game, the game goes on till no places are left
                    if(count % 2 == 0 ){
                        //even count means player 1 enters its move
                        System.out.println("Player 1 choose a pos in board to move");
                        pos = scan.nextInt();

                        //if invalid position is entered ask for a new valid position
                        while((pos <= 1 || pos >= 9) && board.Check(pos) == 0){
                            System.out.println("Invalid position is entered");
                            System.out.println("Player 1 please enter a valid unoccupied position between 1 and 9");
                            pos = scan.nextInt();
                        }
                        //when valid is entered, update the board
                        board.Update(pos, 1);
                    }else{
                        //computer makes a move when count is odd
                        pos = board.Computer();
                        System.out.println("The computer chose position " + pos);
                    }
                    //display the board after every move
                    board.display();
                    count++;
                    //check win and draw condition after every move as well
                    if(board.Win() == 1){
                        System.out.println("Congratulations ! You defeated the Computer");
                        break;
                    }else if(board.Win() == -1){
                        System.out.println("Sorry ! Computer defeated you ! Better luck next time!");
                        break;
                    }

                    if(count == 9){
                        System.out.println("Ohh ! Its a draw ! Better luck next time !");
                        break;
                    }
                }
                board.clear();

                System.out.println("Want another game with Computer, press Y (Case Sensitive)");
                System.out.println("Want to exit the game then press Q");

                char another = scan.next().charAt(0);
                if(another == 'Y'){
                    continue;
                } else if(another == 'Q'){
                    System.out.println(" Game Over !!");
                    System.exit(0);
                }
            }else{
                // if invalid mode is entered
                System.out.println("Enter valid mode only from 0 - 2 !");
            }

            System.out.println(" Enter 1 for Multiplayer");
            System.out.println(" Enter 2 for playing against COmputer");
            System.out.println(" Enter 0 for quitting the game and resetting the board");

            // take input from the user
            mode = scan.nextInt();
        }
        System.out.println("");
        scan.close();
    }
}
