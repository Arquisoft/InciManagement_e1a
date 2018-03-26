#language: es
Característica: Comprobación de agentes
	
Escenario: Un agente tiene datos correctos

Dado un agente con nombre "Pepe", contraseña "pepe", tipo 1
Y autorizado en el sistema
Cuando el agente con nombre "Pepe" envía una incidencia
Entonces el sistema autoriza el envío de la inciadencia
Y el sistema guarda la incidencia correctamente