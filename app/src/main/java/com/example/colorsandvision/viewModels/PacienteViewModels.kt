package com.example.colorsandvision.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.colorsandvision.model.PacienteModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.DocumentSnapshot

class PacienteViewModel : ViewModel() {

    private val firestore = FirebaseFirestore.getInstance()

    // LiveData para los resultados de añadir paciente
    private val _addPacienteResult = MutableLiveData<Result<String>>()
    val addPacienteResult: LiveData<Result<String>> get() = _addPacienteResult

    // LiveData para los resultados de búsqueda de paciente
    private val _searchPacienteResult = MutableLiveData<Result<PacienteModel>>()
    val searchPacienteResult: LiveData<Result<PacienteModel>> get() = _searchPacienteResult

    // LiveData para los resultados de asociar examen a paciente
    private val _asociarExamenAVistaResult = MutableLiveData<Result<String>>()
    val asociarExamenAVistaResult: LiveData<Result<String>> get() = _asociarExamenAVistaResult

    // Método para añadir un paciente a la base de datos
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

    // Método para buscar un paciente por celular
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

    // Método para asociar un examen de vista a un paciente
    fun asociarExamenAVista(
        pacienteId: String,
        lineaOD: String,
        lineaOI: String,
        lineaAOOD: String,
        lineaAOOI: String,
        esferaOD: String,
        esferaOI: String,
        cilindroOD: String,
        cilindroOI: String,
        presbiciaOD: String,
        presbiciaOI: String,
        observaciones: String
    ) {
        val examen = ExamenModel(
            pacienteId = pacienteId,
            lineaOD = lineaOD,
            lineaOI = lineaOI,
            lineaAOOD = lineaAOOD,
            lineaAOOI = lineaAOOI,
            esferaOD = esferaOD,
            esferaOI = esferaOI,
            cilindroOD = cilindroOD,
            cilindroOI = cilindroOI,
            presbiciaOD = presbiciaOD,
            presbiciaOI = presbiciaOI,
            observaciones = observaciones
        )

        firestore.collection("examenes")
            .add(examen.toMap())
            .addOnSuccessListener {
                _asociarExamenAVistaResult.postValue(Result.success("Examen asociado exitosamente"))
            }
            .addOnFailureListener { exception ->
                _asociarExamenAVistaResult.postValue(Result.failure(exception))
            }
    }
}

// ExamenModel.kt



data class ExamenModel(
    var pacienteId: String = "",
    var lineaOD: String = "",
    var lineaOI: String = "",
    var lineaAOOD: String = "",
    var lineaAOOI: String = "",
    var esferaOD: String = "",
    var esferaOI: String = "",
    var cilindroOD: String = "",
    var cilindroOI: String = "",
    var presbiciaOD: String = "",
    var presbiciaOI: String = "",
    var observaciones: String = ""
) {
    // Esta función convierte un DocumentSnapshot en un objeto ExamenModel
    fun fromDocumentSnapshot(doc: DocumentSnapshot): ExamenModel {
        val examen = doc.toObject(ExamenModel::class.java)!!
        examen.pacienteId = doc.id
        return examen
    }

    // Esta función convierte el objeto ExamenModel a un Map para ser almacenado en Firestore
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "pacienteId" to pacienteId,
            "lineaOD" to lineaOD,
            "lineaOI" to lineaOI,
            "lineaAOOD" to lineaAOOD,
            "lineaAOOI" to lineaAOOI,
            "esferaOD" to esferaOD,
            "esferaOI" to esferaOI,
            "cilindroOD" to cilindroOD,
            "cilindroOI" to cilindroOI,
            "presbiciaOD" to presbiciaOD,
            "presbiciaOI" to presbiciaOI,
            "observaciones" to observaciones
        )
    }
}

