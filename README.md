# iceShop-Project

# Backend
## Create a new docker container postgreSQL

docker run --name iceShop-db \
  -e POSTGRES_USER=anhtu \
  -e POSTGRES_PASSWORD=123456 \
  -e POSTGRES_DB=iceShop_db \
  -p 9000:5432 \
  -d postgres
