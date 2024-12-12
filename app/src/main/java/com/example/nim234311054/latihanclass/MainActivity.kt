package com.example.nim234311054.latihanclass

enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING
}

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int,
)

val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }

fun main() {
    val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0)
    val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
    val event3 = Event(title = "Morning exercise", daypart = Daypart.MORNING, durationInMinutes = 20)

    val event4 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
    val event5 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
    val event6 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
    val event7 = Event(title = "Team meeting", daypart = Daypart.AFTERNOON, durationInMinutes = 45)

    val event8 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)
    val event9 = Event(title = "Read a book", daypart = Daypart.EVENING, durationInMinutes = 20)

//    val event =  Event (
//        title = "Studi Kotlin",
//        description = "Commit to studying Kotlin at least 15 minutes per day",
//        daypart = Daypart.EVENING,
//        durationInMinutes = 15
//    )
//
//    print(event)
    val events = mutableListOf(event1, event2, event3, event4, event5, event6, event7, event8, event9)

    events.forEach{ println(it) }
    println()
    val shortEvents = events.filter { it.durationInMinutes < 60 }
    println("You have ${shortEvents.size} short events.")
    println()

    val groupedEvents = events.groupBy { it.daypart }
    groupedEvents.forEach { (daypart, events) ->
        println("$daypart: ${events.size} events")
    }
    println()

    println("Last event of the day: ${events.last().title}")

    println("Duration of first event of the day: ${events[0].durationOfEvent}")
}