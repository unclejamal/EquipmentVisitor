package pduda.mso.rolo;

import pduda.mso.AccessNode;
import pduda.mso.EquipmentVisitor;
import pduda.mso.Exchange;

public class RoloUrlEquipmentVisitor implements EquipmentVisitor {
    private String url;

    public String getUrl() {
        return url;
    }

    public void visit(Exchange exchange) {
        this.url = "http://rolo.com/exchange/" + exchange.getAffectedServiceType().getValue();
    }

    public void visit(AccessNode accesNode) {
        this.url = "http://rolo.com/accessNode";
    }

}
