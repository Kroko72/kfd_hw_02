interface Move{
    fun start(){
        return println("завёлся")
    }
    fun stop(){
        return println("заглушился")
    }
}

sealed class Transport: Move{
    abstract val name: String

    class Moto(val naming: String): Transport(){
        override val name: String = naming
    }
    class Auto(val naming: String): Transport(){
        override val name: String = naming
    }

    class Metro(val naming: String): Transport(){
        override val name: String = naming
        override fun start() {
            return println("начал движение")
        }

        override fun stop() {
            return println("остановился")
        }
    }

    class Plain(val naming: String): Transport(){
        override val name: String = naming

        override fun start() {
            return println("взлетел")
        }
        override fun stop() {
            return println("приземлился")
        }
    }
}


fun main() {
    println("Выберите тип транспорта: \n1)Мотоцикл\n2)Автомобиль\n3)Метро\n4)Самолёт")
    val choose = readlnOrNull()
    val transport: Transport
    when(choose){
        "1", "2", "3", "4" ->{
            println("Введите название транспорта: ")
            val n = readlnOrNull().toString()
            if(n == "") println("Некорректное название")
            else {
                if(choose == "1") transport = Transport.Moto(n)
                else if(choose == "2") transport = Transport.Auto(n)
                else if(choose == "3") transport = Transport.Metro(n)
                else transport = Transport.Plain(n)
                print("Транспорт ${transport.name} ")
                transport.start()
                Thread.sleep(3000)
                print("Транспорт ${transport.name} ")
                transport.stop()
            }
        }
        else -> {
            println("Некорректный ввод")
        }
    }
}