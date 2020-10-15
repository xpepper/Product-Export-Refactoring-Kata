package codingdojo;

import org.approvaltests.Approvals;
import org.junit.Test;

import static codingdojo.SampleModelObjects.RecentOrder;
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
}
