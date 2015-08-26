#!/bin/bash

echo ""
echo "======================="
echo "Iniciando pruebas"
echo "======================="
echo ""
echo "Content-type: application/x-www-form-urlencoded"

curl -X GET http://localhost:8888/info/test -H 'Content-type: application/x-www-form-urlencoded' -H 'Accept: application/json'
echo ""
curl -X GET http://localhost:8888/info/test -H 'Content-type: application/x-www-form-urlencoded' -H 'Accept: application/xml'
echo ""
curl -X POST http://localhost:8888/info/test -H 'Content-type: application/x-www-form-urlencoded' -H 'Accept: application/json' -d 'param=parametro de prueba'
echo ""
curl -X POST http://localhost:8888/info/test -H 'Content-type: application/x-www-form-urlencoded' -H 'Accept: application/xml' -d 'param=parametro de prueba'

echo ""
echo "======================="
echo ""
echo "Content-type: application/json"

curl -X GET http://localhost:8888/info/test -H 'Content-type: application/json' -H 'Accept: application/json'
echo ""
curl -X GET http://localhost:8888/info/test -H 'Content-type: application/json' -H 'Accept: application/xml'
echo ""
curl -X POST http://localhost:8888/info/test -H 'Content-type: application/json' -H 'Accept: application/json' -d '{"param":"parametro de prueba"}'
echo ""
curl -X POST http://localhost:8888/info/test -H 'Content-type: application/json' -H 'Accept: application/xml' -d '{"param":"parametro de prueba"}'

echo ""
echo "======================="
echo ""
echo "Content-type: application/xml"

curl -X GET http://localhost:8888/info/test -H 'Content-type: application/xml' -H 'Accept: application/json'
echo ""
curl -X GET http://localhost:8888/info/test -H 'Content-type: application/xml' -H 'Accept: application/xml'
echo ""
curl -X POST http://localhost:8888/info/test -H 'Content-type: application/xml' -H 'Accept: application/json' -d '<requestDto><param>parametro de prueba</param></requestDto>'
echo ""
curl -X POST http://localhost:8888/info/test -H 'Content-type: application/xml' -H 'Accept: application/xml' -d '<requestDto><param>parametro de prueba</param></requestDto>'

exit