Feature: Como Agente quiero consultar mis incidencias para ver el estado de las mismas
	Scenario: Agente lista consulta sus incidencias
	Given una incidencia enviada con: nombreAgente "usuarioJuan", password "password", tipoAgente "Person", name "Fuego!", description "Fuego en el monte de Terverga", etiquetas "fuego, emergencia, daños", porperties ""
	When me identifico como "usuarioJuan", contraseña "password" y tipo "Person"
	Then se listarán todas mis incidencias y podré consultar la incidencia de nombre "Fuego!"