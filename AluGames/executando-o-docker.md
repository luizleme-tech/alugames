## Remover o container

```bash
    docker rm -f mysql_alugames
```


## Constuir a imagem

```bash
    docker build -t mysql_alugames .
```

## Rodar o container

```bash
    docker run -d --name mysql_local -p 3306:3306 mysql_alugames
```

## Acessando o Mysql

```bash
  mysql -u alugames_user -p
```

```bash
    show databases;
```

```bash
    use alugames;
```

```bash
    show tables;
```