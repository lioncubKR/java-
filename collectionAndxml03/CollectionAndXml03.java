/**
 * DomによるXML出力
 *
 * @author 禹　相植
 */
package collectionAndxml03;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class CollectionAndXml03 {

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
        try {
            createXml(resultMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * XML作成用メソッド.
     *
     * @param inputMap　XML元データ.
     * @throws TransformerFactoryConfigurationError
     * @throws ParserConfigurationException
     * @throws TransformerException
     */
    private static void createXml(final Map<String, Set<String>> inputMap)
                                throws TransformerFactoryConfigurationError, TransformerException, ParserConfigurationException {

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element root = document.createElement("Root");
        Element flightInfo = document.createElement("flightInfo");

        for (Map.Entry<String, Set<String>> entry : inputMap.entrySet()) {
            Element item = document.createElement("item");
            Element company = document.createElement("company");
            Text txtCompany = document.createTextNode(entry.getKey());
            Element flights = document.createElement("flights");

            for (String str : entry.getValue()) {
                Element flightName = document.createElement("flightName");
                Text txtFlightName = document.createTextNode(str);
                flightName.appendChild(txtFlightName);
                flights.appendChild(flightName);
            }

            company.appendChild(txtCompany);
            item.appendChild(company);
            item.appendChild(flights);
            flightInfo.appendChild(item);
        }

        root.appendChild(flightInfo);
        document.appendChild(root);

        // XMLフォーマット処理
        String currentPath = System.getProperty("user.dir");
        String filePath = currentPath + File.separator + OUTPUT_PATH
                + File.separator + XML_FILE_NAME;

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
//        transformer.setOutputProperty(OutputKeys.STANDALONE, "no"); // 変更されない
        transformer.transform(new DOMSource(document),
                                            new StreamResult(new File(filePath)));

    }

}
