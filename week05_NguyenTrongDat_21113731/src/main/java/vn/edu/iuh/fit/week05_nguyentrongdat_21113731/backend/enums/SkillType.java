package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.enums;

public enum SkillType {
    SOFT_SKILL("Soft Skill"),
    TECHNICAL_SKILL("Technical Skill"),
    UNSPECIFIC("Unspecific");
    private String value;
    SkillType(String s) {
        this.value = s;
    }
}
