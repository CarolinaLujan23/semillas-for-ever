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

        val Menta = Menta(2.1,2020)
        val Quinoa = Quinoa(2.1,2020, 1.0)
        val SojaTrans = SojaTransgenica(2.1,2020)

        val ParcelaEco = ParcelasEcologicas(20.0, 1.0, 10, mutableListOf(Soja1, Soja2, Soja3))
        val ParcelaIndu = ParcelasIndustriales(20.0, 1.0, 10, mutableListOf(Soja1, Menta, SojaTrans))


        Parcela.plantarUnaPlanta(Soja1)
        Parcela.plantarUnaPlanta(Soja2)
        Parcela.plantarUnaPlanta(Soja3)
        Parcela.plantarUnaPlanta(Soja4)

        ParcelaEco.plantarUnaPlanta(Soja1)
        ParcelaEco.plantarUnaPlanta(Menta)
        ParcelaEco.plantarUnaPlanta(Quinoa)
        ParcelaEco.plantarUnaPlanta(SojaTrans)

        ParcelaIndu.plantarUnaPlanta(Soja1)
        ParcelaIndu.plantarUnaPlanta(Menta)
        ParcelaIndu.plantarUnaPlanta(Quinoa)
        ParcelaIndu.plantarUnaPlanta(SojaTrans)

        it("Superficie") {
            Parcela.superficie().shouldBe(20)
        }

        it("Cantidad máxima de plantas") {
            Parcela.cantidadMaximaDePlantas().shouldBe(4)
        }

        it("La parcela es ideal para menta") {
            Menta.laParcelaEsIdeal(Parcela).shouldBeTrue()
            Menta.laParcelaEsIdeal(ParcelaEco).shouldBeTrue()
            Menta.laParcelaEsIdeal(ParcelaIndu).shouldBeTrue()
        }

        it("La parcela es ideal para soja") {
            Soja1.laParcelaEsIdeal(Parcela).shouldBeFalse()
            Soja1.laParcelaEsIdeal(ParcelaEco).shouldBeFalse()
            Soja1.laParcelaEsIdeal(ParcelaIndu).shouldBeFalse()
        }

        it("La parcela es ideal para soja trans") {
            SojaTrans.laParcelaEsIdeal(Parcela).shouldBeFalse()
            SojaTrans.laParcelaEsIdeal(ParcelaEco).shouldBeFalse()
            SojaTrans.laParcelaEsIdeal(ParcelaIndu).shouldBeFalse()
        }

        it("La parcela es ideal para quinoa") {
            Quinoa.laParcelaEsIdeal(Parcela).shouldBeFalse()
            Quinoa.laParcelaEsIdeal(ParcelaEco).shouldBeFalse()
            Quinoa.laParcelaEsIdeal(ParcelaIndu).shouldBeFalse()
        }
    }
})

