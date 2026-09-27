package com.example.myapplication

data class Persona(
    val name: String,
    val age: Int,
    val entreteniments: List<String>
)

const val Usuari = "Joedry"

fun main() {
    val jo = Persona(
        "Joedry",
        18,
        listOf("Videojocs", "Futbol", "Series", "Gym")
    )

    botDeSeguretat(jo)
}

fun botDeSeguretat(persona: Persona) {
    if (persona.name != Usuari) {
        println("Accés denegat!! Aquest no es el teu compte.")
        return
    }
    println("Nom verificat correctament.")

    when {
        persona.age in 0..13 -> {
            println("Acces denegat!! Ets massa petit/a.")
        }
        persona.age in 14..17 -> {
            println("Necesites permís paretal")
        }
        persona.age >= 18 -> {
            println("Acces correcte!! Pots passar.")

            val filtre = persona.entreteniments.filter { it.first().uppercaseChar() in 'A'..'L' }.sorted()
            println("El teus entreteniments:")

            for (e in filtre) {
                println("- $e")
            }
        }
        else -> println("Edat no vàlida.")
    }

}

