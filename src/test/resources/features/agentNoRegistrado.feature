#language: es
Característica: Comprobación de agentes
	
Escenario: Un agente tiene datos correctos

Dado un agente con nombre "Pepe", contraseña "pepe", tipo 1
Y no autorizado en el sistema
Cuando el agente con nombre "Pepe" envía una incidencia
Entonces el sistema muestra en pantalla un error