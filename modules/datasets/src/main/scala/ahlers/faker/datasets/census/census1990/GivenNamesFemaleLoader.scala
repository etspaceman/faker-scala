package ahlers.faker.datasets.census.census1990

import ahlers.faker.models._
import eu.timepit.refined.api.Refined

import scala.io.Source

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since May 16, 2020
 */
class GivenNamesFemaleLoader {

  private val source =
    Source.fromInputStream(
      Thread.currentThread()
        .getContextClassLoader()
        .getResourceAsStream("www2.census.gov/topics/genealogy/1990surnames/dist.female.first"))

  def givenNames(): Iterator[ClassifiedGivenName] = {
    import Gender._

    source
      .getLines()
      .map { row =>
        val name = row.slice(0, 15).trim()
        val rank = row.slice(29, 34).trim().toInt
        ClassifiedGivenName(
          Female,
          PersonGivenName(Refined.unsafeApply(name)),
          NameRank(Refined.unsafeApply(rank))
        )
      }
  }

  def close(): Unit = source.close()

}

object GivenNamesFemaleLoader {
  def apply(): GivenNamesFemaleLoader = new GivenNamesFemaleLoader
}