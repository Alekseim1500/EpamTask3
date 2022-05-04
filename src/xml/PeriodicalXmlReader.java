package xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import domain.Color;
import domain.Glossy;
import domain.Periodical;
import domain.Volume;
import domain.SubscriptionIndex;

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
                        switch (tagName){
                            case "periodical":
                                periodical = new Periodical();
                                periodical.setIdentity(reader.getAttributeValue(null, "id"));
                                break;
                            case "type":
                                try {
                                    periodical.setType(reader.getElementText());
                                }catch (NullPointerException e){
                                    e.printStackTrace();
                                }
                                break;
                            case "title":
                                try {
                                    periodical.setTitle(reader.getElementText());
                                }catch (NullPointerException e){
                                    e.printStackTrace();
                                }
                                break;
                            case "monthly":
                                try{
                                    periodical.setMonthly(Boolean.parseBoolean(reader.getElementText()));
                                }catch (NullPointerException e){
                                    e.printStackTrace();
                                }
                                break;
                            case "color":
                                try{
                                    Color color = new Color();
                                    color.setElement(tagName);
                                    color.setValue(reader.getElementText());
                                    periodical.getCharacteristics().add(color);
                                }catch (NullPointerException e){
                                    e.printStackTrace();
                                }
                                break;
                            case "volume":
                                try {
                                    Volume volume = new Volume();
                                    volume.setElement(tagName);
                                    volume.setValue(reader.getElementText());
                                    periodical.getCharacteristics().add(volume);
                                }catch (NullPointerException e){
                                    e.printStackTrace();
                                }
                                break;
                            case "glossy":
                                try {
                                    Glossy glossy = new Glossy();
                                    glossy.setElement(tagName);
                                    glossy.setValue(reader.getElementText());
                                    periodical.getCharacteristics().add(glossy);
                                }catch (NullPointerException e){
                                    e.printStackTrace();
                                }
                                break;
                            case "subscriptionIndex":
                                try {
                                    SubscriptionIndex subscriptionIndex = new SubscriptionIndex();
                                    subscriptionIndex.setElement(tagName);
                                    subscriptionIndex.setValue(reader.getElementText());
                                    periodical.getCharacteristics().add(subscriptionIndex);
                                }catch (NullPointerException e){
                                    e.printStackTrace();
                                }
                                break;
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
                e.printStackTrace();
            }
        }
    }
}