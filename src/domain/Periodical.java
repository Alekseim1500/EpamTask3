package domain;

import java.util.LinkedHashSet;
import java.util.Set;

public class Periodical {
    private String identity;
    private String title;
    private String type;
    private boolean monthly;
    private Set<Chars> characteristics = new LinkedHashSet<Chars>();


    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getMonthly() {
        return monthly;
    }

    public void setMonthly(boolean monthly) {
        this.monthly = monthly;
    }


    public Set<Chars> getCharacteristics() {
        return characteristics;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ID: ").append(getIdentity()).append('\n');
        builder.append("Вид издания: ").append(getType()).append('\n');
        builder.append("Ежемесячное: ").append(getMonthly()).append('\n');
        for (Chars characteristic : getCharacteristics()) {
            builder.append('\t').append(characteristic.getName()).append(": ").append(characteristic.getValue()).append('\n');
        }
        return builder.toString();
    }

}
