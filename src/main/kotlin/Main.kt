fun main() {
    Solution().addTwoNumbers(
        l1 = ListNode(6).apply { next = ListNode(5) },
        l2 = ListNode(4).apply { next = ListNode(4) }
    ).apply { println(`val`) }
}

class Solution {
    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode {
        val head = ListNode(l1.`val` + l2.`val`)
        val values = mutableListOf(head)

        var next1 = l1.next
        var next2 = l2.next
        var currentNode = head
        while (next1 != null && next2 != null) {
            var value = next1.`val` + next2.`val`
            if (value > 9) {
                value %= 10
                for (index in values.lastIndex downTo 0) {
                    val nodeInLoop = values[index]
                    nodeInLoop.`val` += 1
                    if (nodeInLoop.`val` > 9) {
                        nodeInLoop.`val` %= 10
                    } else {
                        break
                    }
                }
            }
            val node = ListNode(value)

            currentNode.next = node
            currentNode = node

            values.add(node)

            next1 = next1.next
            next2 = next2.next
        }

        for (index in values.lastIndex downTo 0) {
            if (index == 0) break

            values[index].next = values[index - 1]
        }

        return values.last()
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}