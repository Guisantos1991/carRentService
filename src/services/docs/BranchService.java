package services.docs;

import application.domain.entities.Branch;

import java.util.List;


public interface BranchService {
    void createBranch(Branch branch);
    void updateBranch(String name);
    void deleteBranch(long id);
    List<Branch> getBranches();
}
