package lviv.iot.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class ServiceWork {
    private Integer id;
    private Date date;
    private String description;
}
