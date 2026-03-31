#Limite de Empréstimos por Usuário
**COMO** Bibliotecário Chefe,
**QUERO** definir uma quantidade máxima de livros que cada usuário pode retirar por vez
**PARA** que eu possa limitar o risco de perda do acervo e garantir que mais leitores tenham acesso aos livros.

**Critérios de Aceitação:**
- Deve ser possível configurar o número máximo de livros permitidos para cada usuário (ex: até 3 livros).
- O sistema deve validar a quantidade de livros que o usuário já possui antes de autorizar um novo empréstimo.
- O sistema deve impedir o registro de um novo empréstimo caso o limite máximo seja atingido.
- O sistema deve liberar a cota do usuário automaticamente assim que um livro for devolvido.
