package domain;

public class Volume extends Chars{
    public Volume() {
        super("Объём страниц");
    }

    private Integer count;

    @Override
    public void setValue(String value) {
        count = Integer.parseInt(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(count);
    }
}
