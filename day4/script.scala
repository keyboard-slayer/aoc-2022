import scala.io.Source

def generateRange(range: Array[String]): List[Int] = List.range(range(0).toInt, range(1).toInt + 1) 

def main(args: Array[String]): Unit = 
    val items = Source.fromFile("input")
                .mkString
                .split("\n")
                .map(_.split(",").toList)
                .toList

    val part1 = items.map(_.map((x: String) => generateRange(x.split("-"))))
                .map((r) => if r(0).length < r(1).length then r(0).map(r(1) contains _)
                            else r(1).map(r(0) contains _))
                .filter((l) => l == List.range(1, l.length + 1).map(_ > 0))
                .length
        
    val part2 = items.map(_.map((x: String) => generateRange(x.split("-"))))
                .map((r) => if r(0).length < r(1).length then r(0).map(r(1) contains _)
                            else r(1).map(r(0) contains _))
                .filter(_ contains true)
                .length

    println(s"Part 1: ${part1}")
    println(s"Part 2: ${part2}")