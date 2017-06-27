echo ""
echo "TESTING UMA-WEB"
echo ""
echo "Create 3 Users"
echo ""

curl -X POST --proxy localhost:8888 http://localhost:8080/uma-web/
echo ""
curl -X POST --proxy localhost:8888 http://localhost:8080/uma-web/
echo ""
curl -X POST --proxy localhost:8888 http://localhost:8080/uma-web/

echo ""
echo "Get Users"
echo ""

curl --proxy localhost:8888 http://localhost:8080/uma-web/

echo ""
echo "TESTING UMA-WEB DONE"
echo ""


echo ""
echo "TESTING UMA-API"
echo ""
echo "Create 1 other Users"
echo ""

curl -H "Accept: application/json" -H "Content-type: application/json" -X POST --proxy localhost:8888 http://localhost:8080/uma-api/users -d '{"userName": "test User", "fullName":"Nagy Janos", "passWord":"password"}'

echo ""
echo "Get Users"
echo ""

curl --proxy localhost:8888 http://localhost:8080/uma-api/users

echo ""
echo "Get one user with id 4"
echo ""

curl --proxy localhost:8888 http://localhost:8080/uma-api/users/4

echo ""
echo "Delete user with id 4"
echo ""

curl -X DELETE --proxy localhost:8888 http://localhost:8080/uma-api/users/4
echo ""
echo "Get Users"
echo ""
curl --proxy localhost:8888 http://localhost:8080/uma-web/

echo ""
echo "TESTING UMA-API DONE"
echo ""

