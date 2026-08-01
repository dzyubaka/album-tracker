./gradlew bootJar
docker build -t album-tracker .
docker save -o album-tracker.tar album-tracker
scp album-tracker.tar dzyuba.dev:
ssh dzyuba.dev '
  docker load -i album-tracker.tar
  docker compose down app
  docker compose up -d app
  rm album-tracker.tar
'
rm album-tracker.tar
