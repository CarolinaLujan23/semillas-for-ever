package ar.edu.unahur.obj2.semillas

class Parcelas(val ancho: Double, val largo: Double, val horasDeSol: Int) {
    var plantas = mutableListOf<Planta>()

    fun superficie(): Double { return largo * ancho }
    fun cantidadMaximaDePlantas(): Double {
        if(ancho > largo) {
            return this.superficie() / 5
        } else {
            return (this.superficie() / 3) * largo
        }
    }
    fun tieneComplicaciones() { plantas.any() { it.horasDeSolQueTolera() < horasDeSol } }//?
    fun cantidadDePlantas(): Double { return plantas.size.toDouble() }
    fun plantarUnaPlanta(planta: Planta) {
        if (this.cantidadDePlantas() == this.cantidadMaximaDePlantas()) {
            println("No hay lugar en esta parcela")
        } else {
            plantas.add(planta) }
        }
    }

