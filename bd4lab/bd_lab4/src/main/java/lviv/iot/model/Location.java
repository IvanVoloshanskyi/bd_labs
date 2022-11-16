package lviv.iot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class Location {
    private Integer id;
    private String city;
    private Integer adress_id;
    private Integer gps_id;


}
