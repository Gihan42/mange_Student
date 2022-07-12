package tm;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentTableTm {
    private String SId;
    private String SName;
    private String eMail;
    private String contact;
    private String Address;
    private String nic;
}
