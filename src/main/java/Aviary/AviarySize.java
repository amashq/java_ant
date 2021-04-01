package Aviary;

public enum AviarySize {
    SMALL(1), NORMAL(2), BIG(3), LARGE(4);

    private final int size;

    private AviarySize(int size) {
        this.size = size;
    }

    public int getAviarySize() {
        return size;
    }
}
