/*
 * This Scala Testsuite was auto generated by running 'gradle init --type scala-library'
 * by 'hongkailiu' at '24/04/16 4:41 PM' with Gradle 2.10
 *
 * @author hongkailiu, @date 24/04/16 4:41 PM
 */

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class LibrarySuite extends FunSuite {
  test("someLibraryMethod is always true") {
    def library = new Library()
    assert(library.someLibraryMethod)
  }
}
