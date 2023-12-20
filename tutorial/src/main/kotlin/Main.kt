/**
 * https://zenn.dev/tokium_dev/articles/dependency-injection-watanabe
 * https://irof.hateblo.jp/entry/2017/04/16/222737
 */

// classにコンストラクタ無いときは()省略できるみたい
class CarNotDi {
    /**
     * Carのインスタンスを動かす（start関数を呼ぶ）ためにEngineのインスタンスが不可欠
     * 「CarはEngineに依存している」
     */
    private val engine = Engine()

    fun start() {
        println("not di")
        engine.start()
    }
}

// コンストラクタインジェクション
class CarConstDi(
    // コンストラクタ: インスタンス化したとき自動で呼び出される機能
    private val engine: Engine
) {
    fun start() {
        println("const")
        engine.start()
    }
}

// セッターインジェクション
class CarSetterDi{
    private lateinit var engine: Engine
    fun setter(setEngine: Engine) {
        this.engine = setEngine
    }

    fun start() {
        println("setter")
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

    // コンストラクタインジェクション
    val constCar = CarConstDi(engine)
    constCar.start()

    // セッターインジェクション
    val setterCar = CarSetterDi()
    setterCar.setter(engine)
    setterCar.start()
}
