package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class ParcelasTest : DescribeSpec ({
    describe("Parcela y plantas de soja") {
        val Parcela = Parcelas(20.0, 1.0, 10)
        val Soja1 = Soja(2.1,2020)
        val Soja2 = Soja(2.1,2020)
        val Soja3 = Soja(2.1,2020)
        val Soja4 = Soja(2.1,2020)

        Parcela.plantarUnaPlanta(Soja1)
        Parcela.plantarUnaPlanta(Soja2)
        Parcela.plantarUnaPlanta(Soja3)
        Parcela.plantarUnaPlanta(Soja4)

        it("Superficie") {
            Parcela.superficie().shouldBe(20)
        }

        it("Cantidad máxima de plantas") {
            Parcela.cantidadMaximaDePlantas().shouldBe(4)
        }
    }
})

