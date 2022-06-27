import com.creditas.kotlinshell.shell.example.*
import junit.framework.TestCase
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class Test_Greet {
    @BeforeEach
    fun init() {
        MockitoAnnotations.openMocks(this)
    }

    @Mock
    lateinit var b : B

    @Mock
    lateinit var f : F

    @Mock
    lateinit var h : H

    @Mock
    lateinit var c : C

    @Mock
    lateinit var d : D

    @Mock
    lateinit var e : E

    @Mock
    lateinit var g : G


    @Test
    fun `when class A is called, it should call class b and f and return "I am A"`() {
        val a = A(b, f)
        val result = a.greet()


        Mockito.verify(b, Mockito.times(1)).greet()
        Mockito.verify(f, Mockito.times(1)).greet()

        TestCase.assertEquals("I am A", result)
    }

    @Test
    fun `when class B is called, it should call class c and d and return "I am B"`() {
        val b = B(c,d)
        val result = b.greet()


        Mockito.verify(c, Mockito.times(1)).greet()
        Mockito.verify(d, Mockito.times(1)).greet()

        TestCase.assertEquals("I am B", result)
    }

    @Test
    fun `when class C is called, it should return "I am C"`() {
        val c = C()
        val result = c.greet()
        TestCase.assertEquals("I am C", result)
    }

    @Test
    fun `when class D is called, it should call class e and return "I am B"`() {
        val d = D(e)
        val result = d.greet()


        Mockito.verify(e, Mockito.times(1)).greet()


        TestCase.assertEquals("I am D", result)
    }

    @Test
    fun `when class E is called, it should return "I am E"`() {
        val e = E()
        val result = e.greet()

        TestCase.assertEquals("I am E", result)
    }

    @Test
    fun `when class F is called, it should call class g and return "I am F"`() {
        val f = F(g)
        val result = f.greet()


        Mockito.verify(g, Mockito.times(1)).greet()


        TestCase.assertEquals("I am F", result)
    }

    @Test
    fun `when class G is called, it should call class e and h and return "I am G"`() {
        val g = G(e,h)
        val result = g.greet()


        Mockito.verify(e, Mockito.times(1)).greet()
        Mockito.verify(h, Mockito.times(1)).greet()


        TestCase.assertEquals("I am G", result)
    }

    @Test
    fun `when class H is called, it should call return "I am F"`() {
        val h = H()
        val result = h.greet()

        TestCase.assertEquals("I am H", result)
    }
}