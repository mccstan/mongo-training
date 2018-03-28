set /p REPLICAT_SET_CONFIG=<conf.json

echo "Intializing replica set : "

set /p REPLICAT_SET_CONF_SCRIPT="config = $REPLICAT_SET_CONFIG; rs.initiate(config);"

# echo $REPLICAT_SET_CONF_SCRIPT

docker exec -it soat_mongo1_1 bash -c "echo '${REPLICAT_SET_CONF_SCRIPT}' | mongo"
