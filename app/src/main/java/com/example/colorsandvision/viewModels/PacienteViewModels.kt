package com.example.colorsandvision.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.colorsandvision.model.PacienteModel
import com.google.firebase.firestore.FirebaseFirestore


class PacienteViewModel : ViewModel() {

    private val firestore = FirebaseFirestore.getInstance()

    val _addPacienteResult = MutableLiveData<Result<String>>()
    val addPacienteResult: LiveData<Result<String>> get() = _addPacienteResult
    private val _searchPacienteResult = MutableLiveData<Result<PacienteModel>>()
    val searchPacienteResult: LiveData<Result<PacienteModel>> get() = _searchPacienteResult
    fun addPaciente(paciente: PacienteModel) {
        val pacienteMap = paciente.toMap()
        firestore.collection("paciente")
            .add(pacienteMap)
            .addOnSuccessListener {
                _addPacienteResult.postValue(Result.success("Paciente agregado exitosamente"))
            }
            .addOnFailureListener { exception ->
                _addPacienteResult.postValue(Result.failure(exception))
            }
    }
/*
    fun searchPacienteByIdOrCelular(query: String) {
        firestore.collection("pacientes")
            .whereEqualTo("pacienteId", query)
            .get()
            .addOnSuccessListener { documents ->
                if (!documents.isEmpty) {
                    val paciente = documents.documents[0].toObject(PacienteModel::class.java)
                    _searchPacienteResult.postValue(Result.success(paciente!!))
                } else {
                    // If no result found by ID, search by celular
                    firestore.collection("pacientes")
                        .whereEqualTo("celular", query.toInt())
                        .get()
                        .addOnSuccessListener { documentsByCelular ->
                            if (!documentsByCelular.isEmpty) {
                                val paciente = documentsByCelular.documents[0].toObject(PacienteModel::class.java)
                                _searchPacienteResult.postValue(Result.success(paciente!!))
                            } else {
                                _searchPacienteResult.postValue(Result.failure(Exception("No se encontró el paciente.")))
                            }
                        }
                        .addOnFailureListener { exception ->
                            _searchPacienteResult.postValue(Result.failure(exception))
                        }
                }
            }
            .addOnFailureListener { exception ->
                _searchPacienteResult.postValue(Result.failure(exception))
            }
    }
*/
/*fun searchPacienteByCelular(celular: String) {
    try {
        val celularQuery = celular.toInt()
        firestore.collection("pacientes")
            .whereEqualTo("celular", celularQuery)
            .get()
            .addOnSuccessListener { documents ->
                if (!documents.isEmpty) {
                    val paciente = documents.documents[0].toObject(PacienteModel::class.java)
                    _searchPacienteResult.postValue(Result.success(paciente!!))
                } else {
                    _searchPacienteResult.postValue(Result.failure(Exception("No se encontró el paciente con el número de celular proporcionado.")))
                }
            }
            .addOnFailureListener { exception ->
                _searchPacienteResult.postValue(Result.failure(exception))
            }
    } catch (e: NumberFormatException) {
        _searchPacienteResult.postValue(Result.failure(Exception("El número de celular proporcionado no es válido.")))
    }
}*/
fun searchPacienteByCelular(celular: String) {
    firestore.collection("pacientes")
        .get()
        .addOnSuccessListener { documents ->
            var pacienteEncontrado: PacienteModel? = null
            for (document in documents) {
                val paciente = document.toObject(PacienteModel::class.java)
                if (paciente.celular.equals(celular.toInt())) {
                    pacienteEncontrado = paciente
                    break
                }
            }
            if (pacienteEncontrado != null) {
                _searchPacienteResult.postValue(Result.success(pacienteEncontrado))
            } else {
                _searchPacienteResult.postValue(Result.failure(Exception("No se encontró el paciente con el número de celular proporcionado.")))
            }
        }
        .addOnFailureListener { exception ->
            _searchPacienteResult.postValue(Result.failure(exception))
        }
}

}