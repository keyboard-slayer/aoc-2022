import scala.io.Source 

@annotation.tailrec
def part2(in: String, start: Int = 0): Int =
    if (in.slice(0, 14).toSet.size == 14) start + 14
    else part2(in.drop(1), start + 1)

@annotation.tailrec
def part1(in: String, start: Int = 0): Int =
    if (in.slice(0, 4).toSet.size == 4) start + 4
    else part1(in.drop(1), start + 1)

def main(args: Array[String]): Unit =
    val input = Source.fromFile("input").mkString.strip
    println(part1(input))
    println(part2(input))