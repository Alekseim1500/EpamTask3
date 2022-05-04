package domain;

public class Color extends Chars {
    public Color() {
        super("Цветной");
    }

    private Boolean isColor;

    @Override
    public void setValue(String value) {
        isColor = Boolean.parseBoolean(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(isColor);
    }
}
