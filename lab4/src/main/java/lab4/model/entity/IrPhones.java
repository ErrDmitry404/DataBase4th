package lab4.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class IrPhones {


    private Integer id;
    private String phoneTypes;
    private String phoneModel;

    public IrPhones(Integer id, String phoneTypes, String phoneModel) {
        this.id = id;
        this.phoneTypes = phoneTypes;
        this.phoneModel = phoneModel;
    }

    public IrPhones(String phoneTypes, String phoneModel) {
        this(-1, phoneTypes, phoneModel);
    }
}
