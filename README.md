# Sobre esse projeto

Esse projeto, baseado em Java Spring Boot e outras tecnologias, é uma prova de conceito simplificada de um sistema de marketing de proximidade voltado para ambientes de comércio físico, como shoppings, galerias e supermercados com a finalidade de aumentar o engajamento do cliente e automatizar campanhas promocionais por meio de um aplicativo mobile com suporte à BLE (Bluetooth Low Energy) e um painel web administrativo.

> Bluetooth Low Energy (Bluetooth LE, colloquially BLE, formerly marketed as Bluetooth Smart) is a wireless personal area network technology designed and marketed by the Bluetooth Special Interest Group (Bluetooth SIG) aimed at novel applications in the healthcare, fitness, beacons, security, and home entertainment industries. Compared to Classic Bluetooth, Bluetooth Low Energy is intended to provide considerably reduced power consumption and cost while maintaining a similar communication range. (Extraído do artigo da Wikipedia sobre o assunto em [Bluetooth Low Energy](https://en.wikipedia.org/wiki/Bluetooth_Low_Energy))


## Objetivos

Os objetivos de um sistema de marketing de proximidade são:

1. Impulsionar o engajamento dos clientes com ofertas contextuais no ponto de venda
2. Fornecer autonomia para equipes de marketing criarem campanhas
3. Disponibilizar dados analíticos de proximidade para medir o desempenho das campanhas em tempo real

Já os objetivos desse projeto são mais singelos e ligados a aprendizado técnico:

1. Construir uma aplicação em Java, usando o framework SpringBoot;
2. Construir e conectar diferentes microsserviços;
3. Provisionar uma instância do Keycloak para autenticação e autorização
4. Uso de containers Docker para repetibilidade e simulação de um ambiente produtivo similar ao ambiente de desenvolvimento

## Visão geral do sistema

A Figura 1 apresenta a visão do geral do sistema. Nessa imagem beacon é um dispositivo montado em uma loja ou balção de corredor de um shopping ou galeria comercial, ou mesmo em uma loja de frente de rua. O usuário representado deve ter o aplicativo de cupons instalados em seu celular ou dispositivo móvel (smart watch ou tables) e registrado no estabelecimento que tem o beacon instalado fisicamente. Quando o beacon detecta a proximidade do dispositivo cadastrado, verifica as campanhas de marketing disponíveis e envia uma notificação para o dispositivo do usuário por meio do sistema, usando o protocolo HTTP. O papel do beacon nesse sistema é identificar qual dispositivo está nas proximidades para então disparar o processo de envio da campanha.

![Contexto da arquitetura](./arquitetura-contexto.png)
Figura 1: Visão conceitual do sistema de marketing de proximidade

O administrador, nessa representação, tem acesso a painéis onde pode gerenciar campanhas de marketing, inclusive agendando para períodos pré-determinados para aproveitar datas comemorativas ou disparar ofertas relâmpago com condições especiais para os usuários cadastrados. A interação do administrador com o sistema se dá por meio de uma interface web que se comunica com a aplicação.

## Componentes do sistema

![Diagrama C4 do sistema de marketing de proximidade](./arquitetura-container.png)

## Sistema de gerenciamento

Os elementos do sistema de gerenciamento são:

- **Tela de login**: Tela na qual o usuário realiza o login para ter autorização a acessar o sistema.
- **Gerenciamento do estabelecimento**: Gerenciamento do estabelecimento (CRUD) contendo endereço, horário de funcionamento e administradores.
- **Gerenciamento de Lojas**: Gerenciamento de loja (CRUD), vinculada ao estabelecimento comercial, com dados de contato, setor de atuação e logo.
- **Gerenciamento do Beacons**: Gerenciamento do Beacons(CRUD) com registro de UUID, Major e Minor de cada beacon e associação a loja.
- **Criação e agendamento de promoções**: Criação e agendamento de promoções para lojas, deve conter as informações básicas, critérios de público alvo e data de ativação e desativação.
- **Dashboard e Relatórios**: Relatório de performace de promoções, taxa de abertura de notificações, conversão e exportação desses relatórios.

## Aplicativo mobile

Os elementos do aplicativo mobile são:

- **Usuário**: Pessoa que tem o aplicativo de cupons instalado no seu celular.
- **Aplicativo Mobile**: Aplicativo Mobile que permite ao usuário receber notificações sobre promoções que está ocorrendo dentro de uma determinada loja.
- **Firebase Cloud Message**: Sistema da Google para envio de push notification


## Backend

Os elementos do backend são:

- Autenticação e autorização:
  - **IAM Database**: Base de dados responsável pelo armazenamento das informações cadastradas.
  - **IAM**: Microserviço de autenticação/autorização

- Estabelecimento comercial:
  - **Establishment API**: Gerenciamento do estabelecimento (CRUD) contendo endereço, horário de funcionamento e administradores.
  - **Establishment Database**: Base de dados responsável pelo armazenamento das informações cadastradas.

- Beacons:
  - **Beacons API**: Gerenciamento do Beacons(CRUD) com registro de UUID, Major e Minor de cada beacon e associação a loja.
  - **Beacons Database**: Base de dados responsável pelo armazenamento das informações cadastradas.

- Promoções e campanhas comerciais:
  - **Promotion Management API**: Criação e agendamento de promoções para lojas, deve conter as informações básicas, critérios de público-alvo e data de ativação e desativação.
  - **Promotion Database**: Base de dados responsável pelo armazenamento das informações cadastradas.
  - **Promotion Worker**
  - **Promotion Topic**

# Como executar esse projeto

## Requisitos mínimos

Para a execução desse projeto, embora detalhes possam variar conforme o sistema operacional do desenvolvedor, os seguintes requisitos mínimos são necessários:

1. git para o controle de versão e interação com o serviço de hospedagem remoto GitHub
   1. [git for Windows](https://git-scm.com/downloads/win)
   2. [git for Linux](https://git-scm.com/downloads/linux)
   3. [git for macOS](https://git-scm.com/downloads/mac)
2. [IntelliJ Idea Ultimate (gratuito para estudantes)](https://www.jetbrains.com/academy/student-pack/)
3. [Docker](https://dev.to/bowmanjd/install-docker-on-windows-wsl-without-docker-desktop-34m9) ou [Docker Desktop](https://docs.docker.com/desktop/setup/install/windows-install/)
4. Algum JDK com suporte ao Java 21 ([Resposta detalhada às questões de licenciamento do JDK](https://stackoverflow.com/questions/58250782/which-free-version-of-java-can-i-use-for-production-environments-and-or-commerci/58260110#58260110))
   1. [OpenJDK](https://openjdk.org/projects/jdk/21/)
   2. [Amazon Corretto 21](https://docs.aws.amazon.com/corretto/latest/corretto-21-ug/downloads-list.html)
   3. [IBM Semeru Runtimes](https://developer.ibm.com/languages/java/semeru-runtimes/downloads/?license=IBM) / [Introducing the no-cost IBM Semeru Runtimes to develop and run Java applications](https://developer.ibm.com/blogs/introducing-the-ibm-semeru-runtimes/)
5. [Keycloak](https://www.keycloak.org/)
6. [PostgreSQL](https://www.postgresql.org/)
7. [pgAdmin](https://www.pgadmin.org/)
8. [SonarSource](https://www.sonarsource.com/)
9. [Jenkins](https://www.jenkins.io/)

## Comandos úteis

### PostgreSQL

Para provisionar um container contendo o PostgreSQL, use o comando abaixo se estiver no WSL ou em um máquina Linux:

```shell
sudo docker run --name my-postgre -e "POSTGRES_PASSWORD={insira sua senha aqui}" -e "POSTGRES_USER=postgres" -p 5432:5432 -d postgres:17.4
```

ou no PowerShell no Windows: 

```PowerShell
docker run --name my-postgre -e "POSTGRES_PASSWORD={insira sua senha aqui}" -e "POSTGRES_USER=postgres" -p 5432:5432 -d postgres:17.4
```

para inspecionar o IP para conexão posterior ao banco de dados use o comando abaixo:

```shell
docker inspect my-postgre
```

```json
[
    {
        "Id": "{redacted}",
        "Created": "{redacted}",
        "Path": "docker-entrypoint.sh",
        ...
        "Image": "{redacted}",
        ...        
        "NetworkSettings": {
                ...
            },
            ...
            "LinkLocalIPv6Address": "{redacted}",
            "LinkLocalIPv6PrefixLen": 0,
            "SecondaryIPAddresses": null,
            "SecondaryIPv6Addresses": null,
            "EndpointID": "{redacted}",
            "Gateway": "{redacted}",
            "GlobalIPv6Address": "{redacted}",
            "GlobalIPv6PrefixLen": 0,
            "IPAddress": "{redacted}", <<< Informação necessária para conexão com o banco de dados
            "IPPrefixLen": 16,
            "IPv6Gateway": "{redacted}",
            "MacAddress": "{redacted}",
            ...
        }
    }
]
```

### pgAdmin

Para provisionar um container contendo o pgAdmin, use o comando abaixo se estiver no WSL ou em um máquina Linux:

```shell
sudo docker run --name my-pg-admin -e "PGADMIN_DEFAULT_EMAIL={insira seu e-mail aqui}" -e "PGADMIN_DEFAULT_PASSWORD={insira sua senha aqui}" -p 7000:80 -d dpage/pgadmin4:9.1.0
```

```PowerShell
docker run --name my-pg-admin -e "PGADMIN_DEFAULT_EMAIL={insira seu e-mail aqui}" -e "PGADMIN_DEFAULT_PASSWORD={insira sua senha aqui}" -p 7000:80 -d dpage/pgadmin4:9.4.0
```

## Keycloak

Para provisionar um container contendo o Keycloak, use o comando abaixo:

```PowerShell
docker run --name my-keycloak -p 7001:8080 -e "kc_bootstrap_admin_username=admin" -e "KC_BOOTSTRAP_ADMIN_PASSWORD={insira sua senha aqui}" -d quay.io/keycloak/keycloak:26.1.4 start-dev --features authorization,organization
```

## SonarQube:

Para provisionar um container contendo o SonarQube, use o comando abaixo:

```PowerShell
docker run -d --name my-sonarqube -p 7002:9000 -d sonarqube:lts-community
```

## Jenkins

Para provisionar um container contendo o Jenkins, use o comando abaixo:

```PowerShell
docker run --name my-jenkins -p 7003:8080 -p 7004:50000 -d jenkins/jenkins:lts-jdk17 
```

# Referências

1. [Bluetooth Low Energy](https://en.wikipedia.org/wiki/Bluetooth_Low_Energy)
2. [Install Docker on Windows (WSL) without Docker Desktop](https://dev.to/bowmanjd/install-docker-on-windows-wsl-without-docker-desktop-34m9)
