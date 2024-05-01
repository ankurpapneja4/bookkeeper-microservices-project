call mvn -f ./eureka-service/pom.xml install -Pdocker
call mvn -f ./api-gateway/pom.xml install -Pdocker
call mvn -f ./config-server/pom.xml install -Pdocker
call mvn -f ./accounts-service/pom.xml install -Pdocker
call mvn -f ./inventory-service/pom.xml install -Pdocker
call mvn -f ./purchase-service/pom.xml install -Pdocker
call mvn -f ./tax-service/pom.xml install -Pdocker

