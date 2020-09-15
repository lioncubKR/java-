/**
 * JAXP(StAX中心)によるXML出力
 *
 * @author 禹　相植
 */
package collectionAndxml02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class CollectionAndXml02 {

    private final static String OUTPUT_PATH = "src/output";
    private final static String XML_FILE_NAME = "FlightList_woosangsik.xml";

    public static void main(String[] args) {
        List<String> companyList = Arrays.asList("KAL", "JAL", "ANA"); // 航空会社リスト
        List<String> flightList = Arrays.asList("KAL12", "KAL02", "KAL12", "JAL23", "ANA13", "KAL05",
                "JAL01", "ANA03", "JAL23", "JAL05", "ANA03", "ANA25"); // 航空便名リスト

        // 航空会社別航空便名リスト情報を格納するCollection.(重複不可、自動ソートのため、TreeMapを使用)
        Map<String, Set<String>> resultMap = new TreeMap<>();

        // Collectionへの格納処理
        for (String company : companyList) {
            // 航空便名リストのソート(昇順)と重複を除くため、TreeSetを使用。
            Set<String> flightSet = new TreeSet<>();

            for (String flight : flightList) {
                if (flight.contains(company)) {
                    flightSet.add(flight);
                }
            }

            resultMap.put(company, flightSet);
        }

        // 格納情報の標準出力
        System.out.println(resultMap);

        // xmlファイルの出力
        createXml(resultMap);

    }

    /**
     * XML作成用メソッド.
     *
     * @param inputMap　XML元データ.
     */
    private static void createXml(final Map<String, Set<String>> inputMap) {
        XMLOutputFactory xmlFactory = null;
        XMLStreamWriter xmlWriter = null;

        try{
            String currentPath = System.getProperty("user.dir");
            String filePath = currentPath + File.separator + OUTPUT_PATH
                    + File.separator + XML_FILE_NAME;

            xmlFactory = XMLOutputFactory.newFactory();
//            xmlFactory.setProperty("escapeCharacters", true); // defaultでtrueになっている。（& < > エスケープ）
            xmlWriter = xmlFactory.createXMLStreamWriter(new FileWriter(filePath));

            xmlWriter.writeStartDocument("UTF-8", "1.0");
            xmlWriter.writeStartElement("Root");
            xmlWriter.writeStartElement("flightInfo");

            for (Map.Entry<String, Set<String>> entry : inputMap.entrySet()) {
                xmlWriter.writeStartElement("item");

                xmlWriter.writeStartElement("company");
                xmlWriter.writeCharacters(entry.getKey());
                xmlWriter.writeEndElement();

                xmlWriter.writeStartElement("flights");

                for (String str : entry.getValue()) {
                    xmlWriter.writeStartElement("flightName");
                    xmlWriter.writeCharacters(str);
                    xmlWriter.writeEndElement();
                }

                xmlWriter.writeEndElement();
                xmlWriter.writeEndElement();
            }

            xmlWriter.writeEndElement();
            xmlWriter.writeEndElement();
            xmlWriter.writeEndDocument();

            xmlWriter.flush();
            xmlWriter.close();

            // XMLフォーマット処理
            formattingForXmlFile(filePath);

        } catch (Exception e){
                e.printStackTrace();
        } finally{
            try{
                if (xmlWriter != null){
                    xmlWriter.close();
                }
            } catch (Exception e){
                    e.printStackTrace();
            }
        }
    }

    /**
     * XMLフォーマット処理を行う.
     *
     * @param fileFullPath XMLファイルのフルパス
     * @throws ParserConfigurationException
     * @throws FileNotFoundException
     * @throws SAXException
     * @throws IOException
     * @throws TransformerFactoryConfigurationError
     * @throws TransformerException
     */
    private static void formattingForXmlFile(String fileFullPath)
            throws ParserConfigurationException, FileNotFoundException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException {

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document =
                builder.parse(new InputSource(new InputStreamReader(new FileInputStream(fileFullPath))));

       Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
//        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes"); // 変更されない
        transformer.transform(new DOMSource(document),
                                            new StreamResult(new File(fileFullPath)));
    }

}
