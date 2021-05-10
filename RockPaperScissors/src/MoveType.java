public enum MoveType {

    ROCK{

        private static final String trumpType = "blunts";

        @Override
        public boolean trumps(MoveType otherMove) {
            if( otherMove == SCISSORS ){
                return true;
            }
            return false;
        }

        @Override
        public String getTrumpType() { return trumpType; }
    },
    PAPER{

        private static final String trumpType = "wraps";

        @Override
        public boolean trumps(MoveType otherMove) {
            if( otherMove == ROCK ){
                return true;
            }
            return false;
        }

        @Override
        public String getTrumpType() {
            return trumpType;
        }
    },
    SCISSORS {

        private static final String trumpType = "cuts";

        @Override
        public boolean trumps(MoveType otherMove) {
            if( otherMove == PAPER ){
                return true;
            }
            return false;
        }

        @Override
        public String getTrumpType() {
            return trumpType;
        }
    };

    public static MoveType parseMove(String move){

        switch (move){
            case "r":
                return ROCK;
            case "p":
                return  PAPER;
            case "s":
                return SCISSORS;
        }
        return null;
    }

    public abstract boolean trumps( MoveType otherMove );
    public abstract String getTrumpType();

}
