/**
 * JAXBによるXML出力
 *
 * @author 禹　相植
 */
package sort;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class CollectionAndXml01 {

    private final static String OUTPUT_PATH = "output";
    private final static String XML_FILE_NAME = "FlightList_woosangsik.xml";

    public static void main(String[] args) {
        List<String> companyList = Arrays.asList("KAL", "JAL", "ANA"); // 航空会社リスト
        List<String> flightList = Arrays.asList("KAL12", "KAL02", "KAL12", "JAL23", "ANA13", "KAL05",
                "JAL01", "ANA03", "JAL23", "JAL05", "ANA03", "ANA25"); // 航空便名リスト

        // 航空会社別航空便名リスト情報を格納するCollection.(入れた順で保持させるためにLinkedHashMap使用)
        LinkedHashMap<String, Flights> resultMap = new LinkedHashMap<>();

        // 航空会社のソート(昇順)
        Collections.sort(companyList);

        // Collectionへの格納処理
        for (String company : companyList) {
            // 航空便名リストのソート(昇順)と重複を除くため、TreeSetを使用。
            Set<String> flightSet = new TreeSet<>();

            for (String flight : flightList) {
                if (flight.contains(company)) {
                    flightSet.add(flight);
                }
            }

            Flights flights = new Flights();
            flights.setFlightName(flightSet);
            resultMap.put(company, flights);
        }

        // 格納情報の標準出力
        System.out.println(resultMap);

        // xmlファイルの出力
        try {
            Companies companies = new Companies();
            companies.setFlightInfo(resultMap);
            marshal(companies); // javax.xml.bind.JAXB利用
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * XML作成用メソッド.
     *
     * @param objectName XML元データ
     * @throws JAXBException 例外
     */
    private static void marshal(Object objectName) throws JAXBException {
        String currentPath = System.getProperty("user.dir");
        String filePath = currentPath + File.separator + OUTPUT_PATH
                + File.separator + XML_FILE_NAME;
        File file = new File(filePath);

        JAXBContext jaxbContext = JAXBContext.newInstance(objectName.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        // XMLフォーマット処理
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // standaloneが制御できないため、一旦、XMLヘッダーを表示させない。
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        // XMLヘッダーを固定値で表示させる。
        marshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders",
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");

        marshaller.marshal(objectName, file);
    }

}
