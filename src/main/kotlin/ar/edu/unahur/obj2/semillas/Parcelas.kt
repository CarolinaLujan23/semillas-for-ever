package ar.edu.unahur.obj2.semillas

 open class Parcelas(val ancho: Double, val largo: Double, val horasDeSol: Int) {
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
     //abstract fun seAsociaBien(planta: Planta): Boolean
}

class ParcelasEcologicas(ancho: Double, largo: Double, horasDeSol: Int): Parcelas(ancho, largo, horasDeSol) { //¿Por qué el ! en rojo?
    //override fun seAsociaBien(planta: Planta): Boolean { return !this.tieneComplicaciones() && planta.laParcelaEsIdeal(this) }
}

//Falta parcelas insutriales

