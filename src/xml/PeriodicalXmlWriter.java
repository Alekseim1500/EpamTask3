package xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import domain.Chars;
import domain.Periodical;

public class PeriodicalXmlWriter {
    public void write(List<Periodical> periodicals, String fileName) throws FileNotFoundException, XMLStreamException {
        XMLStreamWriter writer = null;
        try {
            XMLOutputFactory factory = XMLOutputFactory.newFactory();
            writer = factory.createXMLStreamWriter(new FileOutputStream(fileName), "UTF-8");
            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("periodicals");
            writer.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            writer.writeAttribute("xmlns", "http://www.example.org/periodicals");
            writer.writeAttribute("xsi:schemaLocation", "http://www.example.org/periodicals periodicals.xsd");
            for (Periodical periodical : periodicals) {
                writer.writeStartElement("periodical");
                writer.writeAttribute("id", periodical.getIdentity());
                writer.writeStartElement("title");
                writer.writeCharacters(periodical.getTitle());
                writer.writeEndElement();
                writer.writeStartElement("type");
                writer.writeCharacters(periodical.getType());
                writer.writeEndElement();
                writer.writeStartElement("monthly");
                writer.writeCharacters(periodical.getMonthly().toString());
                writer.writeEndElement();

                writer.writeStartElement("Chars");
                for (Chars chara : periodical.getCharacteristics()) {
                    writer.writeStartElement(chara.getElement());
                    writer.writeCharacters(chara.getValue());
                    writer.writeEndElement();
                }
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
    }
}