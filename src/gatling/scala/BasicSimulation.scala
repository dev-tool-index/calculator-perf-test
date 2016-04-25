import io.gatling.core.Predef._ // 2
import io.gatling.http.Predef._
import scala.concurrent.duration._

/**
  * Created by hongkailiu on 2016-04-24.
  */
class BasicSimulation extends Simulation {
  val httpConf = http // 4
    .baseURL("http://192.168.31.223:8090")// 5
    .acceptHeader("application/json;charset=UTF-8") // 6
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  val scn = scenario("BasicSimulation") // 7
    .exec(http("/stat/general")  // 8
    .get("/stat/general")) // 9
    .pause(5) // 10

  setUp( // 11
    scn.inject(atOnceUsers(1)) // 12
  ).protocols(httpConf) // 13
}
