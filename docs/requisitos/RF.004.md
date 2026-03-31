# Lista Negra 
**COMO** Administrador(a) do Sistema,
**QUERO** impedir que usuários com pendências realizem novos empréstimos,
**PARA** reduzir o risco de acúmulo de prejuízos e garantir a devolução do acervo atual.

**Critérios de Aceitação:**
- O sistema deve validar se o usuário possui livros com data de devolução expirada antes de processar um novo registro.
- O banco de dados deve bloquear a inserção de novos empréstimos se houver multas não pagas vinculadas ao CPF do usuário.
- O bloqueio deve ser atualizado em tempo real assim que uma pendência for gerada ou quitada.
