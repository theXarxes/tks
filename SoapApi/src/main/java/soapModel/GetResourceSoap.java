package soapModel;

import entity.resources.Resource;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getResourceSoap", propOrder = {
        "id",
        "isAllocated",
        "valueOfResource"
})
public class GetResourceSoap {

    String id;
    boolean isAllocated;
    int valueOfResource;

    public GetResourceSoap(Resource res) {
        this.id = res.getId().toString();
        this.isAllocated = res.isAllocated();
        this.valueOfResource = res.getValueOfResource();
    }
}
