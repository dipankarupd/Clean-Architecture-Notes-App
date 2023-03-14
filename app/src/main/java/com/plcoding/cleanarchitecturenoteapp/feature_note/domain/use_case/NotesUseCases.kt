package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case

/*
In this class, I wrap up all the use cases so that injecting all the use cases into the
view model is simple and easy
 */
class NotesUseCases(
    val deleteNotesUseCase : DeleteNotesUseCase,
    val getNotesUseCase: GetNotesUseCase
) {

}