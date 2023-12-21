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

/**
 * コンストラクタ: インスタンス化したとき自動で呼び出される機能
 * プライマリコンストラクタ：クラスに1つだけ
 * class クラス名 constructor(引数: データ型) {}
 * constructorは省略可
 */

class CarConstDi(
    // engineのコンストラクタ引数はプロパティの宣言と初期化を省略している
    private val engine: Engine,
    // constTireは通常のコンストラクタの書き方
    constTire: Tire
) {
    /**
     * セカンダリコンストラクタ：クラスに0個以上、最終的に必ずプライマリコンストラクタを呼ぶ必要がある
     * constructor(引数: データ型): this(引数)
     *
     */
    constructor(secondConstEngine: Engine) : this(engine = Engine(), Tire("Confort"))

    private var tire: Tire
    init {
        // init{}内でコンストラクタ引数にアクセスできる
        this.tire = constTire
    }

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

class Tire(val type: String) {}

fun main(args: Array<String>) {
    val carNotDi = CarNotDi()
    carNotDi.start()

    val engine = Engine()
    val tire = Tire("Sport")

    // コンストラクタインジェクション
    val constCar = CarConstDi(engine, tire)
    constCar.start()

    // セッターインジェクション
    val setterCar = CarSetterDi()
    setterCar.setter(engine)
    setterCar.start()
}
