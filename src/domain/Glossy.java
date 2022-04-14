package domain;

public class Glossy extends Chars{
    public Glossy() {
        super("Глянцевый");
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
