# Diagrama de classe:

```mermaid
classDiagram
  class User {
    +userID: int
    +name: string
    +email: string
    +raid: Raid[]
  }

  class Raid {
    +id: int
    +star: int
    +pokemon: Pokemon
    +megaRaid: boolean
    +done: boolean
    +doneTimes: int
  }

  class Pokemon {
    +id: int
    +dexNumber: int
    +pokemonName: string
    +pokemonPNG: string
  }

  User --> "1" Raid : has 0..*
  Raid --> "1" Pokemon : has 1
  ```