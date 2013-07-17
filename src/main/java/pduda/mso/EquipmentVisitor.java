package pduda.mso;

public interface EquipmentVisitor {

    void visit(Exchange exchange);

    void visit(AccessNode accesNode);

}
