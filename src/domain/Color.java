package domain;

public class Color extends Chars {
    public Color() {
        super("Цветной");
    }

    private Boolean is;

    @Override
    public void setValue(String value) {
        is = Boolean.parseBoolean(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(is);
    }
}
