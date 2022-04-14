package domain;

public class SubscriptionIndex extends Chars {
    public SubscriptionIndex() {
        super("Имеет почтовый индекс");
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
