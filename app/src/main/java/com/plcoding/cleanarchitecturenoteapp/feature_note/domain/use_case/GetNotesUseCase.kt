package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Notes
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NotesRepository
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.Order
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(

    private val repository: NotesRepository
) {

    operator fun invoke(
        order: Order = Order.Date(OrderType.Descending)
    ) : Flow<List<Notes>> {
        return repository.getNotes().map { notes ->

            when(order.orderType) {

                is OrderType.Ascending -> {

                    when(order) {
                        is Order.Title -> notes.sortedBy { it.title.lowercase() }
                        is Order.Date -> notes.sortedBy { it.time }
                        is Order.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending -> {
                    when(order) {
                        is Order.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is Order.Date -> notes.sortedByDescending { it.time }
                        is Order.Color -> notes.sortedByDescending{ it.color }
                    }
                }
            }

        }
    }
}