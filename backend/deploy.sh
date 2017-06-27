mvn clean install
cd uma-server
mvn wildfly:deploy
echo "Deploy DONE!"
../test.sh
