package NewYearRes.Web;

import NewYearRes.Goal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goal")
public class GoalController {
    @GetMapping
    public String showGoalForm() {
        return "goal";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        List<Goal> goals = createGoalList();
        Type[] types = Goal.Type.values();
        for (Type type: types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(goals, type));
        }
    }

    private List<Goal> filterByType(List<Goal> goals, Type type) {
        return goals
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    private List<Goal>createGoalList() {
        List<Goal> goals = Arrays.asList {
            new Goal(id: "EXEC", name: "Exercise", Type.HEALTH),
            new Goal(id: "DIET", name: "Diet", Type.HEALTH),
            new Goal(id: "MEDI", name: "Meditate", Type.HEALTH),
            new Goal(id: "STDY", name: "Study", Type.EDUCATION),
            new Goal(id: "ARRV", name: "Arrive On Time", Type.CAREER),
            new Goal(id: "OVRT", name: "Overtime", Type.CAREER),
            new Goal(id: "STFY", name: "Spend More Time With Family", Type.SOCIAL),
            new Goal(id: "STFD", name: "Spend More Time With Friends", Type.SOCIAL),
            new Goal(id: "INSM", name: "Play New Instrument", Type.HOBBY),
            new Goal(id: "LANG", name: "Learn New Language", Type.HOBBY),

        }
        return goals;

    }
}
