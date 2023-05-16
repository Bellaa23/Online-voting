package Spring.demo.Controller;

import Spring.demo.Model.VoteModel;
import Spring.demo.Repository.VoteRepository;
import Spring.demo.Service.impl.VoterImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.Optional;


@Controller
public class VoterController {
 @Autowired
 private VoteRepository voteRepo;
    private final VoterImplementation voterImplementation;

    public VoterController(VoterImplementation voterImplementation) {
        this.voterImplementation = voterImplementation;
    }


    @GetMapping("/vote")
    public String VotingPage (Model model){
        model.addAttribute("requestVoting", new VoteModel());
        return "voting_page";
    }

    @GetMapping("/voters")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public String voterList(Model model, @Param("keyword") String keyword, Authentication authentication){
        List<VoteModel> ListOfVoters = voterImplementation.voterList(keyword);
        model.addAttribute("ListOfVoters",ListOfVoters);

        return "display";
    }

    @GetMapping("/personal")
    public String personalPage (Model model){
        model.addAttribute("requestPersonal", new VoteModel());
        return "personal_page";
    }

    @PostMapping("/voting")
    public String voting(@ModelAttribute VoteModel voteModel){
        System.out.println("request voting: " + voteModel);
        VoteModel registerVoter=voterImplementation.createVoter(voteModel);
        return registerVoter == null ? "voting_page" : "redirect:/personal";
    }



    @GetMapping("/UpdateVoter/{id}")
    public String UpdateVoter(@PathVariable("id") Integer id, Model model){
        Optional<VoteModel> vots = voteRepo.findUserById(id);
        VoteModel vote = vots.get();
        model.addAttribute("vote", vote);

        return"Edit";
    }


    @GetMapping("DeleteVoter/{id}")
    public String deleteVoter(@PathVariable("id") Integer id){
        voteRepo.deleteById(id);

        return"redirect:/voters";
    }

}
