package hello.thymeleaf.basic

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/basic")
class BasicController {
  @GetMapping("text-basic")
  fun textBasic(model: Model): String {
    model.addAttribute("data", "Hello <b> Spring! </b>")
    return "basic/text-basic"
  }

  @GetMapping("text-unescaped")
  fun textUnescaped(model: Model): String {
    model.addAttribute("data", "Hello <b> Spring! </b>")
    return "basic/text-unescaped"
  }

  @GetMapping("/variable")
  fun variable(model: Model): String {
    val userA = User("userA", 10)
    val userB = User("userB", 20)

    val users = listOf(userA, userB)
    val map = mapOf("userA" to userA, "userB" to userB)

    model.addAttribute("user", userA)
    model.addAttribute("users", users)
    model.addAttribute("userMap", map)

    return "basic/variable"
  }

  class User constructor(val username: String, val age: Int) {

  }
}