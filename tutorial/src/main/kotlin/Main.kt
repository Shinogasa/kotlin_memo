/**
 * https://zenn.dev/tokium_dev/articles/dependency-injection-watanabe
 * https://irof.hateblo.jp/entry/2017/04/16/222737
 */

/**
 * コンストラクタ: インスタンス化したとき自動で呼び出される機能
 * プライマリコンストラクタ：クラスに1つだけ
 * class クラス名 constructor(引数: データ型) {}
 * constructorは省略可
 */

class Car(
    // engineのコンストラクタ引数はプロパティの宣言と初期化を省略している
    private val engine: Engine,
    private val tire: Tire
) {
    /**
     * セカンダリコンストラクタ：クラスに0個以上、最終的に必ずプライマリコンストラクタを呼ぶ必要がある
     * constructor(引数: データ型): this(引数)
     */
    constructor(engine: Engine) : this(engine = Engine(), Tire("Comfort"))

    fun start() {
        println("const")
        engine.start()
    }

    fun tireType() {
        tire.type()
    }
}

class Engine {
    fun start() {
        println("Booooooom")
    }
}

class Tire(private val type: String) {
    fun type() {
        println("This tire is $type")
    }
}


fun main(args: Array<String>) {
    val engine = Engine()
    val tire = Tire("Sport")

    val constCar = Car(engine, tire)
    constCar.start()
    constCar.tireType()

    val secondConstCar = Car(engine)
    secondConstCar.start()
    secondConstCar.tireType()

}
