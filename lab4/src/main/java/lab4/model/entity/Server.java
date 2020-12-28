package lab4.model.entity;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Server {


    private Integer id;
    private String onlineNow;
    private Integer monitorsId;

    public Server(Integer id, String onlineNow, Integer monitorsId) {
        this.id = id;
        this.onlineNow = onlineNow;
        this.monitorsId = monitorsId;
    }

    public Server(String onlineNow, Integer monitorsId) {
        this(-1, onlineNow, monitorsId);
    }
}
