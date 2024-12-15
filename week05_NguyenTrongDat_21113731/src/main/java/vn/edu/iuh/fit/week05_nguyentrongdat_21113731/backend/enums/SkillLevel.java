package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.enums;

public enum SkillLevel {
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced"),
    MASTER("Master"),
    PROFESSIONAL("Professional");

    private String value;

    SkillLevel(String s) {
        this.value = s;
    }
}
