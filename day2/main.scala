import scala.io.Source

def main(args: Array[String]): Unit = 
    val input = Source.fromFile("input")
                .mkString
                .split("\n")
                .map(_.split(" ").map(_ match
                    case "A" | "X" => 1
                    case "B" | "Y" => 2
                    case "C" | "Z" => 3)
                )

    val part1 = input.map(game => (game(0), game(1)) match
            case (2, 1) | (3, 2) | (1, 3) => (6 + game(0), 0 + game(1))
            case (1, 2) | (2, 3) | (3, 1) => (0 + game(0), 6 + game(1))
            case _ => (3 +game(0) , 3 + game(1)))
            .map(_._2).sum

    val part2 = input.foldLeft(0)((acc, game) => 
        if (game(1) == 1) then game(0) match 
            case 1 => acc + 3
            case 2 => acc + 1
            case _ => acc + 2
        
        else if (game(1) == 2) then game(0) match 
            case 1 => 4 + acc
            case 2 => 5 + acc 
            case _ => 6 + acc

        else game(0) match 
            case 1 => 8 + acc 
            case 2 => 9 + acc 
            case 3 => 7 + acc
    )

    println(s"Part 1: ${part1}")
    println(s"Part 2: ${part2}")