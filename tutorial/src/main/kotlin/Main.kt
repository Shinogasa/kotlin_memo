/**
 * https://zenn.dev/tokium_dev/articles/dependency-injection-watanabe
 */

// classにコンストラクタ無いときは()省略できるみたい
class CarNotDi {
    /**
     * Carのインスタンスを動かす（start関数を呼ぶ）ためにEngineのインスタンスが不可欠
     * 「CarはEngineに依存している」
     */
    private val engine = Engine()

    fun start() {
        engine.start()
    }
}

// コンストラクタインジェクション
// コンストラクタ: インスタンス化したとき自動で呼び出される機能
class CarDi(private val engine: Engine) {
    fun start() {
        engine.start()
    }
}

class Engine {
    fun start() {
        println("Booooooom")
    }
}


fun main(args: Array<String>) {
    val carNotDi = CarNotDi()
    carNotDi.start()

    val engine = Engine()
    val car = CarDi(engine)
    car.start()
}
