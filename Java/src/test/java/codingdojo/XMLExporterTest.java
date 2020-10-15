package codingdojo;

import org.approvaltests.Approvals;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static codingdojo.SampleModelObjects.*;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public class XMLExporterTest {

    public static final Date HISTORY_DATE = Util.fromIsoDate("2017-09-01T00:00Z");

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

    @Test
    public void export_tax_details_no_orders() {
        String result = XMLExporter.exportTaxDetails(emptyList());

        Approvals.verifyXml(result);
    }

    @Test
    public void export_tax_details_with_one_order() {
        String result = XMLExporter.exportTaxDetails(singletonList(RecentOrder));

        Approvals.verifyXml(result);
    }

    @Test
    public void export_tax_details_with_one_order_containing_just_one_no_event_product() {
        Product noEventProduct = CherryBloom;
        Order order = new Order("anyId", Util.fromIsoDate("2018-09-01T00:00Z"), FlagshipStore, new Product[]{noEventProduct});
        String result = XMLExporter.exportTaxDetails(singletonList(order));

        Approvals.verifyXml(result);
    }

    @Test
    public void export_tax_details_with_one_order_created_before_2018() {
        Product noEventProduct = CherryBloom;
        Order order = new Order("anyId", Util.fromIsoDate("2017-09-01T00:00Z"), FlagshipStore, new Product[]{noEventProduct});
        String result = XMLExporter.exportTaxDetails(singletonList(order));

        Approvals.verifyXml(result);
    }

    @Test
    public void export_store() {
        String xmlStore = XMLExporter.exportStore(FlagshipStore);

        Approvals.verifyXml(xmlStore);
    }

    @Test
    public void export_history_no_orders() {
        String result = XMLExporter.exportHistory(emptyList(), HISTORY_DATE);

        Approvals.verifyXml(result);
    }

    @Test
    public void export_history_with_one_order() {
        List<Order> orders = singletonList(RecentOrder);
        String result = XMLExporter.exportHistory(orders, HISTORY_DATE);

        Approvals.verifyXml(result);
    }
}
