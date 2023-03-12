package lk.ijse.dep9.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO implements Serializable {
    @NotBlank(message = "Student NIC number cannot be empty or null")
    @Pattern(regexp = "^\\d{9}[Vv]$", message = "Invalid student nic number")
    private String nic;
    @NotBlank(message = "Student name cannot be empty or null")
    @Pattern(regexp = "^[A-Za-z][A-Za-z ]+$", message = "Invalid student name")
    private String name;
    @NotBlank(message = "Student address cannot be empty or null")
    @Pattern(regexp = "^[A-Za-z\\d][A-Za-z\\d-|/# ,.:;\\\\]+$", message = "Invalid student address")
    private String address;
    @NotBlank(message = "Student contact number cannot be empty or null")
    @Pattern(regexp = "^\\d{3}-\\d{7}$", message = "Invalid student contact number")
    private String contact;
}
