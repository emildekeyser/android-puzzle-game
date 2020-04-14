package com.example.thewitnesspuzzles.service

import com.example.thewitnesspuzzles.model.Line
import com.example.thewitnesspuzzles.model.Maze
import com.example.thewitnesspuzzles.model.Node
import com.example.thewitnesspuzzles.model.NodeType
import java.io.Serializable

class MazeFactory: Serializable {
    private val start = Node(0, 0, NodeType.START)
    private val end = Node(1, 0, NodeType.END)
    private val line = Line(start, end)
    var maze = Maze(0, setOf(line))

    fun createSmallLineMaze() {
        println("maze 1 set")
        val start = Node(0, 0, NodeType.START)
        val end = Node(1, 0, NodeType.END)
        val line = Line(start, end)
        maze = Maze(0, setOf(line))
    }

    fun createMediumLineMaze() {
        println("maze 2 set")
        val start = Node(0, 0, NodeType.START)
        val middle = Node(1, 0, NodeType.MIDDLE)
        val end = Node(2, 0, NodeType.END)
        val line1 = Line(start, middle)
        val line2 = Line(middle, end)
        maze = Maze(0, setOf(line1, line2))
    }

    fun createCornerMaze() {
        println("maze 3 set")
        val start = Node(0, 0, NodeType.START)
        val middle = Node(0, 1, NodeType.MIDDLE)
        val end = Node(1, 1, NodeType.END)
        val line1 = Line(start, middle)
        val line2 = Line(middle, end)
        maze = Maze(0, setOf(line1, line2))
    }

    fun createSnake(): Maze {
        val start = Node(0, 0, NodeType.START)
        val n1 = Node(1, 0, NodeType.MIDDLE)
        val n2 = Node(1, 1, NodeType.MIDDLE)
        val n3 = Node(0, 1, NodeType.MIDDLE)
        val n4 = Node(0, 2, NodeType.MIDDLE)
        val end = Node(1, 2, NodeType.END)
        val line1 = Line(start, n1)
        val line2 = Line(n1, n2)
        val line3 = Line(n2, n3)
        val line4 = Line(n3, n4)
        val line5 = Line(n4, end)
        return Maze(0, setOf(line1, line2, line3, line4, line5))
    }

    fun createEight(): Maze {
        val start = Node(0, 0, NodeType.START)
        val n1 = Node(1, 0, NodeType.MIDDLE)
        val n2 = Node(1, 1, NodeType.MIDDLE)
        val n3 = Node(0, 1, NodeType.MIDDLE)
        val n4 = Node(0, 2, NodeType.MIDDLE)
        val end = Node(1, 2, NodeType.END)
        val line1 = Line(start, n1)
        val line2 = Line(n1, n2)
        val line3 = Line(n2, n3)
        val line4 = Line(n3, n4)
        val line5 = Line(n4, end)

        val line6 = Line(start, n3)
        val line7 = Line(n2, end)
        return Maze(0, setOf(line1, line2, line3, line4, line5, line6, line7))
    }


    fun createLevelOne() {
        val start = Node(0, 0, NodeType.START)
        val end = Node(4, 4, NodeType.END)
        val na = Node(1,0,NodeType.MIDDLE)
        val nb = Node(2,0,NodeType.MIDDLE)
        val nc = Node(3,0,NodeType.MIDDLE)
        val nd = Node(4,0,NodeType.MIDDLE)
        val ne = Node(0,1,NodeType.MIDDLE)
        val nf = Node(1,1,NodeType.MIDDLE)
        val ng = Node(2,1,NodeType.MIDDLE)
        val nh = Node(3,1,NodeType.MIDDLE)
        val ni = Node(4,1,NodeType.MIDDLE)
        val nj = Node(0,2,NodeType.MIDDLE)
        val nk = Node(1,2,NodeType.MIDDLE)
        val nl = Node(2,2,NodeType.MIDDLE)
        val nm = Node(3,2,NodeType.MIDDLE)
        val nn = Node(0,3,NodeType.MIDDLE)
        val no = Node(1,3,NodeType.MIDDLE)
        val np = Node(2,3,NodeType.MIDDLE)
        val nq = Node(3,3,NodeType.MIDDLE)
        val nr = Node(4,3,NodeType.MIDDLE)
        val ns = Node(0,4,NodeType.MIDDLE)
        val a = Line(start,na)
        val b = Line(nb,nc)
        val c = Line(nc,nd)
        val d = Line(na,nf)
        val e = Line(nb,ng)
        val f = Line(nc,nh)
        val g = Line(nf,ng)
        val h = Line(ng,nh)
        val i = Line(nh,ni)
        val j = Line(ne,nj)
        val k = Line(ng,nl)
        val l = Line(ni,nr)
        val m = Line(nk,no)
        val n = Line(nl,nf)
        val o = Line(nm,nq)
        val p = Line(nn,no)
        val q = Line(nf,nq)
        val r = Line(nn,ns)
        val s = Line(ns,end)
        maze = Maze(0,setOf(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s))
    }

    fun createLevelTwo() {
        val start = Node(0,3,NodeType.START)
        val end = Node(3,0,NodeType.END)
        val a = Node(1,3,NodeType.MIDDLE)
        val b = Node(3,3,NodeType.MIDDLE)
        val c = Node(0,2,NodeType.MIDDLE)
        val d = Node(1,2,NodeType.MIDDLE)
        val e = Node(2,2,NodeType.MIDDLE)
        val f = Node(3,2,NodeType.MIDDLE)
        val g = Node(0,1,NodeType.MIDDLE)
        val h = Node(1,1,NodeType.MIDDLE)
        val i = Node(2,1,NodeType.MIDDLE)
        val j = Node(1,0,NodeType.MIDDLE)
        val k = Node(2,0,NodeType.MIDDLE)
        val linea = Line(start,a)
        val lineb = Line(a,b)
        val linec = Line(start,c)
        val lined = Line(a,d)
        val linee = Line(b,f)
        val linef = Line(c,d)
        val lineg = Line(d,e)
        val lineh = Line(e,f)
        val linei = Line(c,g)
        val linej = Line(d,h)
        val linek = Line(e,i)
        val linel = Line(f,end)
        val linem = Line(g,h)
        val linen = Line(h,i)
        val lineo = Line(h,j)
        val linep = Line(i,k)
        val lineq = Line(k, end)
        maze = Maze(0, setOf(linea,lineb,linec,lined,linee,linef,lineg,lineh,linei,linej,linek,linel,linem,linen,lineo,linep,lineq))
    }

    fun createLevelThree() {
        val start = Node(0,1,NodeType.START)
        val a = Node(0,0,NodeType.MIDDLE)
        val b = Node(2,0,NodeType.MIDDLE)
        val c = Node(5,0,NodeType.MIDDLE)
        val d = Node(1,1,NodeType.MIDDLE)
        val e = Node(2,1,NodeType.MIDDLE)
        val f = Node(3,1,NodeType.MIDDLE)
        val g = Node(4,1,NodeType.MIDDLE)
        val h = Node(5,1,NodeType.MIDDLE)
        val i = Node(6,1,NodeType.MIDDLE)
        val j = Node(0,2,NodeType.MIDDLE)
        val k = Node(1,2,NodeType.MIDDLE)
        val l = Node(2,2,NodeType.MIDDLE)
        val m = Node(3,2,NodeType.MIDDLE)
        val n = Node(4,2,NodeType.MIDDLE)
        val o = Node(5,2,NodeType.MIDDLE)
        val p = Node(6,2,NodeType.MIDDLE)
        val q = Node(0,3,NodeType.END)
        val r = Node(2,3,NodeType.MIDDLE)
        val s = Node(4,3,NodeType.MIDDLE)
        val t = Node(5,3,NodeType.MIDDLE)
        val u = Node(1,4,NodeType.MIDDLE)
        val v = Node(2,4,NodeType.MIDDLE)
        val w = Node(3,4,NodeType.MIDDLE)
        val x = Node(4,4,NodeType.MIDDLE)
        val y = Node(6,4,NodeType.MIDDLE)
        val z = Node(1,5,NodeType.MIDDLE)
        val aa = Node(2,5,NodeType.MIDDLE)
        val ab = Node(3,5,NodeType.MIDDLE)
        val ac = Node(4,5,NodeType.MIDDLE)
        val ad = Node(5,5,NodeType.MIDDLE)
        //val ae = Node(6,5,NodeType.MIDDLE)
        val af = Node(0,6,NodeType.MIDDLE)
        val ag = Node(2,6,NodeType.MIDDLE)
        val ah = Node(3,6,NodeType.MIDDLE)
        val ai = Node(4,6,NodeType.MIDDLE)
        val aj = Node(5,6,NodeType.MIDDLE)
        val ak = Node(6,6,NodeType.MIDDLE)
        val linea = Line(start,a)
        val lineb = Line(a,b)
        val linec = Line(b,c)
        val lined = Line(b,e)
        val linee = Line(c,i)
        val linef = Line(d,k)
        val lineg = Line(f,g)
        val lineh = Line(f,m)
        val linei = Line(g,n)
        val linej = Line(h,o)
        val linek = Line(h,i)
        val linel = Line(j,k)
        val linem = Line(l,m)
        val linen = Line(m,n)
        val lineo = Line(n,o)
        val linep = Line(k,u)
        val lineq = Line(l,r)
        val liner = Line(r,s)
        val lines = Line(o,t)
        val linet = Line(p,y)
        val lineu = Line(s,x)
        val linev = Line(r,v)
        val linew = Line(u,v)
        val linex = Line(w,x)
        val liney = Line(x,y)
        val linez = Line(v,z)
        val lineaa = Line(q,af)
        val lineab = Line(af,ag)
        val lineac = Line(ag,aa)
        val linead = Line(aa,ab)
        val lineae = Line(ag,ah)
        val lineaf = Line(ab,ac)
        val lineag = Line(ac,ai)
        val lineah = Line(ai,aj)
        val lineai = Line(aj,ak)
        val lineaj = Line(aj,ad)
        val lineak = Line(ak,y)
        maze = Maze(0, setOf(linea,lineb,linec,lined,linee,linef,lineg,lineh,linei,linej,linek,linel,linem,linen,lineo,linep,lineq,liner,lines,linet,lineu,linev,linew,linex,liney,linez,lineaa,lineab,lineac,linead,lineae,lineaf,lineag,lineah,lineai,lineaj,lineak))

    }

    // kan de functie niet getMaze noemen? geeft een conflict ergens in het domain?
    fun getServiceMaze(): Maze {
        return maze;
    }

}