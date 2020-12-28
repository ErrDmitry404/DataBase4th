package lab4.model.entity;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ITCompany {


    private Integer id;
    private String companyConfiguration;
    private String typeOfDevices;
    private Integer serverId;
    private Integer workersId;

    public ITCompany(Integer id, String companyConfiguration, String typeOfDevices, Integer serverId, Integer workersId) {
        this.id = id;
        this.companyConfiguration = companyConfiguration;
        this.typeOfDevices = typeOfDevices;
        this.serverId = serverId;
        this.workersId = workersId;
    }

    public ITCompany(String companyConfiguration, String typeOfDevices, Integer serverId, Integer workersId) {
        this(-1, companyConfiguration, typeOfDevices, serverId, workersId);
    }
}
