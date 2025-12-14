package infraestructures.repository;

import application.domain.entities.Branch;

import java.util.ArrayList;
import java.util.List;

public class BranchRepository {
    private List<Branch> branches = new ArrayList<>();

    public void save(Branch branch) {
        branches.add(branch);
    }

    public Branch findByName(String name) {
        return branches.stream().filter(branch -> branch.getName().equals(name)).findFirst().orElse(null);
    }

    public List<Branch> findAll() {
        return branches;
    }
}
