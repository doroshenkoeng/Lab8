package sample;

import java.util.ArrayList;

/**
 * <b>This class provides methods for game between 2 players.</b>
 */
public class CardGame {
    /**
     * A Field that keeps cards number of player's deck.
     */
    private int mCardsNumber;
    /**
     * A Field that keeps player 1 current score in the card game.
     */
    private int mCurrentScore1;
    /**
     * A Field that keeps player 2 current score in the card game.
     */
    private int mCurrentScore2;
    /**
     * A Field that keeps player 1 move number on which the player uses super skill.
     */
    private int mSuperSkillTimeCame1;
    /**
     * A Field that keeps player 2 move number on which the player uses super skill.
     */
    private int mSuperSkillTimeCame2;
    /**
     * A Field that keeps player 1 card deck.
     */
    private ArrayList<Integer> mDeck1;
    /**
     * A Field that keeps player 2 card deck.
     */
    private ArrayList<Integer> mDeck2;

    /**
     * A constructor with 2 parameters.
     *
     * @param player1 the 1st player.
     * @param player2 the 2nd player.
     */
    public CardGame(Player player1, Player player2) {
        mCardsNumber = player1.getCardsNumber();
        mCurrentScore1 = 0;
        mCurrentScore2 = 0;
        mDeck1 = new ArrayList<>();
        mDeck2 = new ArrayList<>();
        for (int i = 0; i < mCardsNumber; i++) {
            mDeck1.add(player1.getDeck());
            mDeck2.add(player2.getDeck());
        }
        mSuperSkillTimeCame1 = player1.getSuperSkillMoveNumber();
        mSuperSkillTimeCame2 = player2.getSuperSkillMoveNumber();
    }

    /**
     * A method simulated the card game.
     */
    public void startGame() {
        for (int i = 0; i < mCardsNumber; i++) {
            int card1 = mDeck1.get(i);
            int card2 = mDeck2.get(i);
            if (mSuperSkillTimeCame1 == i) card1 = 5;
            if (mSuperSkillTimeCame2 == i) card2 = 5;
            if (card1 > card2) {
                mCurrentScore1++;
            } else if (card1 < card2) {
                mCurrentScore2++;
            }
        }
    }

    /**
     * @return <b>1</b> if player1 won; <br>
     * <b>2</b> if player2 won; <br>
     * <b>0</b> if it's draw.
     */
    public int getResult() {
        if (mCurrentScore1 > mCurrentScore2) return 1;
        else if (mCurrentScore1 < mCurrentScore2) return 2;
        else return 0;
    }


}
