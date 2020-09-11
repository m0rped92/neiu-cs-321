package NewYearRes;

import lombok.Data;

@Data
public class Goal {
    private final String id;
    private final String name;
    private final Type type;

    public static enum type {
        HEALTH, SOCIAL, CAREER, EDUCATION, HOBBY
    }
}
