Feature: Product - Store

  @testStore
  Scenario Outline: Validación del precio de un producto

    Given estoy en la pagina de la tienda
    And me logue con mi usuario "<usuario>" y clave "<clave>"
    When  navego a la categoria "<categoria>" y subcategoria "Men"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then  valido el titulo de la pagina del "Carrito"
    And vuelvo a validar el calculo de precios en el carrito

    Examples:
      | usuario                 | clave        | categoria |
      | marcosbozzo@hotmail.com | nttdata.2025 | Clothes   |
      | marcosbozzo@hotmail.com | 2025         | Clothes   |
      | marcosbozzo@hotmail.com | nttdata.2025 | Car       |