import exception.ResourceAllocationException;
import exception.ResourceException;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.jupiter.api.Test;
import soapApi.ResourceSoapApi;
import soapApi.ResourceSoapApiItf;
import soapModel.GetResourceSoap;
import soapModel.PostResourceSoap;
import soapModel.PutResourceSoap;

import java.net.MalformedURLException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class ResourceSoapIT {

    private final String url = "http://localhost:8080//ResourceApi?wsdl";

    @Test
    public void getTest() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(ResourceSoapApiItf.class);
        factory.setAddress(url);

        ResourceSoapApiItf service = (ResourceSoapApiItf) factory.create();

        List<GetResourceSoap> l = service.findAll();
        assertEquals(5, l.size());
    }

    @Test
    public void getByIdTest() throws ResourceException {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(ResourceSoapApiItf.class);
        factory.setAddress(url);
        ResourceSoapApiItf service = (ResourceSoapApiItf) factory.create();

        GetResourceSoap test = service.getById("71900926-0ab8-454f-abba-cf49a73ef503");
        assertEquals(123, test.getValueOfResource());
    }

    @Test
    public void addResourceTest(){
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(ResourceSoapApiItf.class);
        factory.setAddress(url);
        ResourceSoapApiItf service = (ResourceSoapApiItf) factory.create();

        service.addUResource(new PostResourceSoap(420));
        List<GetResourceSoap> l = service.findAll();
        assertEquals(420, l.get(l.size()-1).getValueOfResource());
    }

    @Test
    public void updateResourceTest() throws ResourceException {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(ResourceSoapApiItf.class);
        factory.setAddress(url);
        ResourceSoapApiItf service = (ResourceSoapApiItf) factory.create();

        service.update(new PutResourceSoap("71900926-0ab8-454f-abba-cf49a73ef503", 123));
        GetResourceSoap test = service.getById("71900926-0ab8-454f-abba-cf49a73ef503");
        assertEquals(123, test.getValueOfResource());
    }

    @Test
    public void deleteResourceTest() throws ResourceException {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(ResourceSoapApiItf.class);
        factory.setAddress(url);
        ResourceSoapApiItf service = (ResourceSoapApiItf) factory.create();

        service.addUResource(new PostResourceSoap(997));
        List<GetResourceSoap> l = service.findAll();

        service.delete(l.get(l.size()-1).getId());

        l = service.findAll();

        assertNotEquals(997, l.get(l.size()-1).getValueOfResource());
    }
}
