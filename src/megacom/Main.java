package megacom;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {

        XmlMapper xmlMapper = new XmlMapper();
        URL firstURL = new URL("http://www.geoplugin.net/xml.gp?base_currency=USD");

        GeoPluginFirst firstObject = xmlMapper.readValue(firstURL, GeoPluginFirst.class);
        URL secondURL = new URL("http://www.geoplugin.net/xml.gp?ip=xx.xx.xx.xx");
        secondURL = new URL(secondURL.toString().replaceAll
                ("xx.xx.xx.xx", firstObject.getRequest()));

        GeoPlugin secondObject = xmlMapper.readValue(secondURL, GeoPlugin.class);
        System.out.println("___________________________________________________________\n\n" + firstObject);

        System.out.println("\n__________________________________________________________\n" + secondObject);
    }
}
