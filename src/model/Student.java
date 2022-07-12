package model;

import lombok.*;

@Data
@Getter
@Setter
@ToString

@NoArgsConstructor
public class Student {
    private String SId;
    private String SName;
    private String eMail;
    private String contact;
    private String Address;
    private String Nic;

    public Student(String SId, String SName, String eMail, String contact, String address, String nic) {
        this.SId = SId;
        this.SName = SName;
        this.eMail = eMail;
        this.contact = contact;
        Address = address;
        Nic = nic;
    }
}
