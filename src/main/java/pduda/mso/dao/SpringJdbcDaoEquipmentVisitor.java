package pduda.mso.dao;

import java.util.Map;
import pduda.mso.web.*;
import pduda.mso.AccessNode;
import pduda.mso.EquipmentDao;
import pduda.mso.EquipmentVisitor;
import pduda.mso.Exchange;

public class SpringJdbcDaoEquipmentVisitor implements EquipmentVisitor {
    private final EquipmentDao equipmentDao;

    public SpringJdbcDaoEquipmentVisitor(EquipmentDao equipmentDao) {
        this.equipmentDao = equipmentDao;
    }
    
    public void visit(Exchange exchange) {
        equipmentDao.persistExchange(exchange);
    }

    public void visit(AccessNode accessNode) {
        equipmentDao.persistAccessNode(accessNode);
    }
    
}
