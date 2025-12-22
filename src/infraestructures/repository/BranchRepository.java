package infraestructures.repository;

import application.domain.entities.Branch;

import java.util.ArrayList;
import java.util.List;

public class BranchRepository {
    private final List<Branch> branches = new ArrayList<>();

    public void save(Branch branch) {
        branches.add(branch);
    }

    public void delete(Branch branch) {
        branches.remove(branch);
    }

    public Branch findByName(String name) {
        return branches.stream().filter(branch -> branch.getName().equals(name)).findFirst().orElse(null);
    }

    public Branch findById(Long id) {
        return branches.stream().filter(branch -> branch.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Branch> findAll() {
        return branches;
    }
}
