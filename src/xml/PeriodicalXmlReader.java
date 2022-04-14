package xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import domain.*;

public class PeriodicalXmlReader {
    public List<Periodical> read(String fileName) throws FileNotFoundException {
        XMLStreamReader reader = null;
        try {
            List<Periodical> periodicals = new ArrayList<Periodical>();
            Periodical periodical = null;
            XMLInputFactory factory = XMLInputFactory.newFactory();
            reader = factory.createXMLStreamReader(new FileInputStream(fileName));
            while (reader.hasNext()) {
                int read = reader.next();
                switch (read) {
                    case XMLStreamConstants.START_ELEMENT: {
                        String tagName = reader.getLocalName();
                        if ("periodical".equals(tagName)) {
                            periodical = new Periodical();
                            periodical.setIdentity(reader.getAttributeValue(null, "id"));
                        } else if ("type".equals(tagName)) {
                            Type type = new Type();
                            type.setName(reader.getElementText());
                        } else if ("title".equals(tagName)) {
                            periodical.setTitle(reader.getElementText());
                        } else if ("monthly".equals(tagName)) {
                            periodical.setMonthly(Boolean.parseBoolean(reader.getElementText()));
                        } else if ("color".equals(tagName)) {
                            Color color = new Color();
                            color.setElement(tagName);
                            color.setValue(reader.getElementText());
                            periodical.getCharacteristics().add(color);
                        } else if ("volume".equals(tagName)) {
                            Volume volume = new Volume();
                            volume.setElement(tagName);
                            volume.setValue(reader.getElementText());
                            periodical.getCharacteristics().add(volume);
                        } else if ("glossy".equals(tagName)) {
                            Glossy glossy = new Glossy();
                            glossy.setElement(tagName);
                            glossy.setValue(reader.getElementText());
                            periodical.getCharacteristics().add(glossy);
                        } else if ("subscriptionIndex".equals(tagName)) {
                            SubscriptionIndex subscriptionIndex = new SubscriptionIndex();
                            subscriptionIndex.setElement(tagName);
                            subscriptionIndex.setValue(reader.getElementText());
                            periodical.getCharacteristics().add(subscriptionIndex);
                        }
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        String tagName = reader.getLocalName();
                        if ("periodical".equals(tagName)) {
                            periodicals.add(periodical);
                        }
                        break;
                    }
                }
            }
            return periodicals;
        } catch (XMLStreamException e) {
            return null;
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
            }
        }
    }
}