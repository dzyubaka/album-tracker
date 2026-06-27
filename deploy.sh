docker build -t album-tracker .
docker save -o album-tracker.tar album-tracker
scp album-tracker.tar root@88.210.34.63:
ssh root@88.210.34.63 docker load -i album-tracker.tar
ssh root@88.210.34.63 cd /opt/album-tracker && docker compose up -d --force-recreate app
