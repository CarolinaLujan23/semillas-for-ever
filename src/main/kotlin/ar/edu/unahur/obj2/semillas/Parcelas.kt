package ar.edu.unahur.obj2.semillas

class Parcelas(val ancho: Double, val largo: Double, val horasDeSol: Int) {
    var plantas = mutableListOf<Planta>()

    fun superficie() { largo * ancho }
    fun cantidadMaximaDePlantas() {
        if(ancho > largo) {
            this.superficie() / 5
        } else {
            (this.superficie() / 3) * largo
        }
    }
    fun tieneComplicaciones() { plantas.any() { it.horasDeSolQueTolera() < horasDeSol } //?
    fun cantidadDePlantas() { plantas.size }
    fun plantarUnaPlanta(planta: Planta) {
        if (this.cantidadDePlantas() == this.cantidadMaximaDePlantas()) {
            println("No hay lugar en esta parcela")
        } else if (horasDeSol > planta.horasDeSolQueTolera() + 2) {
            println("No se puede plantar acá")
        } else {
            plantas.add(planta) }
        }
    }
}