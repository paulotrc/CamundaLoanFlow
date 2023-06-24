#! /usr/bin/env bash

docker-compose -f /home/paulotrc/Desenvolvimento/IGTI/arquitetura/infra-orquestrador/docker/docker-compose.yml down
docker-compose -f /home/paulotrc/Desenvolvimento/IGTI/arquitetura/infra-orquestrador/docker/docker-compose.yml up -d

echo '==================[Stack de arquitetura iniciada]=================='