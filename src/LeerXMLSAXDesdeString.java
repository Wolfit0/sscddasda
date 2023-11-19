import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.StringReader;

public class LeerXMLSAXDesdeString {
    public static void main(String[] args) {
        try {
            String xmlString = "?xml version='1.0' encoding='utf-8'?><root><nombre>John</nombre><valor>123</valor></root>";

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            ManejadorSAX handler = new ManejadorSAX();
            saxParser.parse(new InputSource(new StringReader(xmlString)), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ManejadorSAX extends DefaultHandler {
    boolean bNombre = false;
    boolean bValor = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("nombre")) {
            bNombre = true;
        } else if (qName.equalsIgnoreCase("valor")) {
            bValor = true;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (bNombre) {
            System.out.println("Nombre: " + new String(ch, start, length));
            bNombre = false;
        } else if (bValor) {
            System.out.println("Valor: " + new String(ch, start, length));
            bValor = false;
        }
    }
}
