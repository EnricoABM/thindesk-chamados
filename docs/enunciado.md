## Atividade Prática – Microserviço de Chamados Técnicos (5,0 pontos)

Objetivo: Evoluir o projeto ThinDesk (disponível em atividades de aula), considerando que o projeto já possui o sistema de login desenvolvido, evolua-o por meio da implementação de um microserviço em Java com Spring Boot, API REST e MongoDB, responsável pela abertura, acompanhamento e resolução de chamados técnicos.


**Requisitos obrigatórios**:

* Abertura de chamado (1,5 ponto): permitir que um usuário autenticado abra um chamado informando título e descrição. O sistema deverá registrar automaticamente o solicitante, a data de abertura e o status ABERTO.
* Consulta e acompanhamento (1,0 ponto): disponibilizar endpoints REST para listar os chamados de um usuário e consultar individualmente seus detalhes e status.
* Resolução do chamado (1,5 ponto): permitir que um técnico registre a solução aplicada, alterando o status para RESOLVIDO e registrando a data de resolução.
* Regras de negócio e integração (1,0 ponto): implementar as validações necessárias, persistir os dados no MongoDB, reutilizar a autenticação existente e impedir que chamados resolvidos sejam alterados novamente.

Endpoints mínimos:

* `POST /api/chamados`: Abrir chamado.
* `GET /api/chamados/usuario/{id}`: Listar chamados do usuário. 
* `GET /api/chamados/{id}`: Consultar chamado.
* `PUT /api/chamados/{id}/resolver`: Resolver chamado.

Entrega: disponibilizar o projeto atualizado no GitHub, envie o link do repositório e um vídeo curto (máximo de 5 minutos) demonstrando o funcionamento dos endpoints com Postman, Insomnia ou ferramenta equivalente, incluindo a persistência dos dados.

Importante: o vídeo deverá ser gravado diretamente da tela do computador, sem utilização de celulares ou câmeras externas.


Não é necessário desenvolver novas interfaces gráficas. O foco é a implementação do microserviço e de suas regras de negócio.
