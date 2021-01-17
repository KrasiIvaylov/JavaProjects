package viceCity.models.players;

public class MainPlayer extends BasePlayer{
    private static final int INITIAL_LIFE_POINTS = 100;
    private static final String INITIAL_NAME = "Tommy Vercetti";

    public MainPlayer() {
        super(INITIAL_NAME, INITIAL_LIFE_POINTS);
    }
}
