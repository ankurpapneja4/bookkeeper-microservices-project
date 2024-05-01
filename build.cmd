call mvn -f ./eureka-service/pom.xml package -Pdocker
call mvn -f ./api-gateway/pom.xml package -Pdocker
call mvn -f ./config-server/pom.xml package -Pdocker
call mvn -f ./accounts-service/pom.xml package -Pdocker
call mvn -f ./inventory-service/pom.xml package -Pdocker
call mvn -f ./purchase-service/pom.xml package -Pdocker
call mvn -f ./tax-service/pom.xml package -Pdocker

