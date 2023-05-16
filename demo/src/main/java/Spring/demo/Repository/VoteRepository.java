package Spring.demo.Repository;

import Spring.demo.Model.VoteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<VoteModel,Integer> {
    Optional<VoteModel> findUserByEmail(String email);
    Optional<VoteModel> findUserById(Integer id);
    @Query("SELECT p FROM VoteModel p WHERE CONCAT(p.id,' ',p.Voter_id,' ',p.Name,' ',p.email,' ',p.gender,' ',p.date,' ',p.address,' ',p.candidates) LIKE %?1%")
    public List<VoteModel>search(String keyword);

}

