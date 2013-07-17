package pduda.mso;

public class AccessNode implements Equipment {

    public void accept(EquipmentVisitor visitor) {
        visitor.visit(this);
    }
    

}
