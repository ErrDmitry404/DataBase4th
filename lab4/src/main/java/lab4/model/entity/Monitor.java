package lab4.model.entity;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Monitor {


    private Integer id;
    private String monitorsResolution;
    private String model;

    public Monitor(Integer id, String monitorsResolution, String model) {
        this.id = id;
        this.monitorsResolution = monitorsResolution;
        this.model = model;
    }

    public Monitor(String monitorsResolution, String model) {
        this(-1, monitorsResolution, model);
    }
}
