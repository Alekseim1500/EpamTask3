package domain;

public class Monthly {
    private Boolean monthly;
    private String name;

    public Monthly() {
        this.name="Ежемесячный";
    }

    public Boolean getMonthly() {
        return monthly;
    }

    public void setMonthly(Boolean is) {
        this.monthly = is;
    }
}
