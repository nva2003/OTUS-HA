package ha.otus.simple.social.network.constants;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    UNKNOWN("It");

    private final String gender;

    Gender(String sex) {
        gender = sex;
    }

    public static Gender getGenderById(Integer id) {
        if (id == null)
            return UNKNOWN;

        switch (id) {
            case 1:
                return MALE;
            case 2:
                return FEMALE;
            default:
                return UNKNOWN;
        }
    }

    public static String getGenderByName(String name) {
        if (name == null)
            return UNKNOWN.gender;

        switch (name) {
            case "Male":
                return MALE.gender;
            case "Female":
                return FEMALE.gender;
            default:
                return UNKNOWN.gender;
        }
    }

    public String getDisplayValue() {
        return gender;
    }
}
