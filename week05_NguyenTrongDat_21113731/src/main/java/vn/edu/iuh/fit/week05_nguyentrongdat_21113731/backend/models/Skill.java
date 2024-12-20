package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.enums.SkillType;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @Column(name = "skill_id", nullable = false)
    private Long id;

    @Column(name = "skill_description")
    private String skillDescription;

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private SkillType type;

}