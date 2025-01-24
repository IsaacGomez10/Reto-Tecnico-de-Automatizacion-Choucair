#language: es
Característica: Realizar contratacion
  como usuario administrador quiero realizar la
  contratacion de un candidato de manera exitosa

  @ContratacionCandidato
  Escenario: Realizar contratacion exitosa
    Dado el usuario se encuentra en la pagina OrangeHRM
    Y leera el archivo excel datos_candidatos obtentra los datos de la fila 2
    Cuando ingresa los datos de login accedera el portal
      | usuario    | Admin    |
      | contraseña | admin123 |
    Y en el modulo de reclutamiento con los datos recolectados realizara la contratacion
    Entonces verificara que el estado del candidato sea Hired