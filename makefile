docker-up:
	docker compose up --build

docker-down:
	docker compose down

build:
	javac -d target ./src/main/java/org/example/Main.java

run:
	make build
	java -cp target org.example.Main