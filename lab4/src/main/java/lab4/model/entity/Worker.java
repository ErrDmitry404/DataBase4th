package lab4.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Worker {


    private Integer id;
    private String fullName;
    private Integer amount;
    private Integer irPhonesId;

    public Worker(Integer id, String fullName, Integer amount, Integer irPhonesId) {
        this.id = id;
        this.fullName = fullName;
        this.amount = amount;
        this.irPhonesId = irPhonesId;
    }

    public Worker(String fullName, Integer amount, Integer irPhonesId) {
        this(-1, fullName, amount, irPhonesId);
    }
}
