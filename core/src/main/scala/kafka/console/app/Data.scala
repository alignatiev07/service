package kafka.console
package app

import model.topics._
import core.services._


trait Data {

  import scalaz.Kleisli, scalaz.syntax.kleisli._

  private val topics: TopicsK[TopicService] = Kleisli.ask

  val getTopics: TopicsK[Vector[Topic]] = for {
    s <- topics
    t <- s.getTopics.liftKleisli
  } yield t

}
