package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.frontend.dtos;

import lombok.*;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.Company;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.JobSkill;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.Skill;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JobDto implements Serializable {
    Long id;
    String jobDesc;
    String jobName;
    List<Skill> Skills;
    String skillString;
    Company company;

}