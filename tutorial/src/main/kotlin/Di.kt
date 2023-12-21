class NotDiCar {
    /**
     * Carのインスタンスを動かす（start関数を呼ぶ）ためにEngineのインスタンスが不可欠
     * 「CarはEngineに依存している」
     */
    private val engine = DiEngine()

    fun start() {
        println("not di")
        engine.start()
    }
}

// コンストラクタインジェクション
class ConstDiCar(
    private val engine: DiEngine,
) {
    fun start() {
        println("const")
        engine.start()
    }
}

// セッターインジェクション
class SetterDiCar {
    private lateinit var engine: DiEngine
    fun setter(setEngine: DiEngine) {
        this.engine = setEngine
    }

    fun start() {
        println("setter")
        engine.start()
    }
}

class DiEngine {
    fun start() {
        println("Booooooom")
    }
}

class DiTire(private val type: String) {
    fun type() {
        println("This tire is $type")
    }
}

fun main() {
    val notDiCar = NotDiCar()
    notDiCar.start()

    val engine = DiEngine()

    // コンストラクタインジェクション
    val constCar = ConstDiCar(engine)
    constCar.start()

    // セッターインジェクション
    val setterCar = SetterDiCar()
    setterCar.setter(engine)
    setterCar.start()
}
