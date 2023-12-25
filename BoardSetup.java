import java.util.Random;

public class BoardSetup {
    //2D matrix to store the board
    public int[][] board = new int[3][3];
    // 1 means X, 0 means empty, -1 means O

    //printing the board
    public void print(){
        System.out.println("");
        System.out.println("  -----------  ");
        int x = 1;
        for(int i = 0; i < 3; i++){
            System.out.print(" | ");
            for(int j = 0; j < 3; j++){
                System.out.print(x + " | ");
                x++;
            }
            System.out.println("");
            System.out.println("  -----------  ");
        }
    }
    
    //display boards current situation
    public void display(){
        System.out.println("");
        System.out.println("  -----------  ");
        for(int i = 0; i < 3; i++){
            System.out.print(" | ");
            for(int j = 0; j < 3; j++){
                if(board[i][j] == 0){
                    //if 0 then that spot is empty
                    System.out.print(" ");
                }
                else{
                    if(board[i][j] == 1){
                        //If 1 then its X
                        System.out.print("X");
                    }
                    else if(board[i][j] == -1){
                        //If -1 then its O
                        System.out.print("O");
                    }
                }
                System.out.print(" | ");
            }
            System.out.println("");
            System.out.println("  -----------  ");
        }
    }
    
    //to check if a given position is empty or occupoed in the board
    public int Check(int pos){
        pos -= 1; //to adjust array indexing from 0
        int i = pos / 3;
        int j = pos % 3;
        if(board[i][j] == 0){
            //if empty return 1
            return 1;
        }
        else{
            //if occupied return 0
            return 0;
        }
    }

    //to check if the board is in win condition
    //if X wins return 1, if O wins return -1, if no player wins, then draw, return 0
    public int Win() {
        int sum;
        //check for rows first
        for(int i = 0; i < 3; i++){
            sum = 0;
            for(int j = 0; j < 3; j++){
                sum += board[i][j];
            }
            //X won (1 + 1 + 1)
            if(sum == 3){
                return 1;
            }else if (sum == -3){
                //O won (-1 + -1 + -1)
                return -1;
            }
        }
        
        //check for columns then
        for(int i = 0; i < 3; i++){
            sum = 0;
            for(int j = 0; j < 3; j++){
                sum += board[j][i];
            }
            //if sum 3 (1 + 1 + 1), X won
            if(sum == 3){
                return 1;
            }else if (sum == -3){
                //O won(-1 + -1 + -1)
                return -1;
            }
        }

        //check diagonals
        sum = 0;
        for(int i = 0; i < 3; i++){
            sum += board[i][i];
        }
        if(sum == 3){
            return 1;
        } else if(sum == -3){
            return -1;
        }

        //check the other diagonals
        sum = 0;
        for(int i = 0; i < 3; i++){
            sum += board[i][2 - i];
        }
        if(sum == 3){
            return 1;
        } else if (sum == -3){
            return -1;
        }

        //if no one wins, its a draw
        return 0;
    }

    //update the value of the move the player enters
    public void Update(int pos, int value){
        pos -= 1;
        int i = pos / 3;
        int j = pos % 3;
        board[i][j] = value;
    }

    //clears the board for next board
    public void clear(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = 0;
            }
        }
    }

    //for player vs computer
    public int Computer(){
        int pos;

        if(board[1][1] == -1)
		{
			if(board[0][1] == -1 && board[2][1] == 0){
				pos = 8;
                Update(pos, -1);
                return pos;
            }
			if(board[2][1] == -1 && board[0][1] == 0){
				pos = 2;
                Update(pos, -1);
                return pos;
            }
			if(board[0][2] == -1 && board[2][0] == 0){
				pos = 7;
                Update(pos, -1);
                return pos;
            }
			if(board[2][0] == -1 && board[0][2] == 0){
				pos = 3;
                Update(pos, -1);
                return pos;
            }
			if(board[1][2] == -1 && board[1][0] == 0){
				pos = 4;
                Update(pos, -1);
                return pos;
            }
			if(board[1][0] == -1 && board[1][2] == 0){
				pos = 6;
                Update(pos, -1);
                return pos;
            }
			if(board[2][2] == -1 && board[0][0] == 0){
				pos = 1;
                Update(pos, -1);
                return pos;
            }
			if(board[0][0] == -1 && board[2][2] == 0){
				pos = 9;
                Update(pos, -1);
                return pos;
            }
		}
		// check all winning combinations going through top left corner
		else if(board[0][0] == -1)
		{
			if(board[0][1] == -1 && board[0][2] == 0){
				pos = 3;
                Update(pos, -1);
                return pos;
            }
			if(board[0][2] == -1 && board[0][1] == 0){
				pos = 2;
                Update(pos, -1);
                return pos;
            }
			if(board[1][0] == -1 && board[2][0] == 0){
				pos = 7;
                Update(pos, -1);
                return pos;
            }
			if(board[2][0] == -1 && board[1][0] == 0){
				pos = 4;
                Update(pos, -1);
                return pos;
            }
		}
		// check all winning combinations going through bottom left corner
		else if(board[2][0] == -1)
		{
			if(board[1][0] == -1 && board[0][0] == 0){
				pos = 1;
                Update(pos, -1);
                return pos;
            }
			if(board[0][0] == -1 && board[1][0] == 0){
				pos = 7;
                Update(pos, -1);
                return pos;
            }
			if(board[2][1] == -1 && board[2][2] == 0){
				pos = 9;
                Update(pos, -1);
                return pos;
            }
			if(board[2][2] == -1 && board[2][1] == 0){
				pos = 8;
                Update(pos, -1);
                return pos;
            }
		}
		// check all winning combinations going through bottom right corner
		else if(board[2][2] == -1)
		{
			if(board[1][2] == -1 && board[0][2] == 0){
				pos = 3;
                Update(pos, -1);
                return pos;
            }
			if(board[0][2] == -1 && board[1][2] == 0){
				pos = 6;
                Update(pos, -1);
                return pos;
            }
			if(board[2][1] == -1 && board[2][0] == 0){
				pos = 7;
                Update(pos, -1);
                return pos;
            }
			if(board[2][0] == -1 && board[2][1] == 0){
				pos = 8;
                Update(pos, -1);
                return pos;
            }
		}
		// check all winning combinations going through top right corner
		else if(board[0][2] == -1)
		{
			if(board[0][1] == -1 && board[0][0] == 0){
				pos = 1;
                Update(pos, -1);
                return pos;
            }
			if(board[0][0] == -1 && board[0][1] == 0){
				pos = 2;
                Update(pos, -1);
                return pos;
            }
			if(board[1][2] == -1 && board[2][2] == 0){
				pos = 9;
                Update(pos, -1);
                return pos;
            }
			if(board[2][2] == -1 && board[1][2] == 0){
				pos = 6;
                Update(pos, -1);
                return pos;
            }
		}

        //try to oppose the winning move of the player if computer can firstly
        
        //check center move first
        else if(board[1][1] == 1)
		{
			if(board[0][1] == 1 && board[2][1] == 0){
				pos = 8;
                Update(pos, -1);
                return pos;
            }
			if(board[2][1] == 1 && board[0][1] == 0){
				pos = 2;
                Update(pos, -1);
                return pos;
            }
			if(board[0][2] == 1 && board[2][0] == 0){
				pos = 7;
                Update(pos, -1);
                return pos;
            }
			if(board[2][0] == 1 && board[0][2] == 0){
				pos = 3;
                Update(pos, -1);
                return pos;
            }
			if(board[1][2] == 1 && board[1][0] == 0){
				pos = 4;
                Update(pos, -1);
                return pos;
            }
			if(board[1][0] == 1 && board[1][2] == 0){
				pos = 6;
                Update(pos, -1);
                return pos;
            }
			if(board[2][2] == 1 && board[0][0] == 0){
				pos = 1;
                Update(pos, -1);
                return pos;
            }
			if(board[0][0] == 1 && board[2][2] == 0){
				pos = 9;
                Update(pos, -1);
                return pos;
            }
		}
		// check all winning combinations going through top left corner
		else if(board[0][0] == 1)
		{
			if(board[0][1] == 1 && board[0][2] == 0){
				pos = 3;
                Update(pos, -1);
                return pos;
            }
			if(board[0][2] == 1 && board[0][1] == 0){
				pos = 2;
                Update(pos, -1);
                return pos;
            }
			if(board[1][0] == 1 && board[2][0] == 0){
				pos = 7;
                Update(pos, -1);
                return pos;
            }
			if(board[2][0] == 1 && board[1][0] == 0){
				pos = 4;
                Update(pos, -1);
                return pos;
            }
		}
		// check all winning combinations going through bottom left corner
		else if(board[2][0] == 1)
		{
			if(board[1][0] == 1 && board[0][0] == 0){
				pos = 1;
                Update(pos, -1);
                return pos;
            }
			if(board[0][0] == 1 && board[1][0] == 0){
				pos = 7;
                Update(pos, -1);
                return pos;
            }
			if(board[2][1] == 1 && board[2][2] == 0){
				pos = 9;
                Update(pos, -1);
                return pos;
            }
			if(board[2][2] == 1 && board[2][1] == 0){
				pos = 8;
                Update(pos, -1);
                return pos;
            }
		}
		// check all winning combinations going through bottom right corner
		else if(board[2][2] == 1)
		{
			if(board[1][2] == 1 && board[0][2] == 0){
				pos = 3;
                Update(pos, -1);
                return pos;
            }
			if(board[0][2] == 1 && board[1][2] == 0){
				pos = 6;
                Update(pos, -1);
                return pos;
            }
			if(board[2][1] == 1 && board[2][0] == 0){
				pos = 7;
                Update(pos, -1);
                return pos;
            }
			if(board[2][0] == 1 && board[2][1] == 0){
				pos = 8;
                Update(pos, -1);
                return pos;
            }
		}
		// check all winning combinations going through top right corner
		else if(board[0][2] == 1)
		{
			if(board[0][1] == 1 && board[0][0] == 0){
				pos = 1;
                Update(pos, -1);
                return pos;
            }
			if(board[0][0] == 1 && board[0][1] == 0){
				pos = 2;
                Update(pos, -1);
                return pos;
            }
			if(board[1][2] == 1 && board[2][2] == 0){
				pos = 9;
                Update(pos, -1);
                return pos;
            }
			if(board[2][2] == 1 && board[1][2] == 0){
				pos = 6;
                Update(pos, -1);
                return pos;
            }
		}

        //if computer can win, it will move there

        // check all available winning combinations going through center

        

        //if nothing happens, the computer moves at a random unoccupied position
        Random random = new Random();
        pos = random.nextInt(9) + 1;
        while (Check(pos) == 0) {
            pos = random.nextInt(9) + 1;
        }
        Update(pos, -1);
        return pos;
    }
}
