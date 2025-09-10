import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@SpringBootApplication
public class HealthApp {
    public static void main(String[] args) {
        SpringApplication.run(HealthApp.class, args);
    }
}

@Controller
class WebController {
    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "<form action='/bmi' method='post'>"
             + "Weight: <input name='weight'><br>"
             + "Height: <input name='height'><br>"
             + "<button type='submit'>Calculate BMI</button></form>";
    }

    @PostMapping("/bmi")
    @ResponseBody
    public String bmi(@RequestParam double weight, @RequestParam double height) {
        double h = height / 100.0;
        double bmi = Math.round(weight / (h * h) * 100.0) / 100.0;
        return "<h2>Your BMI is " + bmi + "</h2><a href='/'>Go Back</a>";
    }
}
