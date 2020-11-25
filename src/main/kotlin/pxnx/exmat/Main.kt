package pxnx.exmat

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val view = View()
        view.init()

        val repo = Repository()
        repo.showAll()
        repo.sql("select * from students")
    }
}