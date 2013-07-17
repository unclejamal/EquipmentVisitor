package pduda.mso;

public class MajorServiceOutage {
    private final long id;
    private final Equipment equipment;
    
    public MajorServiceOutage(long id, Equipment equipment) {
        this.id = id;
        this.equipment = equipment;
    }

    public Equipment getEquipment() {
        return equipment;
    }
    
    public long getId() {
        return id;
    }

}
