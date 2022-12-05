import scala.io.Source

@annotation.tailrec
def part1(ins: List[List[Int]], stack: List[List[String]]): List[String] = 
    if (ins.isEmpty) stack.map((s) => s(s.length - 1))
    else
        val toAdd = stack(ins.head(1)-1).takeRight(ins.head(0)).reverse
        val n = stack.zipWithIndex.map((s) => if (s(1) == (ins.head(1)-1)) s(0).slice(0, s(0).length - ins.head(0))
                                            else if (s(1) == (ins.head(2)-1)) s(0) ++ toAdd
                                            else s(0))
        part1(ins.tail, n)

@annotation.tailrec
def part2(ins: List[List[Int]], stack: List[List[String]]): List[String] = 
    if (ins.isEmpty) stack.map((s) => s(s.length - 1))
    else
        val toAdd = stack(ins.head(1)-1).takeRight(ins.head(0))
        val n = stack.zipWithIndex.map((s) => if (s(1) == (ins.head(1)-1)) s(0).slice(0, s(0).length - ins.head(0))
                                            else if (s(1) == (ins.head(2)-1)) s(0) ++ toAdd
                                            else s(0))
        part2(ins.tail, n)

def main(args: Array[String]): Unit =
    val input = Source.fromFile("input")
                .mkString
                .split("\n")
                .toList

    val stacks = input
                .takeWhile(!_.isEmpty)
                .dropRight(1)
                .map(_.replaceAll("\\s{2}+", "_").replace("__", " _ "))
                .map(_.replace("[", "").replace("]", "").split(" ").toList.filterNot(_.isEmpty))
                .transpose
                .map(_.filterNot(_ == "_").reverse)
          

    val instr = input
                .reverse
                .takeWhile(!_.isEmpty)
                .reverse
                .map(_.split(" ").toList
                    .filter(_.forall(_.isDigit))
                    .map(_.toInt))

    println(part1(instr, stacks))
    println(part2(instr, stacks))