class MainViewModel {

    var repo = Repository()

    fun getName(matnr: Int): String {
        return repo.sqlString("select name from students where matnr=$matnr")
    }

    fun getStudent(matnr: Int): Student {
        return repo.sqlStudent(matnr)
    }
}