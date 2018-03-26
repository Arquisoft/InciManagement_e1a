#language: es
Característica: Comprobación de agentes
	
Escenario: Un agente tiene datos incorrectos

Dado un agente con nombre "Pepe", contraseña "", tipo 1
Y autorizado en el sistema
Cuando el agente con nombre "Pepe" envía una incidencia
Entonces el sistema no autoriza el envío de la inciadencia
Y se muestra un error