package codingdojo;

import org.approvaltests.Approvals;
import org.junit.Test;

import static codingdojo.SampleModelObjects.*;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public class XMLExporterTest {

    @Test
    public void export_no_orders() {
        String result = XMLExporter.exportFull(emptyList());

        Approvals.verifyXml(result);
    }

    @Test
    public void export_with_one_order() {
        String result = XMLExporter.exportFull(singletonList(RecentOrder));

        Approvals.verifyXml(result);
    }

    @Test
    public void export_with_one_order_containing_just_one_no_event_product() {
        Product noEventProduct = CherryBloom;
        Order order = new Order("anyId", Util.fromIsoDate("2018-09-01T00:00Z"), FlagshipStore, new Product[]{noEventProduct});
        String result = XMLExporter.exportFull(singletonList(order));

        Approvals.verifyXml(result);
    }


}
