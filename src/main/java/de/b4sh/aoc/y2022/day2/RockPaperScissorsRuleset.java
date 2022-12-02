package de.b4sh.aoc.y2022.day2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum RockPaperScissorsRuleset {
    ROCK(1,Arrays.asList("A","X"),Arrays.asList("C","Z"),Arrays.asList("B","Y")),
    PAPER(2,Arrays.asList("B","Y"),Arrays.asList("A","X"),Arrays.asList("C","Z")),
    SCISSORS(3,Arrays.asList("C","Z"),Arrays.asList("B","Y"),Arrays.asList("A","X"));

    private List<String> identifier;
    private List<String> beats;
    private List<String> loses;
    private int score;

    RockPaperScissorsRuleset(final int score, final List<String> keys, final List<String> beats, final List<String> loses) {
        this.score = score;
        this.identifier = keys;
        this.loses = loses;
        this.beats = beats;
    }

    public static int calculateRound(final String opponent, final String player){
        RockPaperScissorsRuleset pl = getType(player);
        if(pl.beats.contains(opponent)){ //check win player
            return 6 + pl.score;
        } else if (pl.loses.contains(opponent)) { //check loss
            return 0 + pl.score;
        }
        return 3 + pl.score; //default: draw
    }

    public static RockPaperScissorsRuleset getType(final String type){
        return Arrays.stream(RockPaperScissorsRuleset.values()).filter(element -> element.identifier.contains(type)).toList().stream().findFirst().get();
    }

    public List<String> getBeats() {
        return beats;
    }

    public List<String> getLoses() {
        return loses;
    }
}
