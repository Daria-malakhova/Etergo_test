package Utilities;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class RunConfiguration {


    public DocumentBuilder dBuilder;
    public Long strImplicitWaitTimeout;
    public String strOSName;
    public String strPlatformVersion;
    public String strPlatformName;
    public String strDeviceName;
    public String strUDID;
    public String strApp;
    public String strAppActivity;
    public String strPackageName;
    public String strFullReset;
    public String strOrientation;
    public String strReportTemplate;
    public RunConfiguration() {

        try {

            String path = System.getProperty("user.dir");
            File readXML = new File(path + "/GlobalConfig.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(readXML);

            // Fetching Desired Capabilities Values using Tagname from GlobalConfig

            strOSName = doc.getElementsByTagName("OSNAME").item(0).getTextContent();
            strPlatformName = doc.getElementsByTagName("Platform").item(0).getTextContent();

            if (strPlatformName.equalsIgnoreCase("Android")) {
                NodeList nList = doc.getElementsByTagName(strPlatformName);

                for (int temp = 0; temp < nList.getLength(); temp++) {

                    Node nNode = nList.item(temp);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode;
                        strPlatformVersion = eElement.getElementsByTagName("PlatformVersion").item(0).getTextContent();
                        strDeviceName = eElement.getElementsByTagName("DeviceName").item(0).getTextContent();
                        strUDID = eElement.getElementsByTagName("UDID").item(0).getTextContent();
                        strApp=eElement.getElementsByTagName("App").item(0).getTextContent();
                        strAppActivity = eElement.getElementsByTagName("AppActivity").item(0).getTextContent();
                        strPackageName = eElement.getElementsByTagName("PackageName").item(0).getTextContent();
                        strOrientation = eElement.getElementsByTagName("Orientation").item(0).getTextContent();
                        strFullReset = eElement.getElementsByTagName("FullReset").item(0).getTextContent();
                    }
                }
            } else if (strPlatformName.equalsIgnoreCase("iOS")) {
                NodeList nList = doc.getElementsByTagName(strPlatformName);

                for (int temp = 0; temp < nList.getLength(); temp++) {

                    Node nNode = nList.item(temp);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode;
                        strPlatformVersion = eElement.getElementsByTagName("PlatformVersion").item(0).getTextContent();
                        strDeviceName = eElement.getElementsByTagName("DeviceName").item(0).getTextContent();
                        strUDID = eElement.getElementsByTagName("UDID").item(0).getTextContent();
                        strApp=eElement.getElementsByTagName("App").item(0).getTextContent();
                        strAppActivity = eElement.getElementsByTagName("AppActivity").item(0).getTextContent();
                        strPackageName = eElement.getElementsByTagName("PackageName").item(0).getTextContent();
                        strOrientation = eElement.getElementsByTagName("Orientation").item(0).getTextContent();
                        strFullReset = eElement.getElementsByTagName("FullReset").item(0).getTextContent();
                    }
                }
            } else {
                System.out.println("Please specify the correct platform to run the Test");
            }

            strImplicitWaitTimeout = Long.parseLong(doc.getElementsByTagName("ImplicitWait").item(0).getTextContent());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
