#language: es
Característica: Comprobación de incidencias
	
Escenario: Una incidencia tiene datos correctos
	
Dado una incidencia con nombre "Fuego!", descripción "Hay fuego", etiqueta "peligro", propiedades "temperatura:alta"
Y producida por un agente autorizado en el sistema
Cuando el agente con nombre "Pepe" envía una incidencia con nombre "Fuego!"
Entonces el sistema autoriza el envío de la inciadencia
Y el sistema guarda la incidencia correctamente