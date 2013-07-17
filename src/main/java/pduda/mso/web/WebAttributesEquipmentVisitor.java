package pduda.mso.web;

import java.util.HashMap;
import java.util.Map;
import pduda.mso.AccessNode;
import pduda.mso.EquipmentVisitor;
import pduda.mso.Exchange;

public class WebAttributesEquipmentVisitor implements EquipmentVisitor {

    private Map<String, String> attibutes = new HashMap<String, String>();

    public Map<String, String> getWebAttributes() {
        return this.attibutes;
    }

    public void visit(Exchange exchange) {
        this.attibutes.put("type", "exchange");
        this.attibutes.put("service type", exchange.getAffectedServiceType().getValue());
    }

    public void visit(AccessNode accesNode) {
        this.attibutes.put("type", "access node");
    }
}
