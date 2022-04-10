package ar.edu.unahur.obj2.semillas

abstract class Menta(altura: Double, anioSemilla: Int): Planta(altura, anioSemilla) {
    override fun espacio(): Double { return altura + 1 }
    override fun daSemillas(): Boolean { return altura > 0.4 || super.daSemillas() }
}

abstract class Soja(altura: Double, anioSemilla: Int): Planta(altura, anioSemilla) {
    override fun espacio(): Double { return altura / 2 }
    override fun daSemillas(): Boolean { return super.daSemillas() && anioSemilla > 2007 && altura in 0.75..0.9 }
    override fun horasDeSolQueTolera(): Int {
        val horasBase = when {
            altura < 0.5 -> 6
            altura < 1 -> 8
            else -> 12
        }
        return horasBase
    }
}

abstract class Quinoa(altura: Double, anioSemilla: Int, val espacioDeLaQuinoa: Double): Planta(altura, anioSemilla) {
    override fun espacio(): Double { return espacioDeLaQuinoa }
    override fun daSemillas(): Boolean { return super.daSemillas() || anioSemilla in 2001..2008 }
    override fun horasDeSolQueTolera(): Int {
        if(espacioDeLaQuinoa < 0.3) {
            return 10
        } else {
            return super.horasDeSolQueTolera()
        }
    }
}

abstract class Planta(var altura: Double, val anioSemilla: Int) {
    open fun espacio(): Double = 0.0
    open fun esFuerte() = this.horasDeSolQueTolera() > 9
    open fun horasDeSolQueTolera(): Int = 7
    open fun daSemillas() = this.esFuerte()
}