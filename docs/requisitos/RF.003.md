# Histórico de Custódia

**COMO** Bibliotecário,
**QUERO** que o sistema registre cada alteração de posse de um livro,
**PARA** que eu possa realizar auditorias e identificar responsáveis em caso de perda ou furto.

**Critérios de Aceitação:**

- O banco de dados deve registrar automaticamente o ID do usuário e o ID do exemplar em cada movimentação.
- Cada registro deve conter obrigatoriamente um timestamp (data e hora exata) gerado pelo sistema.
- O histórico de movimentação não deve permitir exclusão ou edição (registro imutável).
