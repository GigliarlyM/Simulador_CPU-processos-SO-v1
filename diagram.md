Diagrama de classe

```mermaid
classDiagram
    class Processo {
        -int id
        -int quantidadeInstrucoes
        +Processo(id: int, qtdInstrucoes: int)
        +decrementarInstrucoes(): void
        +estaFinalizado(): boolean
        +getId(): int
        +getQuantidadeInstrucoes(): int
    }

    class GeradorDeProcessos {
        -int ultimoId
        +GeradorDeProcessos()
        +gerarProcesso(): Processo
    }

    class Escalonador {
        -List~Processo~ processos
        -string algoritmo
        -int quantum
        -int contadorQuantum
        +Escalonador(algoritmo: string, quantum: int)
        +adicionarProcesso(processo: Processo): void
        +proximoProcesso(): Processo
        +removerProcesso(processo: Processo): void
        +temProcessos(): boolean
    }

    class CPU {
        -Escalonador escalonador
        -Processo processoAtual
        -int ciclosInterrupcao
        -int contadorCiclos
        +CPU(escalonador: Escalonador, ciclosInterrupcao: int)
        +executar(): void
        -solicitarNovoProcesso(): void
        -executarCiclo(): void
    }

    GeradorDeProcessos --> Processo : cria
    CPU --> Escalonador : solicita processos
    Escalonador --> Processo : gerencia
    CPU --> Processo : executa
```

Diagrama de atividade

```mermaid
flowchart TD
    Start([Início]) --> InicializarSistema
    InicializarSistema --> ConfigurarEscalonador
    ConfigurarEscalonador --> InicializarCPU
    InicializarCPU --> MainLoop[Laço Principal da CPU]
    
    MainLoop --> VerificarInterrupcao{Verificar necessidade\n de interrupção?}
    
    VerificarInterrupcao -->|Sim| SolicitarNovoProcesso
    VerificarInterrupcao -->|Não| ExecutarInstrucao
    
    SolicitarNovoProcesso --> EscalonadorProximo[Escalonador seleciona\n próximo processo]
    EscalonadorProximo --> AtualizarProcessoCPU[CPU atualiza processo atual]
    AtualizarProcessoCPU --> ExecutarInstrucao
    
    ExecutarInstrucao --> DecrementarInstrucoes[Decrementar instruções do processo]
    DecrementarInstrucoes --> VerificarProcessoFinalizado{Processo finalizado?}
    
    VerificarProcessoFinalizado -->|Sim| RemoverProcesso[Remover processo do escalonador]
    VerificarProcessoFinalizado -->|Não| IncrementarCiclos
    
    RemoverProcesso --> IncrementarCiclos
    
    IncrementarCiclos --> Sleep[Aguardar ciclo de clock]
    Sleep --> VerificarContinuação{Continuar execução?}
    
    VerificarContinuação -->|Sim| MainLoop
    VerificarContinuação -->|Não| End([Fim])
    
    %% Processos paralelos
    subgraph ProcessoParalelo [Geração de Processos em Paralelo]
        GeradorLoop[Laço do Gerador de Processos]
        GeradorLoop --> VerificarNecessidadeProcesso{Necessário novo processo?}
        VerificarNecessidadeProcesso -->|Sim| GerarNovoProcesso[Gerar novo processo]
        GerarNovoProcesso --> AdicionarAoEscalonador[Adicionar ao escalonador]
        AdicionarAoEscalonador --> SleepGerador[Aguardar intervalo]
        VerificarNecessidadeProcesso -->|Não| SleepGerador
        SleepGerador --> GeradorLoop
    end
    
    InicializarSistema --> ProcessoParalelo
```