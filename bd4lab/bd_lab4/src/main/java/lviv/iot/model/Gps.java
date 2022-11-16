package lviv.iot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class Gps {
    private Integer id;
    private String latitude;
    private String longtitude;

}
