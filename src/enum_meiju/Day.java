package enum_meiju;

public enum Day {
    Monday("星期一", 1), Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
    private String name;
    private int index;

    private Day() {
    }

    Day(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
