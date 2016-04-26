import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import org.apache.http.HttpStatus


/**
 * Created by hongkailiu on 2016-04-24.
 */
class BasicSimulation extends Simulation {
  val feeder = csv("input.csv").random

  val httpConf = http // 4
    .baseURL("http://192.168.31.223:8090")// 5
    .acceptHeader("application/json;charset=UTF-8") // 6
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  val scn = scenario("BasicSimulation") // 7
    .exec(http("/stat/general")  // 8
    .get("/stat/general").check(status.is(HttpStatus.SC_OK))) // 9
    .pause(1) // 10
    .feed(feeder)
    .exec(http("/calc/add")
      .get("/calc/add?arg1=${arg1}&arg2=${arg2}").check(status.is(HttpStatus.SC_OK)))

  setUp(// 11
    scn.inject(
      //atOnceUsers(1)
      constantUsersPerSec(6) during(60 seconds)
    ) // 12
  ).protocols(httpConf) // 13
}
