import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import domain.Periodical;
import xml.PeriodicalXmlReader;
import xml.PeriodicalXmlValidator;
import xml.PeriodicalXmlWriter;

public class Main {
    public static void main(String[] args) throws IOException, XMLStreamException {
        PeriodicalXmlValidator validator = new PeriodicalXmlValidator("periodicals.xml");
        if (validator.validate()) {
            PeriodicalXmlReader reader = new PeriodicalXmlReader();
            List<Periodical> periodicals = reader.read("periodicals.xml");
            Collections.sort(periodicals, new Comparator<Periodical>() {
                @Override
                public int compare(Periodical o1, Periodical o2) {
                    return o2.getTitle().compareTo(o1.getTitle());
                }
            });
            for (Periodical periodical : periodicals) {
                System.out.println(periodical);
            }
            PeriodicalXmlWriter writer = new PeriodicalXmlWriter();
            writer.write(periodicals, "periodicals-new.xml");
            System.out.println("OK");
        } else {
            System.out.println(validator.getError());
        }
    }

}