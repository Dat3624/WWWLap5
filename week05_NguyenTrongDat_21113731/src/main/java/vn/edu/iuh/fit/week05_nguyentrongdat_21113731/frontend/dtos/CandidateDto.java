package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.frontend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.Skill;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class CandidateDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String about;
    private String webUrl;
    private List<Skill> skills;
    private String skillString;
    public CandidateDto() {
    }

    @Override
    public String toString() {
        return "CandidateDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", about='" + about + '\'' +
                ", webUrl='" + webUrl + '\'' +
                ", skills=" + skills +
                '}';
    }
}
