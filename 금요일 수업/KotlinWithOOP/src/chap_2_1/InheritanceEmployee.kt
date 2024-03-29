package chap_2_1

import java.text.NumberFormat
import java.util.*

open class Employee(open val userName: String, open val department: String): Any(){
    open fun calculateTheSalary() = 0
    override fun toString() = """$userName 님의 부서는 $department 이며 월급은 총 """
}
class PermanentEmp(override var userName: String,
                override var department: String,
                private val annualSalary:Int): Employee(userName, department){

    override fun calculateTheSalary() = annualSalary.div(12)

}
class PartTimeEmp(override val userName: String,
                        override val department: String,
                        private val workingHour: Int,
                        private val hourlyRate: Int): Employee(userName,department){

    override fun calculateTheSalary() = workingHour.times(hourlyRate)
}
fun main(){
    val pEmp = PermanentEmp("고정직", "개발실", 50000000)
    val tEmp = PartTimeEmp("임시직", "고객대응팀",90, 15000)

    val pEmpResult = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(pEmp.calculateTheSalary())
    val tEmpResult = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(tEmp.calculateTheSalary())
    println("""$pEmp $pEmpResult 입니다""")
    println("""$tEmp $tEmpResult 입니다""")
}