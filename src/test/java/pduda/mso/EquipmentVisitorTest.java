package pduda.mso;

import java.util.Map;
import pduda.mso.rolo.RoloUrlEquipmentVisitor;
import pduda.mso.web.WebAttributesEquipmentVisitor;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pduda.mso.dao.SpringJdbcDaoEquipmentVisitor;
import static org.mockito.Mockito.*;

public class EquipmentVisitorTest {

    private RoloUrlEquipmentVisitor roloUrlVisitor;
    private WebAttributesEquipmentVisitor webAttributesVisitor;
    private SpringJdbcDaoEquipmentVisitor springJdbcDaoVisitor;
    private EquipmentDao equipmentDao;

    @Before
    public void setUp() {
        this.equipmentDao = mock(EquipmentDao.class);

        roloUrlVisitor = new RoloUrlEquipmentVisitor();
        webAttributesVisitor = new WebAttributesEquipmentVisitor();
        springJdbcDaoVisitor = new SpringJdbcDaoEquipmentVisitor(equipmentDao);
    }

    @Test
    public void roloUrlVisitor_msoForExchange() {
        MajorServiceOutage msoForExchange = new MajorServiceOutage(1L, new Exchange(new ServiceType("FTTC")));
        
        msoForExchange.getEquipment().accept(roloUrlVisitor);

        assertEquals("http://rolo.com/exchange/FTTC", roloUrlVisitor.getUrl());
    }

    @Test
    public void roloUrlVisitor_msoForAccessNode() {
        MajorServiceOutage msoForAccessNode = new MajorServiceOutage(1L, new AccessNode());
        
        msoForAccessNode.getEquipment().accept(roloUrlVisitor);

        assertEquals("http://rolo.com/accessNode", roloUrlVisitor.getUrl());
    }

    @Test
    public void webAttributesVisitor_msoForExchange() {
        MajorServiceOutage msoForExchange = new MajorServiceOutage(1L, new Exchange(new ServiceType("FTTC")));
        
        msoForExchange.getEquipment().accept(webAttributesVisitor);
        
        Map<String, String> webAttributes = webAttributesVisitor.getWebAttributes();
        assertEquals("exchange", webAttributes.get("type"));
        assertEquals("FTTC", webAttributes.get("service type"));
    }

    @Test
    public void webAttributesVisitor_msoForAccessNode() {
        MajorServiceOutage msoForAccessNode = new MajorServiceOutage(1L, new AccessNode());
        
        msoForAccessNode.getEquipment().accept(webAttributesVisitor);
        
        Map<String, String> webAttributes = webAttributesVisitor.getWebAttributes();
        assertEquals("access node", webAttributes.get("type"));
    }

    @Test
    public void springJdbcDaoVisitor_msoForExchange() {
        Exchange exchange = new Exchange(new ServiceType("FTTC"));
        MajorServiceOutage msoForExchange = new MajorServiceOutage(1L, exchange);
        
        msoForExchange.getEquipment().accept(springJdbcDaoVisitor);

        verify(equipmentDao).persistExchange(exchange);
    }

    @Test
    public void springJdbcDaoVisitor_msoForAccessNode() {
        AccessNode accessNode = new AccessNode();
        MajorServiceOutage msoForAccessNode = new MajorServiceOutage(1L, accessNode);
        
        msoForAccessNode.getEquipment().accept(springJdbcDaoVisitor);
        
        verify(equipmentDao).persistAccessNode(accessNode);
    }
}