Feature: Como Agente quiero consultar mis incidencias para ver el estado de las mismas
	Scenario: Agente lista consulta sus incidencias
	Given una incidencia enviada
	When me identifico como usuarioJuan, contraseña password y tipo Person
	Then se listarán todas mis incidencias
		And podré consultar la incidencia enviada