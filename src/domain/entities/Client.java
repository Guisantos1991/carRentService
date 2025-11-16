package domain.entities;

import domain.enums.ClientStatus;

public class Client {
    private Integer id;
    private String name;
    private String cpf;
    private String email;
    private String phone;
    private ClientStatus status;

    public ClientStatus getStatus() {
        return status;
    }

    public void setStatus(ClientStatus status) {
        this.status = status;
    }

    public Client(Integer id, String name, String cpf, String email, String phone, ClientStatus status) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void activate(ClientStatus status) {
        this.status = ClientStatus.ACTIVE;

    }

    public void upDateClient(String name, String cpf, String email, String phone) {
        if(name.equalsIgnoreCase(this.name) && cpf.equalsIgnoreCase(this.cpf) && email.equalsIgnoreCase(this.email) && phone.equalsIgnoreCase(this.phone)) {
            System.out.println("Não houve alterações nos dados do cliente.");
        } else  {
            this.name = name;
            this.cpf = cpf;
            this.email = email;
            this.phone = phone;
            System.out.println("Dados do cliente atualizados com sucesso.");
        }
    }
}
