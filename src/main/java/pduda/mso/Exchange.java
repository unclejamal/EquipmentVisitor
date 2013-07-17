package pduda.mso;

public class Exchange implements Equipment {
    private final ServiceType affectedServiceType;

    public Exchange(ServiceType affectedServiceType) {
        this.affectedServiceType = affectedServiceType;
    }
    
    public ServiceType getAffectedServiceType() {
        return affectedServiceType;
    }
    
    public void accept(EquipmentVisitor visitor) {
        visitor.visit(this);
    }
}
