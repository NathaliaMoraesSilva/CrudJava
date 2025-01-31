package br.com;

import br.com.enteties.Cargo;
import br.com.enteties.Endereco;
import br.com.enteties.Pessoa;
import br.com.enteties.Salario;
import br.com.service.PessoaService;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Bem Vindo a ADM");
        Scanner sc = new Scanner(System.in);
        PessoaService pessoaService = new PessoaService();
    while (true) {
        System.out.println("\nOPÇÕES");
        System.out.println("1 - ADICIONAR EMPREGADO");
        System.out.println("2 - DELETAR EMPREGADO");
        System.out.println("3 - ATUALIZAR EMPREGADO");
        System.out.println("4 - BUSCAR EMPREGADO");
        System.out.println("5 - SAIR");

        String opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    Pessoa empregado = new Pessoa();

                    System.out.println("Digite o nome do empregado:");
                    empregado.setNome(sc.next());

                    System.out.println("--------------------------------------------------");

                    System.out.println("Digite o Endereço:");
                    System.out.println("Rua:");
                    String rua = sc.next();
                    System.out.println("CEP:");
                    String cep = sc.next();
                    System.out.println("Número:");
                    String numero = sc.next();
                    Endereco endereco = new Endereco(rua, cep, numero, empregado);
                    empregado.setEndereco(endereco);

                    System.out.println("--------------------------------------------------");

                    System.out.println("Cargo:");
                    System.out.println("Nome do Cargo:");
                    String cargoNome = sc.next();
                    System.out.println("Data Início (AAAA-MM-DD):");
                    LocalDate dataInicio = LocalDate.parse(sc.next());
                    System.out.println("Data Fim (AAAA-MM-DD) (ou pressione Enter para indefinido):");
                    String dataFimInput = sc.next();
                    LocalDate dataFim = dataFimInput.isEmpty() ? null : LocalDate.parse(dataFimInput);

                    System.out.println("Digite o Salário:");
                    double salarioValor = sc.nextDouble();

                    Salario salario = new Salario(salarioValor);
                    Cargo cargo = new Cargo(cargoNome, dataInicio, dataFim, empregado);

                    endereco.setPessoa(empregado);
                    cargo.setPessoa(empregado);
                    salario.setPessoa(empregado);

                    empregado.setEndereco(endereco);
                    empregado.setCargo(cargo);
                    empregado.setSalario(salario);

                    pessoaService.salvar(empregado);
                    System.out.println("Empregado cadastrado com sucesso!");
                    break;

                case "2":
                    System.out.println("Digite o ID do empregado para deletar:");
                    int idDeletar = sc.nextInt();
                    sc.next(); // Consumir quebra de linha
                    pessoaService.excluir(idDeletar);
                    System.out.println("Empregado removido com sucesso!");
                    break;

                case "3":
                    System.out.println("Digite o ID do empregado para atualizar:");
                    int idAtualizar = sc.nextInt();

                    Pessoa empregadoAtualizar = pessoaService.buscarPorId(idAtualizar);

                    if (empregadoAtualizar != null) {
                        System.out.println("Nome atual: " + empregadoAtualizar.getNome());
                        System.out.println("Digite o novo nome (ou pressione Enter para manter o atual):");
                        String novoNome = sc.next();

                        if (!novoNome.isEmpty()) {
                            empregadoAtualizar.setNome(novoNome);
                        }

                        pessoaService.atualizar(empregadoAtualizar);
                        System.out.println("Empregado atualizado com sucesso!");
                    } else {
                        System.out.println("Empregado não encontrado!");
                    }
                    break;

                case "4":
                    System.out.println("Digite o ID do empregado para buscar:");
                    int idBuscar = sc.nextInt();
                    sc.next(); // Consumir quebra de linha
                    Pessoa empregadoBuscado = pessoaService.buscarPorId(idBuscar);

                    if (empregadoBuscado != null) {
                        System.out.println(empregadoBuscado.toString());
                    } else {
                        System.out.println("Empregado não encontrado!");
                    }
                    break;

                case "5":
                    System.out.println("Saindo...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }
}