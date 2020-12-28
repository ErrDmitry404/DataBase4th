package lab4.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Computer {


    private Integer id;
    private Integer amount;
    private String manufacturer;
    private Integer monitorsId;

    public Computer(Integer id, Integer amount, String manufacturer, Integer monitorsId) {
        this.id = id;
        this.amount = amount;
        this.manufacturer = manufacturer;
        this.monitorsId = monitorsId;
    }

    public Computer(Integer amount, String manufacturer, Integer monitorsId) {
        this(-1, amount, manufacturer, monitorsId);
    }
}
