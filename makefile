docker-up:
	docker compose up --build

docker-down:
	docker compose down

podman-up:
	podman compose up --build

podman-down:
	podman compose down

build:
	javac -d target `find src/main/java -name "*.java"`

run:
	make build
	java -cp target org.example.Main

package:
	mvn clean package

gradle-build:
	gradle build

set-env:
	sdk env

install-env:
	sdk env install

test:
	mvn test

install:
	mvn clean install -U

java-debugger:
	java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 -jar ./target/java-bank-service-1.0-SNAPSHOT.jar
	jdb -attach 5005
