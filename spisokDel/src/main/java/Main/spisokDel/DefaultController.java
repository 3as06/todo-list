package Main.spisokDel;

import Main.spisokDel.repository.model.Purpose;
import Main.spisokDel.service.PurposeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class DefaultController {

    private final PurposeServiceImpl purposeServiceImpl;

   // @Value("${someParameter.value}")
    //private Integer someParameter;

    public DefaultController(PurposeServiceImpl purposeServiceImpl) {
        this.purposeServiceImpl = purposeServiceImpl;
    }

    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Purpose> purposeIterable = purposeServiceImpl.getAll();
        ArrayList<Purpose> purposes = new ArrayList<>();

        for (Purpose purpose : purposeIterable) {
            purposes.add(purpose);
        }

        model.addAttribute("purposes", purposes)
                .addAttribute("purposesCount", purposes.size());
                //.addAttribute("someParameter", someParameter);

        return "index";
    }
}
