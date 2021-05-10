public class Opponent {

    public String pickMove(){

        String moveChoice = new String();

        int randomMove = (int)(Math.random()*3);

        switch (randomMove){
            case 0:
                moveChoice = "r";
                break;
            case 1:
                moveChoice = "p";
                break;
            case 2:
                moveChoice = "s";
                break;
        }

        return moveChoice;
    }
}
