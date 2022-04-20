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
    fun tieneComplicaciones(): Boolean { return plantas.any() { it.horasDeSolQueTolera() < horasDeSol } }//?
    fun cantidadDePlantas(): Double { return plantas.size.toDouble() }
    fun plantarUnaPlanta(planta: Planta) {
        if (this.cantidadDePlantas() == this.cantidadMaximaDePlantas()) {
            println("No hay lugar en esta parcela")
        } else {
            plantas.add(planta) }
        }
}

class ParcelasEcologicas(ancho: Double, largo: Double, horasDeSol: Int, planta: MutableList<Planta>): Parcelas(ancho, largo, horasDeSol) { //¿Por qué el ! en rojo?
    fun seAsociaBien(planta: Planta) { !this.tieneComplicaciones() && planta.laParcelaEsIdeal(this) }
}

class ParcelasIndustriales(ancho : Double, largo: Double, horasDeSol: Int, planta: MutableList<Planta>): Parcelas(ancho, largo, horasDeSol) {
    fun seAsociaBien(planta: Planta) { this.cantidadMaximaDePlantas() <= 2 && planta.esFuerte() }
}

