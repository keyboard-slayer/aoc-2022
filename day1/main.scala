import scala.io.Source

@annotation.tailrec
def zipElves(in: List[String], acc: List[List[Int]] = List(), tmp: List[String] = List()): List[List[Int]] = 
    if (in.isEmpty) acc
    else in.head match
        case "" => zipElves(in.tail, acc :+ tmp.map(_.toInt), List())
        case _ => zipElves(in.tail, acc, tmp :+ in.head)


def part1(input: List[String]): Int = 
    zipElves(input).map(_.sum).max

def part2(input: List[String]): Int =
    zipElves(input).map(_.sum).sortWith(_ > _).take(3).sum

def main(args: Array[String]): Unit = 
    val input = Source.fromFile("input").mkString.split("\n").toList
    println(s"Part 1: ${part1(input)}")
    println(s"Part 2: ${part2(input)}")