package soapModel;

import entity.resources.Resource;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@Setter
@Getter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "putResourceSoap", propOrder = {
        "id",
        "valueOfResource"
})
public class PutResourceSoap {

    String id;
    int valueOfResource;

    public PutResourceSoap(String id, int valueOfResource) {
        this.id = id;
        this.valueOfResource = valueOfResource;
    }

    public PutResourceSoap(Resource res) {
        this.id = res.getId().toString();
        this.valueOfResource = res.getValueOfResource();
    }
}
