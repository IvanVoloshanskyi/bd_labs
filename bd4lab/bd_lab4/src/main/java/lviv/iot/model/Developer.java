package lviv.iot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class Developer {
    private Integer id;
    private String name;
    private String surname;
    private String telephone_num;


}
