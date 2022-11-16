package lviv.iot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class Data {
    private Integer id;
    private Integer temperature;
    private Integer humidity;
    private Integer wind_speed;
    private Integer atmospheric_pressure;
    private Integer wind_direction;
    private Integer interval_of_updates_id;

}
