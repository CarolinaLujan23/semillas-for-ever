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

abstract class Quinoa(altura: Double, anioSemilla: Int): Planta(altura, anioSemilla) {
    override fun espacio(): Double {
        TODO("Lee un poco más el enunciado...")
    }

    override fun daSemillas(): Boolean {
        TODO("Dalee")
    }

    override fun esFuerte(): Boolean {
        TODO("Así me implementas mejor")
    }
}

abstract class Planta(var altura: Double, val anioSemilla: Int) {
    abstract fun espacio(): Double
    open fun esFuerte() = this.horasDeSolQueTolera() > 9
    abstract fun horasDeSolQueTolera(): Int
    open fun daSemillas() = this.esFuerte()
}