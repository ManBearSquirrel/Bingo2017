package com.arkansascodingacademy;

public class Card
{
    private Square square[][];

    public Card()
    {
        square = new Square[5][5];

        square[0][0] = new Square(7);
        square[0][1] = new Square(19);
        square[0][2] = new Square(35);
        square[0][3] = new Square(51);
        square[0][4] = new Square(65);

        square[1][0] = new Square(1);
        square[1][1] = new Square(24);
        square[1][2] = new Square(34);
        square[1][3] = new Square(57);
        square[1][4] = new Square(74);

        square[2][0] = new Square(3);
        square[2][1] = new Square(16);
        square[2][2] = new Square(0);
        square[2][2].cover();
        square[2][3] = new Square(46);
        square[2][4] = new Square(72);

        square[3][0] = new Square(8);
        square[3][1] = new Square(17);
        square[3][2] = new Square(33);
        square[3][3] = new Square(55);
        square[3][4] = new Square(70);

        square[4][0] = new Square(11);
        square[4][1] = new Square(20);
        square[4][2] = new Square(40);
        square[4][3] = new Square(49);
        square[4][4] = new Square(62);
    }

    public void print()
    {
        //Go through rows 0 to 4
        for (int row = 0; row < 5; row++)
        {
            //For the current row go through columns 0 to 4
            for (int column = 0; column < 5; column++)
            {
                //print out the square
                square[row][column].print();
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    public void play(int number)
    {
        for (int row = 0; row < 5; row++)
        {
            //For the current row go through columns 0 to 4
            for (int column = 0; column < 5; column++)
            {
                //Check for the number
                if (square[row][column].getNumber() == number)
                {
                    //If we found the number cover it
                    square[row][column].cover();
                }
            }
        }
    }

    public boolean bingo()
    {
        boolean bingo = false;

        if (bingoByColumn() || bingoByRow() || bingoByDiagonal() || bingoByStamp())
        //if (bingoByStamp())
        {
            bingo = true;
        }

        return bingo;
    }

    private boolean bingoByColumn()
    {
        boolean bingo = false;

        for (int column = 0; column < 5; column++)
        {
            //Check to see if the square is covered
            if (square[0][column].isCovered() &&
                    square[1][column].isCovered() &&
                    square[2][column].isCovered() &&
                    square[3][column].isCovered() &&
                    square[4][column].isCovered())
            {
                bingo = true;
            }
        }

        return bingo;
    }

    private boolean bingoByRow()
    {
        boolean bingo = false;

        //Check for row
        for (int row = 0; row < 5; row++)
        {
            //Check to see if the square is covered
            if (square[row][0].isCovered() &&
                    square[row][1].isCovered() &&
                    square[row][2].isCovered() &&
                    square[row][3].isCovered() &&
                    square[row][4].isCovered())
            {
                bingo = true;
            }
        }

        return bingo;
    }

    private boolean bingoByDiagonal()
    {
        boolean bingo = false;

        //TODO Code this test

        return bingo;

    }

    public boolean bingoByStamp()
    {
        boolean bingo = false;

        for (int row = 0; row < 4; row++)
        {
            for (int column = 0; column < 4; column++)
            {
                if (square[column][row].isCovered() &&
                        square[column + 1][row].isCovered() &&
                        square[column][row + 1].isCovered() &&
                        square[column + 1][row + 1].isCovered())
                {
                    bingo = true;
                }
            }
        }
        return bingo;
    }

    public static void main(String[] args)
    {
        Card card = new Card();
        card.print();

    }

}
