class Test1() {
    lateinit var apiClient: ApiClient
    constructor(apiClient: ApiClient) {
        this.apiClient = apiClient
    }

    fun hoge() {
        this.apiClient.call()
    }
}

class Test2(private val apiClient: ApiClient) {
    fun hoge() {
        this.apiClient.call()
    }

}

class Test3() {
    lateinit var apiClient: ApiClient

    fun build(apiClient: ApiClient) {
        this.apiClient = apiClient
    }

    fun hoge() {
        this.apiClient.call()
    }
}

class ApiClient() {
    fun call() {
        println("Hello world")
    }
}

class TestApiClient(): ApiClient {
    override fun call {
        println("Goodbye world")
    }
}

fun main() {
    val a = Test1(ApiClient())
    val b = Test1(TestApiClient())
    a.hoge()
    b.hoge()

    val c = Test2(ApiClient())
    c.hoge()

    val d = Test3()
    d.build(ApiClient())
    d.hoge()

    val e = Test3()
    e.hoge()
}

// d.build().hoge()で呼べるようになるためには？
