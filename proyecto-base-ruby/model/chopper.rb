class Chopper

  def chop(n, array)
    return array.index(n) ? array.index(n) : -1
  end
  
  def sum(array)
    if array.empty?
      return "vacio"
    end
    sum = 0
    array.each { |x| sum += x }
    if sum - 100 >= 0
      return "demasiado grande"
    end
    numbers = numbers_to_text()
    first_digit, second_digit = sum.to_s.split('')
    result = numbers[first_digit]
    if not second_digit.nil?
      result += "," + numbers[second_digit]
    end
    return result
  end
  
  def numbers_to_text()
    return {
        "0" => "cero",
        "1" => "uno",
        "2" => "dos",
        "3" => "tres",
        "4" => "cuatro",
        "5" => "cinco",
        "6" => "seis",
        "7" => "siete",
        "8" => "ocho",
        "9" => "nueve"
        }
  end
end
