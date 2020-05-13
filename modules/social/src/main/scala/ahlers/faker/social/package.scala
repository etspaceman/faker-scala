package ahlers.faker

import eu.timepit.refined.api._
import eu.timepit.refined.boolean._
import eu.timepit.refined.collection._
import eu.timepit.refined.string._
import io.estatico.newtype.macros.newtype

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since May 11, 2020
 */
package object social {

  type CompanyIdType = String Refined (NonEmpty And Trimmed)
  @newtype case class CompanyId(toText: CompanyIdType)

  type CompanyNameType = String Refined (NonEmpty And Trimmed)
  @newtype case class CompanyName(toText: CompanyNameType)

  type CompanyWebsiteType = String Refined (NonEmpty And Trimmed And Uri)
  @newtype case class CompanyWebsite(toText: CompanyWebsiteType)

}
