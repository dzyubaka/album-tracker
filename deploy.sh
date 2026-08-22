./gradlew bootJar
docker build -t album-tracker .
docker save -o album-tracker.tar album-tracker
scp album-tracker.tar dzyuba.dev:/opt/album-tracker/
ssh dzyuba.dev '
  cd /opt/album-tracker/
  docker load -i album-tracker.tar
  docker compose down app
  docker compose up -d app
  rm album-tracker.tar
'
rm album-tracker.tar
