package Spring.demo.Service.impl;

import Spring.demo.Model.VoteModel;
import Spring.demo.Repository.VoteRepository;
import Spring.demo.Service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterImplementation implements VoterService {
    @Autowired
    private VoteRepository voteRepo;
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public VoteModel createVoter(VoteModel voter) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("bellaisimbi23@gmail.com");
        message.setTo(voter.getEmail());
        message.setText("Thank you for voting !!");
        message.setSubject("Confirmation Email");

        mailSender.send(message);
        return voteRepo.save(voter);

    }

    @Override
    public VoteModel updateVoter(VoteModel voter) {
        VoteModel voters = findUserById((voter));
        if (voters!=null){
            voters.setId((voter.getId()));
            voters.setVoter_id(voter.getVoter_id());
            voters.setName(voter.getName());
            voters.setEmail(voter.getEmail());
            voters.setGender(voter.getGender());
            voters.setDate(voter.getDate());
            voters.setAddress(voter.getAddress());
            voters.setCandidates(voter.getCandidates());
            return voteRepo.save(voters);
        }else {
            return createVoter(voter);
        }
    }

    @Override
    public void deleteVoter(VoteModel voter) {
        voteRepo.deleteAll();
    }



    @Override
    public List<VoteModel> voterList(String keyword) {
        if(keyword !=null){
            return voteRepo.search(keyword);
        }
        return voteRepo.findAll();
    }

    @Override
    public VoteModel getVoter(VoteModel voter) {
//        return voteRepo.findUserById(voter.getVoter_id()).get();
        return voteRepo.findUserByEmail(voter.getEmail()).get();
    }

    @Override
    public VoteModel findUserById(VoteModel voter) {
        return voteRepo.findById(voter.getVoter_id()).get();
    }
}
