package ar.edu.unahur.obj2.semillas

import ar.edu.unahur.obj2.semillas.Inta.parcelas

object Inta {
    val parcelas = mutableListOf<Parcelas>()

    fun agregarParcela(parcela: Parcelas) {
        parcelas.add(parcela)
    }

    fun promedioPlantasPorParcela(): Int {
        val cantidadDePlantas = parcelas.sumOf { it.plantas.size } //?
        val cantidadDeParcealas = parcelas.size

        return cantidadDePlantas / cantidadDeParcealas

    }

    fun parcelaMasSustenable(): Parcelas {
        return parcelas.filter { p -> p.plantas.size > 4 }.maxBy { p -> p.porcentajeDePlantasBienAsociadas() }!!
    }
}