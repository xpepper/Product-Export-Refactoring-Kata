package codingdojo;

import org.approvaltests.Approvals;
import org.junit.Test;

import static java.util.Collections.emptyList;

public class XMLExporterTest {

    @Test
    public void export_no_orders() {
        String result = XMLExporter.exportFull(emptyList());
        Approvals.verify(result);
    }

}
