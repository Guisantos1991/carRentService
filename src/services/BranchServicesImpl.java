package services;

import application.domain.entities.Branch;
import infraestructures.repository.BranchRepository;
import services.docs.BranchService;
import java.util.List;

public class BranchServicesImpl implements BranchService {

    private final BranchRepository branchRepository;

    public BranchServicesImpl() {
        this.branchRepository = new BranchRepository();
    }

    @Override
    public void createBranch(Branch branch) {
        branchRepository.save(branch);
    }

    @Override
    public void updateBranch(String name) {
        Branch updatedBranch = branchRepository.findByName(name);
        System.out.println("\n===== Atualizar Filial =====");
        System.out.print("Digite o novo nome da filial: ");
        String newName = System.console().readLine();
        updatedBranch.setName(newName);
        System.out.print("Digite o novo CEP da filial: ");
        String newCode = System.console().readLine();
        updatedBranch.setCode(newCode);
        System.out.print("Digite o novo endereço da filial: ");
        String newAddress = System.console().readLine();
        updatedBranch.setAddress(newAddress);
        System.out.print("\nFilial atualizada com sucesso para: " + updatedBranch.getName());
    }

    @Override
    public void deleteBranch(long id) {
        Branch toDelete = branchRepository.findById(id);
        branchRepository.delete(toDelete);
        System.out.print("Filial " + toDelete.getName() + " deletada com sucesso.");
    }

    @Override
    public List<Branch> getBranches() {
        return branchRepository.findAll();
    }
}
