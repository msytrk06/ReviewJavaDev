package cybertek.lambda.sorting;

import com.cybertek.oop.encapsulation.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    private Integer employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeCity;
    private Role role;

}
