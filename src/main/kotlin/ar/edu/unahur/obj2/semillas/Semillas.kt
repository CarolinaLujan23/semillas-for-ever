package ar.edu.unahur.obj2.semillas

open class Menta(altura: Double, anioSemilla: Int): Planta(altura, anioSemilla) {
    override fun espacio(): Double { return altura + 1 }
    override fun daSemillas(): Boolean { return altura > 0.4 || super.daSemillas() }
    override fun laParcelaEsIdeal(parcela: Parcelas): Boolean { return parcela.superficie() > 6 }
}

open class Soja(altura: Double, anioSemilla: Int): Planta(altura, anioSemilla) {
    override fun espacio(): Double { return altura / 2 }
    override fun daSemillas(): Boolean { return super.daSemillas() && anioSemilla > 2007 && altura in 0.75..0.9 }
    override fun laParcelaEsIdeal(parcela: Parcelas): Boolean { return parcela.horasDeSol == horasDeSolQueTolera()}

    override fun horasDeSolQueTolera(): Int {
        val horasBase = when {
            altura < 0.5 -> 6
            altura < 1 -> 8
            else -> 12
        }
        return horasBase
    }
}

open class Quinoa(altura: Double, anioSemilla: Int, val espacioDeLaQuinoa: Double): Planta(altura, anioSemilla) {
    override fun espacio(): Double { return espacioDeLaQuinoa }
    override fun daSemillas(): Boolean { return super.daSemillas() || anioSemilla in 2001..2008 }
    override fun laParcelaEsIdeal(parcela: Parcelas): Boolean { return !parcela.plantas.any { p -> p.altura > 1.5 } } //¿Así? Jaja

    override fun horasDeSolQueTolera(): Int {
        if(espacioDeLaQuinoa < 0.3) {
            return 10
        } else {
            return super.horasDeSolQueTolera()
        }
    }
}


//2-Variedades.
open class SojaTransgenica(altura: Double, anioSemilla: Int): Soja(altura, anioSemilla) {
    override fun daSemillas(): Boolean { return false }
    override fun laParcelaEsIdeal(parcela: Parcelas): Boolean { return parcela.cantidadMaximaDePlantas().toInt() == 1 }
}

open class Peperina(altura: Double, anioSemilla: Int): Menta(altura, anioSemilla) {
    override fun espacio(): Double { return espacio() * 2 }
    override fun laParcelaEsIdeal(parcela: Parcelas): Boolean { return super.laParcelaEsIdeal(parcela) }
}
//2-Fin variedades.

abstract class Planta(var altura: Double, val anioSemilla: Int) {
    open fun espacio(): Double = 0.0
    open fun esFuerte() = this.horasDeSolQueTolera() > 9
    open fun horasDeSolQueTolera(): Int = 7
    open fun daSemillas() = this.esFuerte()
    abstract fun laParcelaEsIdeal(parcela: Parcelas): Boolean
}