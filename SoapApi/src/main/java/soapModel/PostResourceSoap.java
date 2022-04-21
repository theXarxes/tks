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
@XmlType(name = "postResourceSoap", propOrder = {
        "valueOfResource"
})
public class PostResourceSoap {

    int valueOfResource;

    public PostResourceSoap(Resource res) {
        this.valueOfResource = res.getValueOfResource();
    }
}
