package com.listvictortercero.model

data class Ikea(
    val name: String ="",
    val category: String ="",
    var favorite:Boolean= false
){
    companion object{
        fun getData(): List<Ikea>{
            return listOf(
                Ikea("LAGKAPTEN", "Mesa"),
                Ikea("BILLY", "Estantería"),
                Ikea("KALLAX", "Estantería"),
                Ikea("MALM", "Cómoda"),
                Ikea("POÄNG", "Sillón"),
                Ikea("BRIMNES", "Armario"),
                Ikea("EKET", "Estantería"),
                Ikea("LACK", "Mesa de centro"),
                Ikea("HEMNES", "Cómoda"),
                Ikea("RÅSKOG", "Carrito"),
                Ikea("FRIHETEN", "Sofá cama"),
                Ikea("KNOPPARP", "Sofá"),
                Ikea("KVISTBRO", "Mesa auxiliar"),
                Ikea("IVAR", "Estantería"),
                Ikea("FLISAT", "Mesa para niños"),
                Ikea("VITTSJÖ", "Mesa auxiliar"),
                Ikea("PAX", "Armario"),
                Ikea("NORDLI", "Cómoda"),
                Ikea("SINNERLIG", "Lámpara"),
                Ikea("STOCKHOLM", "Sillón")
            )
        }
    }
}
