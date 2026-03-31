# Cadrastro de Usuários
**COMO** Atendente da Livraria,
**QUERO** cadastrar os dados pessoais e de contato dos leitores,
**PARA** que o sistema possa identificar cada indivíduo e aplicar as regras de permissão ou bloqueio de empréstimos.

*Critérios de Aceitação:*

 - O sistema deve exigir campos obrigatórios: Nome Completo, CPF (para fins jurídicos), E-mail e Telefone.
- O sistema deve impedir o cadastro de CPFs duplicados, garantindo que cada usuário seja único no banco de dados.
- Deve existir um campo de Status do Cadastro (Ativo, Bloqueado, Inativo) que será consultado automaticamente pelo módulo de empréstimos.
