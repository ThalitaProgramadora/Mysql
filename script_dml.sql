INSERT INTO bd_locadora.tb_categorias (nome)
VALUES
("Terror"),
("Ação"),
("Romance"),
("Comédia"),
("P&B");

INSERT INTO tb_clientes (nome, email)
VALUES
("Jéssica", "jess@email.com"),
("Alexsandro", "ale@email.com"),
("Natacha", "nat@email.com");


INSERT INTO tb_filmes (nome, fk_id_categoria, preco)
VALUES
("A volta dos que não foram", 2, 15.00),
("Titanic", 3, 15.00),
("Luzes da Cidade", 5, 10.00),
("Forest Gump", 4, 5.00),
("Contato de terceiro Grau", 1, 15.00),
("Os Vingadores", 2, 20.00);

INSERT INTO tb_aluguel (fk_id_cliente, fk_id_filme)
VALUES
(1,5);

INSERT INTO tb_aluguel (fk_id_cliente, fk_id_filme)
VALUES
(1,3);

INSERT INTO tb_aluguel (fk_id_cliente, fk_id_filme)
VALUES
(2,6);

SELECT tb_clientes.nome, SUM(tb_filmes.preco) AS Total
FROM tb_clientes
INNER JOIN tb_aluguel ON tb_clientes.id_cliente = tb_aluguel.fk_id_cliente
INNER JOIN tb_filmes ON tb_aluguel.fk_id_filme = tb_filmes.id_filme
GROUP BY tb_clientes.nome;
