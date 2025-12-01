# Car Rental Service – Study Project

Sistema de locação de veículos em **Java puro**, focado em estudo de **modelagem OO**, **camadas de serviço/repositório** e **regras de negócio** típicas de uma locadora.

> Projeto de console (CLI), pensado para ser simples de rodar e fácil de evoluir: adicionar novos casos de uso, telas de menu e regras de negócio.

---

## 🧱 Visão Geral

O sistema simula o fluxo básico de uma locadora:

- Cadastro e manutenção de **clientes**  
- Cadastro e manutenção de **veículos**  
- Criação e gestão de **reservas**  
- Abertura e fechamento de **contratos de locação**  
- Registro e estorno de **pagamentos**

Camadas principais:

```mermaid
graph TD
  CLI[CLI Controllers] --> Services
  Services --> Repositories
  Services --> Domain
  Repositories --> Domain
