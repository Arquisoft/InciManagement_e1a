[![Codacy Badge](https://api.codacy.com/project/badge/Grade/0a046654f6854ebe8d1c43214f72337a)](https://www.codacy.com/app/jelabra/InciManager_e1a?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Arquisoft/InciManager_e1a&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/Arquisoft/InciManager_e1a.svg?branch=master)](https://travis-ci.org/Arquisoft/InciManager_e1a)
[![codecov](https://codecov.io/gh/Arquisoft/InciManager_e1a/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/InciManager_e1a)


# InciManagement_e1a
InciManagement e1a

# Ejecucion del proyecto 
1 Si no lo tenenemos descargamos Kafka desde aqui: https://kafka.apache.org/downloads

2 Ejecutamos en una consola de comandos desde la carpeta principal de Kafka la siguiente orden:  mvn spring-boot:run

3 Desde otra consola de comandos ejecutamos:
    
    - Windows: bin\windows\zookeeper-server-start.bat config\zookeeper.properties
    
    - Linux: bin\zookeeper-server-start.bat config\zookeeper.properties
    
4 Desde una tercera consola de comandos nos situamos en la raiz del proyecto y ejecutamos:
    
    - Windows: bin\windows\kafka-server-start.bat config\server.properties
    
    - Linux: bin\kafka-server-start.bat config\server.properties
    
5 La aplicacion esta disponible en: http://localhost:8090/incidence/add

# Authors

- Fernando del Barrio Romano (UO252367)
- David Chillón Sánchez (UO250678)
- Paula Claro Heres (UO252315)
- David Rico Díaz (UO250898)
- Joaquín Ceballos Gómez (UO250687)
