import scala.io.Source

@annotation.tailrec
def groupBy3(sack: List[String], acc: List[List[String]] = List()): List[List[String]] =
    if (sack.isEmpty) acc
    else if (sack.length < 3) acc :+ sack
    else groupBy3(sack.drop(3), acc :+ sack.take(3))

def main(args: Array[String]): Unit = 
    val items = Source.fromFile("input")
                .mkString
                .split("\n")
                .toList
    
    val part1 = items.map((compa) => List(
                    compa.slice(0, compa.length / 2), 
                    compa.slice(compa.length / 2, compa.length)))
                .map((compa) => compa(0).filter(compa(1) contains _)).map(_(0))
                .map((x: Char) => if x.isUpper then (x - 'A') + 27 else (x - 'a') + 1).sum
    
    val part2 = groupBy3(items)
                .map((compa) => compa(0).filter((x: Char) => (compa(1) contains x) && (compa(2) contains x)))
                .map(_(0))
                .map((x: Char) => if x.isUpper then (x - 'A') + 27 else (x - 'a') + 1).sum

    println(s"Part 1: ${part1}")
    println(s"Part 2: ${part2}")
