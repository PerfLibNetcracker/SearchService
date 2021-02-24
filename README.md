**Для сборки и запуска докерфайла:**
1
`docker build -t springio/searchserver-spring-boot-docker .` в корне директории

Внутри докерфайла можно указать `ENV env1=var` чтобы указать переменные окружения (к примеру `DATASOURCE_URL`)

Если бд находится на той же машине, то запускается контейнер через:

`docker run -d --net host springio/searchserver-spring-boot-docker`

Если была указана переменная окружения для внешнего сервера, то запуск через:

`docker run -d -p 8080:8080 springio/searchserver-spring-boot-docker`
