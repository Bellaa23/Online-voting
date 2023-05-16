package Spring.demo.Service;

import Spring.demo.Model.UserModel;
import Spring.demo.Model.VoteModel;

import java.util.List;

public interface VoterService {
    VoteModel createVoter(VoteModel voter);
    VoteModel updateVoter(VoteModel voter);
    void deleteVoter(VoteModel voter);
    List<VoteModel> voterList( String keyword);
    VoteModel getVoter(VoteModel voter);
    VoteModel findUserById(VoteModel voter);


}
