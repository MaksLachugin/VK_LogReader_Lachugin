package ru.vk.word;

public class AnyWord implements BaseWord {
    private String word;

    private void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public AnyWord(String str) {
        setWord(str);
    }

    @Override
    public boolean isExists(String line) {
        return line.toLowerCase().contains(getWord().toLowerCase());
    }

}
